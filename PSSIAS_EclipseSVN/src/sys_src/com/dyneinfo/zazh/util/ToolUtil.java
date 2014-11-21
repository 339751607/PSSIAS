package com.dyneinfo.zazh.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sun.net.www.content.audio.x_aiff;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.service.*;

public class ToolUtil {
	
	public static int pointsCount=6; //每行显示的轨迹的个数	
	
	public static List<SsDatasource> getBusinessCodeIsValid(SsDatasourceManager ssDatasourceManager,HashMap map){
		PageRequest<Map> pageRequest = new PageRequest(null);
		
		pageRequest.setFilters(map);
		pageRequest.setPageNumber(1);
		pageRequest.setPageSize(10000);
		
		Page page = ssDatasourceManager.findByPageRequest(pageRequest);
		
		return page.getResult();
	}
	public static String getPathForBusinessCode(String businessCode){
		String path="";
		
		//旅馆
		if("001".equals(businessCode)){
			path="pages/hotel/TchPre/getPicture.do";
		}
		//废旧
		if("002".equals(businessCode)){
			path="pages/fjy/Temployee/getPicture.do";
		}
		//典当
		if("003".equals(businessCode)){
			path="pages/pmdd/Fcdydd/getPicture.do";
		}
		//散装汽油
		if("004".equals(businessCode)){
			path="pages/gas/Tbuylog/getPicture.do";
		}
		if("005".equals(businessCode)){
			path="jxy/Tcarinfo/getPicture.do";
		}
		
		return path;
		
	}
	public static String getDBKey(String businessCode){
		String DBKey="";
		
		//治安综合
		if("000".equals(businessCode)){
			DBKey="zazh";
		}
		//旅馆
		if("001".equals(businessCode)){
			DBKey="hotel";
		}
		//废旧
		if("002".equals(businessCode)){
			DBKey="fjy";
		}
		//典当
		if("003".equals(businessCode)){
			DBKey="pmdd";
		}
		//散装汽油
		if("004".equals(businessCode)){
			DBKey="gas";
		}
		//机修业
		if("005".equals(businessCode)){
			DBKey="jxy";
		}
		//开锁业
		if("006".equals(businessCode)){
			DBKey="ksy";
		}
		//重点单位
		if("007".equals(businessCode)){
			DBKey="zddw";
		}
		//拆解业
		if("008".equals(businessCode)){
			DBKey="cjy";
		}
		//娱乐服务业
		if("009".equals(businessCode)){
			DBKey="ylcs";
		}
		return DBKey;
		
	}
	public static String getTrackMap(List listmap, String ctx, String rangeFlag){
		StringBuffer sb= new StringBuffer("");		  
		
		if(listmap!=null && listmap.size()>0){			
			int len = listmap.size();
			List rowList = new ArrayList();
			int rowNo =0;
			for(int i=1; i <= listmap.size(); i++){		
				HashMap map = (HashMap)listmap.get(i-1);	
				rowList.add(map);
				if(i % pointsCount == 0){ //达到一行的个数
					rowNo++;  //行号
					sb.append(getRowTrack(rowList ,rowNo , ctx, rangeFlag));
					rowList = new ArrayList(); //处理完之后，重新再装载一行的数据
				}	        				
			}
			if(rowList!= null && rowList.size() > 0){
				int leftNums = pointsCount - rowList.size();
				if(leftNums > 0){ //如果还有不足指定一行需要显示的个数
					for(int k=0; k < leftNums; k++){
						HashMap map = null;
						rowList.add(map);
					}
				}
				rowNo ++;				
				//如果有数据,仍然要继续显示
				sb.append(getRowTrack(rowList ,rowNo , ctx, rangeFlag));
			}
			
		}else{
			sb.append("<tr align='center'>");
			sb.append("<td>没有相关的轨迹信息！</td>");
			sb.append("</tr>");
		}
		
		return sb.toString();
	}
	
