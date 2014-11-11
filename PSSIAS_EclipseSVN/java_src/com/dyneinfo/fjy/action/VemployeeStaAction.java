/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.org.rapid_framework.beanutils.BeanUtils;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import org.security.userdetails.MyUserDetails;
import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.SpringTagFunctions;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.fjy.model.*;
import com.dyneinfo.fjy.dao.*;
import com.dyneinfo.fjy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class VemployeeStaAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/fjy/VemployeeSta/query.jsp";
	protected static final String TXLIST_JSP= "/pages/fjy/VemployeeSta/txlist.jsp";
	protected static final String LIST_JSP= "/pages/fjy/VemployeeSta/list.jsp";
	protected static final String CREATE_JSP = "/pages/fjy/VemployeeSta/create.jsp";
	protected static final String EDIT_JSP = "/pages/fjy/VemployeeSta/edit.jsp";
	protected static final String SHOW_JSP = "/pages/fjy/VemployeeSta/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/fjy/VemployeeSta/list.do";
	
	private VemployeeStaManager vemployeeStaManager;
	
	private VemployeeSta vemployeeSta;
	Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			vemployeeSta = new VemployeeSta();
		} else {
			vemployeeSta = (VemployeeSta)vemployeeStaManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setVemployeeStaManager(VemployeeStaManager manager) {
		this.vemployeeStaManager = manager;
	}	
	
	public Object getModel() {
		return vemployeeSta;
	}
	
	public void setDeptid(Long val) {
		this.id = val;
	}

	public void setItems(String[] items) {
		this.items = items;
	}
	
	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	public TreeMap<String, String> getDateSelectMap() {
		return dateSelectMap;
	}

	public void setDateSelectMap(TreeMap<String, String> dateSelectMap) {
		this.dateSelectMap = dateSelectMap;
	}

	/** 进入查询页面 */
	public String query() {
		//日历快速选择用到
		dateSelectMap  = DateUtil.getDateSelectData();
//		HttpServletRequest request = ServletActionContext.getRequest();
//		request.setAttribute("dateSelect","11");//选中本周
//		DateUtil tt = new DateUtil();     
//      pageRequest.getFilters().put("s_inTime_start",tt.getMondayOFWeek());//页面
//      pageRequest.getFilters().put("s_inTime_end",tt.getCurrentWeekday());//
		return QUERY_JSP;
	}
	
	/** 执行搜索 */
	public String list() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String s_deptlevel = "1";
		String s_deptseq = "";
		if (request.getParameter("s_deptseq") != null){
			s_deptseq = request.getParameter("s_deptseq");
			request.setAttribute("deptseq", s_deptseq);
		}
		
		String nativeplace =request.getParameter("s_nativeplace");
		
		String deptStartCond =" ";
		String empCond = " 1=1 ";
		String deptLevelCond = " 1=1 ";
		
		String deptStartCondFor9 =" t1.parentid is null ";
		String deptLevelCondFor9 = " 1=1 ";
		
		
		String username = "";
 		String deptid = "";
	    String deptseq = "";
	    String DeptLevel = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUserName();
			deptid = userDetail.getDeptID();
			deptseq = userDetail.getDeptSeq();
			DeptLevel = userDetail.getDeptLevel();
		}
		
		if (request.getParameter("s_deptseq") == null ||"".equals(request.getParameter("s_deptseq"))){
			request.setAttribute("deptseq", deptseq);
		}
		int x = Integer.parseInt(DeptLevel)+1;
		
		if(s_deptseq != null && s_deptseq.length() > 0){
			String ss[]  = s_deptseq.split("\\.");
			if(ss[1].equals(ss[2])){
				s_deptseq = s_deptseq.substring(5, s_deptseq.length());
			}
			
			
			deptStartCond = " d.deptseq = '"+s_deptseq+"'";
			empCond = empCond+" and  dep.deptseq like '"+s_deptseq+"%'";
			deptStartCondFor9 = " t1.deptseq = '"+s_deptseq+"'";
			s_deptlevel = vemployeeStaManager.getDeptLevelBySeq(s_deptseq);
		}else{
			deptStartCond = " d.deptseq = '"+deptseq+"'";
			empCond = empCond+" and  dep.deptseq like '"+deptseq+"%'";
			deptStartCondFor9 = " t1.deptseq = '"+deptseq+"'";
			s_deptlevel = vemployeeStaManager.getDeptLevelBySeq(deptseq);
			
		}
		if(nativeplace!=null&&!nativeplace.equals("")){
			empCond=empCond+" and t.nativeplace like '"+nativeplace+"%'";
			request.setAttribute("xzqhCode", nativeplace);
		}
		     
		
		if(s_deptlevel != null && s_deptlevel.length() > 0){
			int dep_level_int = Integer.parseInt(s_deptlevel);
			dep_level_int = dep_level_int+1;
			if(dep_level_int > 6)
				dep_level_int = 6;
			deptLevelCond =deptLevelCond+ " and dept.deptlevel = '"+dep_level_int+"' ";
			deptLevelCondFor9 =deptLevelCondFor9+ " and deptlevel = '"+dep_level_int+"' ";
		}
		
		
