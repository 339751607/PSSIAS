/*
 * Copyright 2008 lisc, Inc. All rights reserved.
 * Website: http://7066220.qzone.qq.com
 */

package com.dyneinfo.pmdd.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.java.dev.common.dict.ISelectOption;
import net.java.dev.common.dict.taglib.DictHelpImpl;

import org.apache.poi.hssf.model.Sheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.hssf.util.Region;


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;

import java.text.SimpleDateFormat;
import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;
import net.java.dev.common.util.DateUtil;
import com.dyneinfo.pmdd.dao.*;
import com.dyneinfo.pmdd.model.*;
import com.dyneinfo.pmdd.service.*;
import com.google.common.collect.Maps;

/**
 * @author lisc email:lishicheng(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class DczyddExcelExportAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	

	
	private DczyddManager dczyddManager;
	
	private Dczydd dczydd;
	
	java.lang.String id = null;

	private String[] items;

public void prepare() throws Exception {
		
		if (isNullOrEmptyString(id)) {
			dczydd = new Dczydd();
		} else {
			dczydd = (Dczydd) dczyddManager.getById(id);
		}
	}

	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setDczyddManager(DczyddManager manager) {
		this.dczyddManager = manager;
	}
	
	public Object getModel() {
		return dczydd;
	}
	
	public void setDnumber(java.lang.String val) {
		this.id = val;
	}

	public void setItems(String[] items) {
		this.items = items;
	}
	
	protected String[] match;


	protected boolean matchValue(String v) {
		if (this.match == null || this.match.length == 0)
			return false;
		for (int i = 0; i < this.match.length; i++) {
			if (match[i] != null)
				if (match[i].equals(v))
					return true;
		}
		return false;
	}
	
	public String listreport() throws Exception {
		PageRequest pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		//pageRequest.getFilters().put("key",value);     //add custom filter
		HttpServletRequest request = ServletActionContext.getRequest();
		
		int fzsum = 1;
		Integer obj = new Integer(fzsum);
		String  fzStr = obj.toString();
	
		
		
		
		//生成Excel文件.
		HSSFWorkbook  wb = exportExcelWorkbook(dczydd, fzStr);

		//输出Excel文件.
		HttpServletResponse response =  ServletActionContext.getResponse();
		response.setContentType("application/vnd.ms-excel");
		String encodedfileName = new String((dczydd.getDdrq()+"-"+dczydd.getHtid()+"-动产质押典当登记表.xls").getBytes(), "ISO8859-1");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedfileName + "\"");

		

		wb.write(response.getOutputStream());
		response.getOutputStream().flush();
		return null;
	}
	
	private Map<String, HSSFCellStyle> styles;
	private int rowIndex = 0;


	
	private HSSFWorkbook  exportExcelWorkbook(Dczydd dczydd,String fzStr) {
	//	TemperatureAnomaly[] temperatureAnomalyArray = DummyDataFetcher.getDummyData();

		//创建Workbook
		HSSFWorkbook  wb = new HSSFWorkbook();
		
		


		
		//创建所有Cell Style
		createStyles(wb);
		//wb.setSheetName(0,  "中文" ,HSSFCell.ENCODING_UTF_16);       
   
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String currDate = format.format(date);

		//创建工作表.
		HSSFSheet s = wb.createSheet(currDate);

		//设定冻结表头
		s.createFreezePane(0, 5, 0, 5);

		//设定所有Column宽度自动配合内容宽度
		s.setColumnWidth((short)0, (short)3500);
		s.setColumnWidth((short)1, (short)4000);
		s.setColumnWidth((short)2,(short) 3500);
		s.setColumnWidth((short)3, (short)4000);
		s.setColumnWidth((short)4,(short) 3500);
		s.setColumnWidth((short)5, (short)4500);
		
		


		//产生标题
		generateTitle(s,id);
		//产生表头
		generateHeader(s,dczydd);
		//产生内容
		//generateContent(s,  fzStr, s_hotelid, s_checkdate);
		//产生合计
		//generateTotals(s);

		return wb;
	}

	private void generateTitle(HSSFSheet s,String id) {
		HSSFRow r = s.createRow(rowIndex++);
		r.setHeight((short) 600);// 目的是想把行高设置成25px
		HSSFCell c1 = r.createCell((short)0);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue("典当物品登记表");
		c1.setCellStyle(styles.get("header"));
		//合并单元格
		s.addMergedRegion(new Region(0, (short)0, 0, (short)3));// 起始cell行、起始cell列、结束cell行、结束cell列。 
		c1 = r.createCell((short) 4);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue(id);
		
	
		c1 = r.createCell((short) 5);
		
		s.addMergedRegion(new Region(0, (short)4, 0, (short)5));// 起始cell行、起始cell列、结束cell行、结束cell列。 
		
		
	}

	private void generateHeader(HSSFSheet s, Dczydd dczydd) {

		String  dnumber="",dwmc = "", htid = "", sqr = "", sex = "", hjd = "",dwzj="",yxzj="",zjhm="";
		String dz="",lxdh="",bsm="",ddlx="",pp="",gg="",zl="",wpxz="",wplyqksm="",wpcqzmcl="",sdr="";;
		
		
		String sexName = "";
		String hjdName = "";
		String ddlxName = "";
		String yxzjName = "";
		
		String ddrq = dczydd.getDdrq();
		String ddrqFormat = DateUtil.parseString(ddrq, "yyyyMMddHHmmss", "yyyy年MM月dd日 HH:mm:ss");
		
		
	
	
		
		
		if(dczydd != null){
			dnumber = dczydd.getDnumber();
			dwmc = dczydd.getDwmc();
			htid = dczydd.getHtid();
			sqr = dczydd.getSqr();
			sex = "9";
			hjd = "";
			dwzj = dczydd.getDwzj();// 当物证件
			yxzj = dczydd.getYxzj();
			zjhm = dczydd.getZjhm();
			
			if(zjhm != null && zjhm.length() > 17){
			    String zjhm14 = zjhm.substring(16, 17);
			
			if(Integer.parseInt(zjhm14)%2==0)
				sex = "2";
			else
				sex = "1";
			
			hjd= zjhm.substring(0,6);
			}
			dz = dczydd.getDz();
			lxdh = dczydd.getLxdh();
			//bsm = "";
			ddlx = dczydd.getDdlx();
			pp = dczydd.getWppp();
			gg = dczydd.getWpgg();
			zl = dczydd.getWpzl();
			wpxz = dczydd.getWpxz();
			wplyqksm = dczydd.getWplyqksm();
			wpcqzmcl = dczydd.getWpcqzmcl();
			sdr = dczydd.getSdr();
			
			
		
			
			
			List datas = DictHelpImpl.getDict("gender");
			if(sex != null && sex.length() > 0){
			for (int i = 0; i < datas.size(); i++) {
				ISelectOption bean = (ISelectOption) datas.get(i);
				if (bean.getValue() != null && bean.getValue().equals(sex))
					sexName = bean.getName();

			}}
			
			
			if(hjd != null && hjd.length() > 0){
				 datas = DictHelpImpl.getDict("xzqh");
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(hjd))
						hjdName = bean.getName();

				}
				}
			
			
			if(yxzj != null && yxzj.length() > 0){
			 datas = DictHelpImpl.getDict("T_ID_NAME");
			for (int i = 0; i < datas.size(); i++) {
				ISelectOption bean = (ISelectOption) datas.get(i);
				if (bean.getValue() != null && bean.getValue().equals(yxzj))
					yxzjName = bean.getName();

			}
			}
			
			
			 datas = DictHelpImpl.getDict("ddlb");
			for (int i = 0; i < datas.size(); i++) {
				ISelectOption bean = (ISelectOption) datas.get(i);
				if (bean.getValue() != null && bean.getValue().equals(ddlx))
					ddlxName = bean.getName();

			}
			
		}
		

		HSSFCellStyle boldStyle = styles.get("bold");
		
		HSSFCellStyle commonStyle = styles.get("commonStyle");	
		
		HSSFRow r = s.createRow(rowIndex++);
		HSSFCell c1 = r.createCell((short) 0);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue("典当物品");
		c1.setCellStyle(boldStyle);
		
		c1 = r.createCell((short) 1);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue(dwmc);
		c1.setCellStyle(commonStyle);
	
		c1 = r.createCell((short) 2);
		c1.setCellStyle(commonStyle);
		s.addMergedRegion(new Region(1, (short) 1, 1, (short) 2));
		c1.setCellStyle(commonStyle);
		
		HSSFCell c2 = r.createCell((short) 3);
		c2.setEncoding(HSSFCell.ENCODING_UTF_16);
		c2.setCellValue("当票编号");
		c2.setCellStyle(boldStyle);
		
		
		
		c1 = r.createCell((short) 4);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue(htid);
		c1.setCellStyle(commonStyle);
	
		c1 = r.createCell((short) 5);
		c1.setCellStyle(commonStyle);
		
		
		
		
		// 换行
		r = s.createRow(rowIndex++);
		s.addMergedRegion(new Region(1, (short) 4, 1, (short) 5));
		c1 = r.createCell((short) 0);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue("当户姓名");
		c1.setCellStyle(boldStyle);
		
		c1 = r.createCell((short) 1);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue(sqr);
		c1.setCellStyle(commonStyle);
	
		c1 = r.createCell((short) 2);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue("性别");
		c1.setCellStyle(boldStyle);
		
		c1 = r.createCell((short) 3);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue(sexName);
		c1.setCellStyle(commonStyle);
		
		c1 = r.createCell((short) 4);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue("户籍地");
		c1.setCellStyle(boldStyle);
		
		c1 = r.createCell((short) 5);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue(hjdName);
		c1.setCellStyle(commonStyle);
		
		
		// 换行
		r = s.createRow(rowIndex++);
		c1 = r.createCell((short) 0);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue("身份证件");
		c1.setCellStyle(boldStyle);
		
		c1 = r.createCell((short) 1);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue(yxzjName);
		c1.setCellStyle(commonStyle);
	
		c1 = r.createCell((short) 2);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue("证件号码");
		c1.setCellStyle(boldStyle);
		
		c1 = r.createCell((short) 3);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue(zjhm);
		c1.setCellStyle(commonStyle);
		
		c1 = r.createCell((short) 4);
		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 5);
		c1.setCellStyle(commonStyle);
		s.addMergedRegion(new Region(3, (short) 3, 3, (short) 5));
		c1.setCellStyle(commonStyle);
		
		// 换行
		r = s.createRow(rowIndex++);
		c1 = r.createCell((short) 0);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue("地址");
		c1.setCellStyle(boldStyle);
		
		c1 = r.createCell((short) 1);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue(dz);
		c1.setCellStyle(commonStyle);
	
		c1 = r.createCell((short) 2);
		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 3);
		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 4);
		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 5);
		c1.setCellStyle(commonStyle);
		s.addMergedRegion(new Region(4, (short) 1, 4, (short) 5));
		c1.setCellStyle(commonStyle);
		
		// 换行
		r = s.createRow(rowIndex++);
		c1 = r.createCell((short) 0);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue("联系方式");
		c1.setCellStyle(boldStyle);
		
		c1 = r.createCell((short) 1);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue(lxdh);
		c1.setCellStyle(commonStyle);
	
		c1 = r.createCell((short) 2);
		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 3);
		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 4);
		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 5);
		c1.setCellStyle(commonStyle);
		s.addMergedRegion(new Region(5, (short) 1, 5, (short) 5));
		c1.setCellStyle(commonStyle);
		
		// 换行
		r = s.createRow(rowIndex++);
		c1 = r.createCell((short) 0);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue("标识码");
		c1.setCellStyle(boldStyle);
		
		c1 = r.createCell((short) 1);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue(bsm);
		c1.setCellStyle(commonStyle);
	
		c1 = r.createCell((short) 2);
		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 3);
		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 4);
		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 5);
		c1.setCellStyle(commonStyle);
		s.addMergedRegion(new Region(6, (short) 1, 6, (short) 5));
		c1.setCellStyle(commonStyle);
		
		
		
		// 换行
		r = s.createRow(rowIndex++);
		c1 = r.createCell((short) 0);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue("类别");
		c1.setCellStyle(boldStyle);
		
		
		c1 = r.createCell((short) 1);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue(ddlxName);
		c1.setCellStyle(commonStyle);
	
		c1 = r.createCell((short) 2);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue("品牌");
		c1.setCellStyle(boldStyle);
		
		
		c1 = r.createCell((short) 3);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue(pp);
		c1.setCellStyle(commonStyle);
		
		c1 = r.createCell((short) 4);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue("规格");
		c1.setCellStyle(boldStyle);
		
		c1 = r.createCell((short) 5);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue(gg);
		c1.setCellStyle(commonStyle);
		
		// 换行
		r = s.createRow(rowIndex++);
		c1 = r.createCell((short) 0);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue("重量");
		c1.setCellStyle(boldStyle);
		
		c1 = r.createCell((short) 1);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue(zl);
		c1.setCellStyle(commonStyle);
	
		c1 = r.createCell((short) 2);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue("形状特征");
		c1.setCellStyle(boldStyle);
		
		c1 = r.createCell((short) 3);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue(wpxz);
		c1.setCellStyle(commonStyle);
		
		c1 = r.createCell((short) 4);
		c1.setCellStyle(boldStyle);
		c1 = r.createCell((short) 5);
		c1.setCellStyle(boldStyle);
		s.addMergedRegion(new Region(8, (short) 3, 8, (short) 5));
		c1.setCellStyle(commonStyle);
		
		// 换行
		r = s.createRow(rowIndex++);
		c1 = r.createCell((short) 0);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue("物品来源情况说明");
		c1.setCellStyle(boldStyle);
		
	
		c1 = r.createCell((short) 1);
		c1.setCellStyle(commonStyle);
		

		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 2);
		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 3);
		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 4);
		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 5);
		c1.setCellStyle(commonStyle);
		s.addMergedRegion(new Region(9, (short) 0, 9, (short) 5));
		c1.setCellStyle(commonStyle);
		
		// 换行
		r = s.createRow(rowIndex++);
		c1 = r.createCell((short) 0);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue(wplyqksm);
		c1.setCellStyle(commonStyle);
		
		c1 = r.createCell((short) 1);
		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 2);
		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 3);
		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 4);
		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 5);
		c1.setCellStyle(commonStyle);
		
		s.addMergedRegion(new Region(10, (short) 0, 10, (short) 5));
		r.setHeight((short)2000);
		
		
		// 换行
		r = s.createRow(rowIndex++);
		c1 = r.createCell((short) 0);
		c1.setCellStyle(commonStyle);
		
		
		c1 = r.createCell((short) 1);
		c1.setCellStyle(commonStyle);
	
		c1 = r.createCell((short) 2);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellStyle(commonStyle);
		
		
		c1 = r.createCell((short) 3);
		c1.setCellStyle(commonStyle);
		s.addMergedRegion(new Region(11, (short) 0, 11, (short) 3));
		
		c1 = r.createCell((short) 4);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue("当户签字：");
		c1.setCellStyle(commonStyle);
		
		c1 = r.createCell((short) 5);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue("");
		c1.setCellStyle(commonStyle);
		
		
		
		// 换行
		r = s.createRow(rowIndex++);
		c1 = r.createCell((short) 0);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue("产权证明材料");
		c1.setCellStyle(boldStyle);
		
		c1 = r.createCell((short) 1);
		c1.setCellStyle(commonStyle);
	
		c1 = r.createCell((short) 2);
		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 3);
		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 4);
		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 5);
		c1.setCellStyle(commonStyle);
		s.addMergedRegion(new Region(12, (short) 0, 12, (short) 5));
		
		
		// 换行
		r = s.createRow(rowIndex++);
		c1 = r.createCell((short) 0);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue(wpcqzmcl);
		c1.setCellStyle(commonStyle);
		
		c1 = r.createCell((short) 1);
		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 2);
		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 3);
		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 4);
		c1.setCellStyle(commonStyle);
		c1 = r.createCell((short) 5);
		c1.setCellStyle(commonStyle);
		
		s.addMergedRegion(new Region(13, (short) 0, 13, (short) 5));
		r.setHeight((short)2000);
		
		
		
		// 换行
		r = s.createRow(rowIndex++);
		c1 = r.createCell((short) 0);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue("当行（加盖公章）：");
		c1.setCellStyle(boldStyle);
		
		
		c1 = r.createCell((short) 1);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		//c1.setCellValue("");
		c1.setCellStyle(commonStyle);
	
		c1 = r.createCell((short) 2);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue("收当人：");
		c1.setCellStyle(boldStyle);
		
		
		c1 = r.createCell((short) 3);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue(sdr);
		c1.setCellStyle(commonStyle);
		
		c1 = r.createCell((short) 4);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue("收当时间：");
		c1.setCellStyle(boldStyle);
		
		c1 = r.createCell((short) 5);
		c1.setEncoding(HSSFCell.ENCODING_UTF_16);
		c1.setCellValue(ddrqFormat);
		c1.setCellStyle(commonStyle);
		
		
		

	}


	private void generateTotals(HSSFSheet s) {

		HSSFRow r = s.createRow(rowIndex++);
		HSSFCellStyle totalStyle = styles.get("total");

		
		//Cell强行分行
		HSSFCell c1 = r.createCell((short)0);
		c1.setCellStyle(totalStyle);
		c1.setCellValue("合\n计");

		//合计公式
		HSSFCell c2 = r.createCell((short)1);
		c2.setCellStyle(totalStyle);
		c2.setCellFormula("SUM(B3:B32)");

		HSSFCell c3 = r.createCell((short)2);
		c3.setCellStyle(totalStyle);
		c3.setCellFormula("SUM(C3:C32)");
	}

	
	private Map<String, HSSFCellStyle> createStyles(HSSFWorkbook wb) {
		styles = Maps.newHashMap();
		HSSFDataFormat df = wb.createDataFormat();

		// --字体设定 --//

		//普通字体
		HSSFFont normalFont = wb.createFont();
		normalFont.setFontHeightInPoints((short) 12);

		//加粗字体
		HSSFFont boldFont = wb.createFont();
		boldFont.setFontHeightInPoints((short) 12);
		boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		
		
		//标题字体
		HSSFFont titleFont = wb.createFont();
		titleFont.setFontHeightInPoints((short) 18);
		titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		//蓝色加粗字体
		HSSFFont blueBoldFont = wb.createFont();
		blueBoldFont.setFontHeightInPoints((short) 12);
		blueBoldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		blueBoldFont.setColor(IndexedColors.BLUE.getIndex());

		// --Cell Style设定-- //

		//标题格式
		HSSFCellStyle headerStyle = wb.createCellStyle();
		headerStyle.setWrapText(true);   
		headerStyle.setFont(titleFont);
		headerStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		styles.put("header", headerStyle);
		
		
		///普通字体格式
		HSSFCellStyle commonStyle = wb.createCellStyle();
		commonStyle.setWrapText(true);     
		commonStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		commonStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		setBorder(commonStyle);
		styles.put("commonStyle", commonStyle);	
		
		///加粗字体格式
		HSSFCellStyle boldStyle = wb.createCellStyle();
		boldStyle.setWrapText(true); 
		boldStyle.setFont(boldFont);
		boldStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		boldStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		setBorder(boldStyle);
		styles.put("bold", boldStyle);	
		
		//加粗左对齐12font
		HSSFCellStyle boldLeft12Style = wb.createCellStyle();
		boldLeft12Style.setWrapText(true);
		boldLeft12Style.setFont(boldFont);
		boldLeft12Style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		setBorder(boldLeft12Style);
		styles.put("boldLeft12", boldLeft12Style);
		
		//加粗左对齐14font
		HSSFCellStyle boldLeftStyle = wb.createCellStyle();
		boldLeftStyle.setWrapText(true);
		HSSFFont boldFont2 = wb.createFont();
		boldFont2.setFontHeightInPoints((short) 14);
		boldFont2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		boldLeftStyle.setFont(boldFont2);
		boldLeftStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		setBorder(boldLeftStyle);
		styles.put("boldLeft", boldLeftStyle);

		//日期格式
		HSSFCellStyle dateCellStyle = wb.createCellStyle();
		dateCellStyle.setFont(normalFont);
		dateCellStyle.setDataFormat(df.getFormat("yyyy"));
		setBorder(dateCellStyle);
		styles.put("dateCell", dateCellStyle);

		//数字格式
		HSSFCellStyle numberCellStyle = wb.createCellStyle();
		numberCellStyle.setFont(normalFont);
		numberCellStyle.setDataFormat(df.getFormat("#,##0.00"));
		setBorder(numberCellStyle);
		styles.put("numberCell", numberCellStyle);

		//合计列格式
		HSSFCellStyle totalStyle = wb.createCellStyle();
		totalStyle.setFont(blueBoldFont);
		totalStyle.setWrapText(true);
		totalStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		setBorder(totalStyle);
		styles.put("total", totalStyle);

		return styles;
	}

	private void setBorder(HSSFCellStyle style) {
		//设置边框
		
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());

		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());

		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		//style.setTopBorderColor(IndexedColors.BLACK.getIndex());

		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		//style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	}

}