	public static String getRowTrack(List rowList,int rowNo, String ctx, String rangeFlag){
		
		StringBuffer rowSB = new StringBuffer("");
	    String b="";
		String rightLine = "<img src='" + ctx + "/images/track/right.png' border='0' > ";        
		String leftLine  = "<img src='" + ctx + "/images/track/left.png' border='0' > ";
		String downtLine = "<img src='" + ctx + "/images/track/down.png' border='0' > ";      
		
		if(rowList != null && rowList.size() > 0){
			int start_left = 0;
			if(rowNo != 1){ //除了第一行之外,其余的行开始都要加一转弯向下的箭头
			
				if(rowNo % 2 == 0){  //如果是开始偶数行，则在右侧增加拐入下一行的箭头，表示另一行从右向左开始显示
					rowSB.append("<tr align='center' >")					     
					     .append("<td colspan='"+(pointsCount*2-2)+"'></td>")
					     .append("<td  height='20'>"+downtLine+"</td>")
					     .append("</tr>");
					//表示另一行从右向左开始显示
					start_left = pointsCount;  
			        
				}else{//如果是开始奇数行，则在左侧增加拐入下一行的箭头，表示另一行从左向右开始显示
					rowSB.append("<tr align='center' >")
					     .append("<td  height='20'>"+downtLine+"</td>")
				         .append("<td colspan='"+(pointsCount*2-2)+"'></td>")				     
				         .append("</tr>");
					//表示另一行从左向右开始显示
					start_left = 0;
				}
			}
			rowSB.append("<tr align='center' >");
			int len = rowList.size();
			int j =0;
			String imageLine = rightLine;
			boolean oppFlag = false;  ////如果start_left = 0， 则需要正常的顺序显示		
			if(start_left == pointsCount){//如果不为0，则需要反向的显示，
				oppFlag= true;
			}
			for(int i = 0 ; i < len ; i++){				
				
				if(oppFlag){
					j = (start_left-1)-i;
					imageLine = leftLine;
				}else{ 
					j = i;
					imageLine = rightLine;
				}

				HashMap map = (HashMap)rowList.get(j);	
				if(map == null){
					rowSB.append("<td>")
					     .append("</td>")
					     .append("<td>")
				         .append("</td>");
					continue;
				}
				// 顺序显示的时候，在一个不为空的节点的前面，增加箭头
				if( oppFlag==false && (i > 0) ){  //由左向有正常显示，最后一个点不需要输出
					rowSB.append("<td>")                     
				         .append(imageLine)
				         .append("</td>"); 	
				}
				
				
				String activeName = (String)map.get("activeName");
				String activeCode = (String)map.get("activeCode");				
				String cpname = (String)map.get("cpname");
				String starttime = (String)map.get("starttime");
				String endtime = (String)map.get("endtime");
				String sid = (String)map.get("sid");
				String source = (String)map.get("source");
				String cpcode = (String)map.get("cpcode");
				
				String alt =cpname + ": " + starttime + " - " + endtime;
					
				String imageName = ctx + "/images/track/" + activeCode + b + ".png";
				
				String imageInfo = " <img src='"+ imageName +"'  alt='" + alt + "' "
							     + " width='30' height='30'  border='0' > ";
				String disp_starttime = (String)map.get("disp_starttime");
				//一个轨迹的基本信息
				String s_href = "";
				if("jw".equals(rangeFlag)){
				    s_href = "<a href=javascript:openDetail_JW('"+ctx+"','"+sid+"','"+activeCode+"','"+source+"','"+cpcode+"'); >";
				}
				if("jn".equals(rangeFlag)){
					String cardname = (String)map.get("cardname");
					String cardcode = (String)map.get("cardcode");					
				    s_href = "<a href=javascript:openDetail_JN('"+ctx+"','"+sid+"','"+activeCode+"','"+source+"','"+cpcode+"','"+cardname+"','" + cardcode + "'); >";
				}
				if("car".equals(rangeFlag)){
				    s_href = "<a href=javascript:openDetail_Car('"+ctx+"','"+sid+"','"+activeCode+"','"+source+"'); >";
				}
				
				rowSB.append("<td>")
		             .append("<b><font  style='font-size:12px' >" +activeName+"</b>").append("<br>")
					 .append(s_href)
		             .append(imageInfo)
					 .append("</a><br>")
					 .append(disp_starttime)
					 .append("</font></td>"); 
				
				// 顺序显示的时候，在一个不为空的节点的前面，增加箭头
				if( oppFlag==true && (i < len-1) ){  //由右向左有反向显示，最后一个点不需要输出
					rowSB.append("<td>")                     
				         .append(imageLine)
				         .append("</td>"); 	
				}
				
			}
			rowSB.append("</tr>");
		}
		
		return rowSB.toString();
	}
	
	public static String getSelect(List<Map> list,String valueKey,String textKey,String selectId,String selectName,String className,String selectedValue){
		StringBuffer sb=new StringBuffer();
		sb.append("<select id='"+selectId+"' name='"+selectName+"' class='"+className+"'>");
		sb.append("<option value=''>请选择...</option>");
		
		for(int i=0;i<list.size();i++){
			Map map=list.get(i);
            String str="";
			if(selectedValue.equals(map.get(valueKey))){
				str="  selected='selected' ";
			}
			sb.append("<option value='"+map.get(valueKey)+"' "+str+">"+map.get(textKey)+"</option>");
			
		}

		
		sb.append("</select>");
		
		return sb.toString();
		
	}
}