//		select t1.dictcode as id, t1.pid parent, num, level levs,t1.dictcontent   
//	    from temp_aa t1   
//	    left join (select t.dictcode, count(t.dictcode) num   
//	                 from temp_aa t   
//	                group by t.dictcode) t2 on t1.dictcode = t2.dictcode   
//	   start with t1.pid ='45'
//	  connect by prior t1.dictcode = t1.pid order by levs
		
		String statSqlFor10G = "  select dept.deptid,dept.deptname,dept.deptseq,dept.deptlevel,dept.status,oneZl,twoZl,threeZl,fourZl,nineZl,sumZl-twoZl as sumZl from  " 
			+ " (select a.root as id,nvl(sum(b.oneZl), 0) oneZl,nvl(sum(b.twoZl), 0) twoZl,nvl(sum(b.threeZl), 0) threeZl, "
			+ "  nvl(sum(b.fourZl), 0) fourZl,nvl(sum(b.nineZl), 0) nineZl,nvl(sum(b.sumZl), 0) sumZl  "
			+ "  from (select id, fid,deptname ,connect_by_root(id) root  "
			+ "  from (select d.deptid as id, d.parentid as fid,d.deptname  "
			+ "     from ss_dept d  "
			+ "  start with "+deptStartCond
			+ "   connect by prior d.deptid = d.parentid)  "
			+ "   connect by prior id = fid) a  "
			+ "  left join ( select cpcode , "
			+ "       max(case  when  code='1' and stype='0'  then num else 0 end) oneZl, "
			+ "       max(case  when  code='2'  and stype='0' then num else 0 end)  twoZl, "
			+ "       max(case  when  code='3'  and stype='0' then num else 0 end)  threeZl, "
			+ "       max(case  when  code='4'  and stype='0' then num else 0 end)  fourZl, "
			+ "       max(case  when  code='9'  and stype='0' then num else 0 end)  nineZl, "
			+ "       sum(decode(stype,'0',num,0)) sumZl "
			+ "       from  "
			+ "           (select cpcode, zt.code,count(t.cpcode) num ,'0' stype "
			+ "            from T_EMPLOYEE t ,ss_dept dep,t_dic_cyrjzt zt where t.cpcode = dep.deptid  and t.cyrjzt = zt.code and "+ empCond
			+ "            group by t.cpcode,zt.code )  "
			+ "      where cpcode is not null  "
			+ "      group by cpcode) b  "
			+ "  on a.id = b.cpcode  "
			+ "  group by root order by root ) g,ss_dept dept  "
			+ "   where g.id=dept.deptid and "+deptLevelCond ;
		
		String statSql = " with temp as(    "
			+ "select t1.deptid as id, t1.parentid parent,t1.deptname,t1.deptseq,t1.deptlevel,t1.status,level levs,t2.oneZl,t2.twoZl,t2.threeZl,t2.fourZl,t2.nineZl,t2.sumZl  "  
			+ " from ss_dept t1 , "
			+ "  ( select cpcode , "
			+ "        max(case  when  code='1' and stype='0'  then num else 0 end)  oneZl, "
			+ "      max(case  when  code='2'  and stype='0' then num else 0 end)  twoZl, "
			+ "      max(case  when  code='3'  and stype='0' then num else 0 end)  threeZl, "
			+ "      max(case  when  code='4'  and stype='0' then num else 0 end)  fourZl, "
			+ "     max(case  when  code='9'  and stype='0' then num else 0 end)  nineZl, "
			+ "      sum(decode(stype,'0',num,0)) sumZl "
			+ "      from "
			+ "          (select cpcode, zt.code,count(t.cpcode) num ,'0' stype "
			+ "          from T_EMPLOYEE t ,ss_dept dep,t_dic_cyrjzt zt where t.cpcode = dep.deptid  and t.cyrjzt = zt.code and "+ empCond
			+ "          group by t.cpcode,zt.code) "
			+ "      where cpcode is not null "
			+ "     group by cpcode) t2  "
			+ "      where t1.deptid = t2.cpcode(+)    "
			+ " start with  "+deptStartCondFor9
			+ " connect by prior t1.deptid = t1.parentid)    "
			+ " select id as depti,deptname,deptseq,deptlevel,status, "
			+ "         (select nvl(oneZl, 0) from temp where id = t.id) +    "
			+ "       (select nvl(sum(oneZl), 0) from temp  connect by parent = prior id   start with parent = t.id) oneZl, "
			+ "       (select nvl(twoZl, 0) from temp where id = t.id) +    "
			+ "      (select nvl(sum(twoZl), 0) from temp  connect by parent = prior id   start with parent = t.id) twoZl, "
			+ "     (select nvl(threeZl, 0) from temp where id = t.id) +    "
			+ "     (select nvl(sum(threeZl), 0) from temp  connect by parent = prior id   start with parent = t.id) threeZl, "
			+ "     (select nvl(fourZl, 0) from temp where id = t.id) +    "
			+ "    (select nvl(sum(fourZl), 0) from temp  connect by parent = prior id   start with parent = t.id) fourZl, "
			+ "    (select nvl(nineZl, 0) from temp where id = t.id) +    "
			+ "    (select nvl(sum(nineZl), 0) from temp  connect by parent = prior id   start with parent = t.id) nineZl, "
			+ "   (select nvl(sumZl, 0) from temp where id = t.id) +    "
			+ "  (select nvl(sum(sumZl), 0) from temp  connect by parent = prior id   start with parent = t.id) sumZl     "
			+ "  from temp t  where "+ deptLevelCondFor9;
		
	
		 //System.out.println("groupSql="+groupSql);
		
		if(request.getParameter("tx")!=null&&!request.getParameter("tx").equals("")){
			List list=(List)vemployeeStaManager.getXML(statSql);
			request.setAttribute("strXML", getXml(list));
			request.setAttribute("tx", request.getParameter("tx"));
			if(list.size()>15)request.setAttribute("scro", "scro");
			if(!list.isEmpty())
			return TXLIST_JSP;
		}
		
		Page page = vemployeeStaManager.findByPageRequest(statSql,pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	public String getXml(List list){
		StringBuffer strXML=new StringBuffer();
		if(!list.isEmpty()&&list.size()>0){
			strXML.append("<graph caption='从业人员统计' showNames='1' baseFontSize='12' showAlternateHGridColor='true' xAxisName='所属单位' yAxisName='人数' numberSuffix='人' >"); 
			String[] s=new String[]{"AFD8F8","F6BD0F","8BBA00","FF0099","0099FF"};
			int h=0;
			
			for(int i=0;i<list.size();i++){
				
				Map map=(Map)list.get(i);
				strXML.append("<set name='");
				strXML.append(map.get("deptname"));
				strXML.append("' value='");
				strXML.append(map.get("sumZl"));
//				strXML.append("' color='");

//				if(h>=5){
//					h=0;
//				}
//				h++;
//				strXML.append(s[h]);
				strXML.append("'/>");
			}
			
			strXML.append("</graph>");
		}
		

		return strXML.toString();
	}
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return SHOW_JSP;
	}
	
	

}
