package net.java.dev.common.dict.taglib;




import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;


public class RoomTag extends TagSupport {
	private final static String DATE_PARAMETER_NAME = "tgdate";

	private static final long serialVersionUID = 3905528206810115095L;

	protected String requestURI = null;

	protected String linkURI = null;

	protected String name;

	protected String title;

	protected String styleId = "tgcalendar";

	protected boolean linkAll = false;

	protected boolean showToday = false;
	
	protected boolean showRoomIcon = false;
	
	protected boolean selectRoomIcon = false;//入住
	
	protected boolean selectOutRoomIcon = false;//退宿

	protected String roomDefaultIcon = null;
	
	protected String roomDefaultIconLink = null;

	/**
	 * @param requestURI
	 *            the request URI to use in next/prev links.
	 * 
	 * @jsp.attribute required="true" rtexprvalue="true"
	 */
	public void setRequestURI(String uri) {
		this.requestURI = uri;
	}

	/**
	 * @param linkURI
	 *            the request URI to use if linkAll is set to 'true'.
	 * 
	 * @jsp.attribute required="false" rtexprvalue="true"
	 */
	public void setLinkURI(String uri) {
		this.linkURI = uri;
	}

	/**
	 * @param name
	 *            name of the request scope attribute that holds the
	 *            java.util.List of CalendarEvents to add to calendar view.
	 * 
	 * @jsp.attribute required="false" rtexprvalue="true"
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param styleId
	 *            name of the css style id for the calendar container.
	 * 
	 * @jsp.attribute required="false" rtexprvalue="true"
	 */
	public void setStyleId(String id) {
		this.styleId = id;
	}

	/**
	 * @param title
	 *            title to display on the calendar.
	 * 
	 * @jsp.attribute required="false" rtexprvalue="true"
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param linkAll
	 *            if true, a link is generated for every day.
	 * 
	 * @jsp.attribute required="false" rtexprvalue="true"
	 */
	public void setLinkAll(String b) {
		this.linkAll = new Boolean(b).booleanValue();

	}

	/**
	 * @param showToday
	 *            if true, the actual day is generated with a special css style
	 *            id.
	 * 
	 * @jsp.attribute required="false" rtexprvalue="true"
	 */
	public void setShowToday(String b) {
		// this.showToday = Boolean.parseBoolean(b);
		this.showToday = new Boolean(b).booleanValue();
	}
	
	
	
	public boolean isShowRoomIcon() {
		return showRoomIcon;
	}

	public void setShowRoomIcon(boolean showRoomIcon) {
		this.showRoomIcon = showRoomIcon;
	}

	public String getRoomDefaultIcon() {
		return roomDefaultIcon;
	}

	public void setRoomDefaultIcon(String roomDefaultIcon) {
		this.roomDefaultIcon = roomDefaultIcon;
	}

	public String getRoomDefaultIconLink() {
		return roomDefaultIconLink;
	}

	public void setRoomDefaultIconLink(String roomDefaultIconLink) {
		this.roomDefaultIconLink = roomDefaultIconLink;
	}
	
	
	public boolean isSelectRoomIcon() {
		return selectRoomIcon;
	}

	public void setSelectRoomIcon(boolean selectRoomIcon) {
		this.selectRoomIcon = selectRoomIcon;
	}
	
	public boolean isSelectOutRoomIcon() {
		return selectOutRoomIcon;
	}

	public void setSelectOutRoomIcon(boolean selectOutRoomIcon) {
		this.selectOutRoomIcon = selectOutRoomIcon;
	}

	/**
	 * Process the start of this tag.
	 * 
	 * @return
	 * 
	 * @exception JspException
	 *                if a JSP exception has occurred
	 * 
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag()
	 */
	public int doStartTag() throws JspException {

		List events = null;
		StringBuffer sb = new StringBuffer();

		// set requestURI
		HttpServletRequest req = ((HttpServletRequest) pageContext.getRequest());
		if (!requestURI.startsWith("http://")) {
			if (!requestURI.startsWith(req.getContextPath())) {
				requestURI = req.getContextPath() + requestURI;
			}
		}
		
		String ctx = req.getContextPath();

		// set linkURI
		if (linkURI != null) {
			if (!linkURI.startsWith("http://")) {
				if (!linkURI.startsWith(req.getContextPath())) {
					linkURI = req.getContextPath() + linkURI;
				}
			}
		} else {
			linkURI = requestURI;
		}



		// set events if any
		try {
			events = (List) pageContext.getRequest().getAttribute(name);
		} catch (Exception e) {
		}
        String pre_buildno="";
        String nxt_buildno="";
		String buildno = "";
		String floorNo_start = "1";
		String floorNo_end = "1";
		String roomNo_start = "1";
		String roomNo_end = "3";
		String defaultURL = "CH";
		
		
		String buildNoName = "";
		String floorNo_exception = "";
		String roomLength = "";
		String roomPadStr = "0";
		String roomPre = "";
		String room_exception = "";
		
		Hashtable htFloorExp = new Hashtable();
		Hashtable htRoomExp = new Hashtable();
		
		
		
		
		try {
			
		if (pageContext.getRequest().getAttribute("pre_buildno") != null) {
			pre_buildno = (String) pageContext.getRequest().getAttribute("pre_buildno");
		}
		if (pageContext.getRequest().getAttribute("nxt_buildno") != null) {
			nxt_buildno = (String) pageContext.getRequest().getAttribute("nxt_buildno");
		}
		if (pageContext.getRequest().getAttribute("buildno") != null) {
			buildno = (String) pageContext.getRequest().getAttribute("buildno");
		}
		
		if (pageContext.getRequest().getAttribute("floorNo_start") != null) {
			floorNo_start = (String) pageContext.getRequest().getAttribute(
					"floorNo_start");
		}
		if (pageContext.getRequest().getAttribute("floorNo_end") != null) {
			floorNo_end = (String) pageContext.getRequest().getAttribute(
					"floorNo_end");
		}
		if (pageContext.getRequest().getAttribute("roomNo_start") != null) {
			roomNo_start = (String) pageContext.getRequest().getAttribute(
					"roomNo_start");
		}
		if (pageContext.getRequest().getAttribute("roomNo_end") != null) {
			roomNo_end = (String) pageContext.getRequest().getAttribute(
					"roomNo_end");
		}
		if (pageContext.getRequest().getAttribute("defaultURL") != null) {
			defaultURL = (String) pageContext.getRequest().getAttribute("defaultURL");
		}
		
		
		if (pageContext.getRequest().getAttribute("buildNoName") != null) {
			buildNoName = (String) pageContext.getRequest().getAttribute("buildNoName");
		}
		
		if (pageContext.getRequest().getAttribute("floorNo_exception") != null) {
			floorNo_exception = (String) pageContext.getRequest().getAttribute("floorNo_exception");
		}
		
		if (pageContext.getRequest().getAttribute("roomLength") != null) {
			roomLength = (String) pageContext.getRequest().getAttribute("roomLength");
		}
		
		if (pageContext.getRequest().getAttribute("roomPadStr") != null) {
			roomPadStr = (String) pageContext.getRequest().getAttribute("roomPadStr");
		}
		if (pageContext.getRequest().getAttribute("roomPre") != null) {
			roomPre = (String) pageContext.getRequest().getAttribute("roomPre");
		}
		if (pageContext.getRequest().getAttribute("room_exception") != null) {
			room_exception = (String) pageContext.getRequest().getAttribute("room_exception");
		}
		
		
		
		
		
		} catch (Exception e) {
		}
	
		int arrFloorexpLength = 0;
		int arrRoomexpLength = 0;
		
		if(floorNo_exception != null && floorNo_exception.length() > 0){
		String [] arrFloorexp = floorNo_exception.split("_");
		if(arrFloorexp != null && arrFloorexp.length > 0){
			
			arrFloorexpLength = arrFloorexp.length;
			for(int i=0;i<arrFloorexp.length;i++){
				htFloorExp.put(arrFloorexp[i].toString(), arrFloorexp[i].toString());
			}
		}
		}
		if(room_exception != null && room_exception.length() > 0){
			
		String [] arrRoomexp = room_exception.split("_");
		if(arrRoomexp != null && arrRoomexp.length > 0){
		
			arrRoomexpLength = arrRoomexp.length;
			for(int i=0;i<arrRoomexp.length;i++){
				htRoomExp.put(arrRoomexp[i].toString(), arrRoomexp[i].toString());
			}
		}
		}
		int in_floorNo_start = 1;
		int in_floorNo_end = 1;
		int in_roomNo_start = 1;
		int in_roomNo_end = 3;
		int in_roomLength = 0;
		
		
		

		int floorNo_end_length = 1;// 楼层最大层数长度
		int in_roomNo_end_length = 1;// 房号最大长度

		int floor_room_count = 3; // 每层多少房间
		int floor_count = 1; // 多少层有房间
		try {
			
			
			if (isNumeric(floorNo_start))
				in_floorNo_start = Integer.parseInt(floorNo_start);
			if (isNumeric(floorNo_end))
				in_floorNo_end = Integer.parseInt(floorNo_end);
			if (isNumeric(roomNo_start))
				in_roomNo_start = Integer.parseInt(roomNo_start);
			if (isNumeric(roomNo_end))
				in_roomNo_end = Integer.parseInt(roomNo_end);
			if (net.java.dev.common.dict.taglib.Util.isNumeric(roomLength))
				in_roomLength = Integer.parseInt(roomLength);

			floorNo_end_length = floorNo_end.length();
			in_roomNo_end_length = roomNo_end.length();
			
			if(in_roomNo_end_length < 2)
				in_roomNo_end_length =2;
			
			if(in_roomNo_end_length < in_roomLength)
				in_roomNo_end_length = in_roomLength;

			floor_count  = in_floorNo_end - in_floorNo_start + 1-arrFloorexpLength;
			floor_room_count = in_roomNo_end - in_roomNo_start + 1-arrRoomexpLength;
//			 System.out.println("floor_count="+floor_count);
//			 System.out.println("arrFloorexpLength="+arrFloorexpLength);
//			 
//			 
//			 System.out.println("in_roomNo_end="+in_roomNo_end);
//			 System.out.println("in_roomNo_start="+in_roomNo_start);
//			 System.out.println("floor_room_count="+floor_room_count);
//			 System.out.println("arrRoomexpLength="+arrRoomexpLength);
		}

		catch (Exception e) {
			e.printStackTrace();

		}

		// prepare output
		sb.append("<div id=\"" + styleId + "\">\n");

		if (title != null && title.length() > 0) {
			sb.append(title);
		}

		sb
				.append("<table class=\"tgcalTable\" cellspacing=\"3\" cellpadding=\"2\">\n");

		// line : header
//
//		sb.append("<tr class=\"calendarHeader\">");
//		sb.append("<th>");
//
//		
//
//		sb.append("<a class=\"tgcalPrevious\" href=\"" + requestURI
//				+ "?defaultURL="+defaultURL+"&buildno=" + pre_buildno + "\">");
//		sb
//				.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>");
//		sb.append("</th>\n");
//		sb.append("<th colspan=\"" + (floor_room_count - 2)
//				+ "\" class=\"tgcalTitle\">");
//		sb.append("第"+buildNoName+"栋");
//		sb.append("</th>\n");
//		sb.append("<th style=\"text-align: right\">");
//
//		sb.append("<a class=\"tgcalNext\" href=\"" + requestURI + "?defaultURL="+defaultURL+"&buildno="
//				+ nxt_buildno + " \">");
//		sb
//				.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>");
//		sb.append("</th>\n");
//		sb.append("</tr>\n");

		// line : days of week

		sb.append("<tr class=\"tgcalWeekDays\">\n");

		for (int i = in_roomNo_start; i <= in_roomNo_end; i++) {
			Integer obj1 = new Integer(i);	
			String str_obj1 = obj1.toString();
			if(htRoomExp.get(str_obj1) == null) {
			sb.append("<td width=\"" + 100 / floor_room_count
					+ "%\" class=\"tgcalWeekDay\">");
			sb.append(i);
			sb.append("</td>\n");
			 }
		}
		sb.append("</tr>\n");

		// lines : content
		RoomDay[] days = preprocess(events, buildno, in_floorNo_start,
				in_floorNo_end, in_roomNo_start, in_roomNo_end,
				floorNo_end_length, in_roomNo_end_length, floor_room_count,
				floor_count,ctx,buildno,
				 roomPre, roomPadStr, htFloorExp, htRoomExp,
				 req.getContextPath());
		sb.append("<tr>\n");
		for (int i = 0; i < days.length && days[i] != null; i++) {
			// new line every 7
			if (i % floor_room_count == 0 && i != 0) {
				sb.append("</tr>\n<tr>");
			}
			if ( isShowRoomIcon() && !isSelectRoomIcon() && !isSelectOutRoomIcon()) {
				
				sb.append(days[i].getShowRoomHtmlIconString());
			} else if ( isSelectRoomIcon() ) {
				sb.append(days[i].getSelectRoomHtmlIconString());
			} else if ( isSelectOutRoomIcon() ) {
				
				sb.append(days[i].getSelectOutRoomHtmlIconString());
			}
			else {
			sb.append(days[i].toString());
			}
		}
		sb.append("</tr>\n");

		sb.append("</table>\n");
		sb.append("</div>\n");

		// writes output
		try {
			pageContext.getOut().write(sb.toString());
		} catch (IOException io) {
			throw new JspException(io);
		}

		return super.doStartTag();
	}

	/**
	 * Release aquired resources to enable tag reusage.
	 * 
	 * @see javax.servlet.jsp.tagext.Tag#release()
	 */
	public void release() {
		super.release();
	}

	protected RoomDay[] preprocess(List events, String pararoomNo,
			int in_floorNo_start, int in_floorNo_end, int in_roomNo_start,
			int in_roomNo_end, int floorNo_end_length,
			int in_roomNo_end_length, int floor_room_count, int floor_count,String ctx,String buildNo,
			String roomPre,String roomPadStr,Hashtable htFloorExp,Hashtable htRoomExp,String ctxpath) {
		RoomDay[] days = new RoomDay[floor_room_count * floor_count];
		RoomDay day = null;
		RoomEvent evt = null;

		int tmpInt = 0;
		Hashtable list = new Hashtable();

		for (int i = in_floorNo_start; i <= in_floorNo_end; i++) {
			for (int j = in_roomNo_start; j <= in_roomNo_end; j++) {
				Integer obj1 = new Integer(i);
				Integer obj2 = new Integer(j);
				String str_obj1 = obj1.toString();
				String str_obj2 = obj2.toString();
				if (htFloorExp.get(str_obj1) == null &&  htRoomExp.get(str_obj2) == null) {
				if (buildNo != null && buildNo.equals("0"))//没有楼栋号，楼层前不补零
					str_obj1 = str_obj1;
				else	
				    str_obj1 = padString(str_obj1, floorNo_end_length,roomPadStr, true);
				
				    str_obj2 = padString(str_obj2, in_roomNo_end_length, roomPadStr, true);
				String temp_room_no = "";
				if (buildNo != null && buildNo.equals("0"))////没有楼栋号，房间号 1 不增加栋号 ，2楼层前不补零
					temp_room_no =   str_obj1 + roomPre+str_obj2;
				else 
					temp_room_no = pararoomNo+ str_obj1 +roomPre+ str_obj2;

				day = new RoomDay();
				day.setStyleClass("tgcalDayIn");
				if (linkAll) {
					// link for every day
					day.addLine("<a href=\"" + linkURI + "?roomNo="
							+ temp_room_no + "\" class=\"tgcalDayLink\">"
							+ temp_room_no + "</a>");
					if ( isShowRoomIcon())  {//默认空房间图片
					     day.setRoomImageLine("<a href =\"" + getRoomDefaultIconLink()+"?roomNo="+ temp_room_no
								+ "\" class=\"tgcalDayLink\">"
								+ "<img class=\"tgCalIcon\" border=\"0\" src=\""
								+ getRoomDefaultIcon()+ "\"/>" + "</a>");
					     day.setRoomNo(temp_room_no);  
					     day.setRoomDefaultIcon(getRoomDefaultIcon());
					     day.setRoomDefaultIconLink(getRoomDefaultIconLink());
					     day.setCtx(ctxpath);
					}
				} else {
					// just the date
					day.addLine(temp_room_no + "");
					if ( isShowRoomIcon())  {
						 day.setRoomImageLine("<a href =\"" + getRoomDefaultIconLink()+"?roomNo="+ temp_room_no
								+ "\" class=\"tgcalDayLink\">"
								+ "<img class=\"tgCalIcon\" border=\"0\" src=\""
								 +getRoomDefaultIcon() + "\"/>" + "</a>");
						  day.setRoomNo(temp_room_no);  
						  day.setRoomDefaultIcon(getRoomDefaultIcon());
						  day.setRoomDefaultIconLink(getRoomDefaultIconLink());
						  day.setCtx(ctxpath);
						}
				}
				
				Integer obj = new Integer(tmpInt);
				
				list.put(temp_room_no, obj.toString());
				
				// selected date
				// day.setStyleId("tgcalSelected");

				// today
				// day.setStyleId("tgcalToday");
				days[tmpInt++] = day;
			}
			}

		}

		if (events != null && events.size() > 0) {
			// step 4 : insert events info
			for (Iterator iter = events.iterator(); iter.hasNext();) {
				evt = (RoomEvent) iter.next();

				String roomNo = evt.getRoomNo();
				
				String type = evt.getType();//0 房间信息 1旅客信息
				if (list.get(roomNo) != null && type.equals("1") ) {
					String  temp_arr_length = (String) list.get(roomNo);
					if(temp_arr_length != null && temp_arr_length.length() > 0)
					{
					int 	tempLength = Integer.parseInt(temp_arr_length);
					day = days[tempLength];
				   int	temp_livePersonCount = day.getLivePersonCount();
				   int temp_liveMaleCount = day.getLiveMaleCount();
				   int temp_liveFemaleCount = day.getLiveFemaleCount();
				    day.setLivePersonCount(temp_livePersonCount+1);
				    if(evt.getLiveSex() !=null && evt.getLiveSex().equals("1"))//男性
				    day.setLiveMaleCount(temp_liveMaleCount+1);
				    if(evt.getLiveSex() !=null && evt.getLiveSex().equals("2"))//女性
				    day.setLiveFemaleCount(temp_liveFemaleCount+1);
					day.setStyleClass(evt.getRoomStyleId());
					if (evt.getIcon() != null) {
						if ( isShowRoomIcon())  {
							day.setRoomTodayLive(evt.getRoomTodayLive());
							day.setLiveName(evt.getLiveName());
							day.setLiveIntime(evt.getLiveIntime());
							day.setLiveSex(evt.getLiveSex());
							day.setLiveSexName(evt.getLiveSexName());
							day.setLiveIdcard(evt.getLiveIdcard());
							day.setFlagcqbf(evt.getFlagcqbf());
							day.setStyleClass(evt.getRoomStyleId());
							day.setLink(evt.getLink());
						} else {
						day.addLine("<a href =\"" + evt.getLink()
								+ "\" class=\"tgcalDayLink\">"
								+ "<img class=\"tgCalIcon\" border=\"0\" src=\""
								+ evt.getIcon() + "\"/>" + "</a>");
						}
					} else {
						if ( isShowRoomIcon()) {
							day.setRoomTodayLive(evt.getRoomTodayLive());
							day.setLiveName(evt.getLiveName());
							day.setLiveIntime(evt.getLiveIntime());
							day.setLiveSex(evt.getLiveSex());
							day.setLiveSexName(evt.getLiveSexName());
							day.setLiveIdcard(evt.getLiveIdcard());
							day.setFlagcqbf(evt.getFlagcqbf());
							day.setStyleClass(evt.getRoomStyleId());
							day.setLink(evt.getLink());
						} else {
						day.addLine("<a href =\"" + evt.getLink()
								+ "\" class=\"tgcalDayLink\">" + evt.getTitle()
								+ "</a>");
						}
					}
					}
				} else if (list.get(roomNo) != null && type.equals("0") ) { //根据取的房间表数据修改房间信息，是否包房，房间类型，床位数
					String  temp_arr_length = (String) list.get(roomNo);
					if(temp_arr_length != null && temp_arr_length.length() > 0)
					{
					int 	tempLength = Integer.parseInt(temp_arr_length);
					day = days[tempLength];
					if (evt.getIcon() != null && evt.getRoomLong() != null ) {
						if ( isShowRoomIcon())  { 
							
							day.setRoomBedNum(evt.getRoomBedNum());
							day.setRoomTel(evt.getRoomTel());
							day.setRoomType(evt.getRoomType());
							day.setRoomTypeName(evt.getRoomTypeName());
							day.setRoomAddBed(evt.getRoomAddBed());
							day.setRoomPrice(evt.getRoomPrice());
							day.setRoomLong(evt.getRoomLong());
							day.setRoomUse(evt.getRoomUse());
							day.setRoomUseName(evt.getRoomUseName());
							day.setRoomTotalLiveCount(evt.getRoomAddBed().add(evt.getRoomBedNum()));////房间总入住数
							
						} 
					} 
					}
					
					
					
				}

			}
		}

		return days;
	}

	public static String padString(String s, int i, String s1, boolean flag) {
		int j = i - s.length();
		if (j > 0) {
			StringBuffer stringbuffer = new StringBuffer();
			for (int k = 1; k <= j / s1.length(); k++)
				stringbuffer.append(s1);

			stringbuffer.append(s1.substring(0, j % s1.length()));
			if (flag)
				return stringbuffer.toString() + s;
			else
				return s + stringbuffer.toString();
		} else {
			return s.substring(0, i);
		}
	}

	public static boolean isNumeric(String input) {
		if (isEmpty(input)) {
			return false;
		}

		for (int i = 0; i < input.length(); i++) {
			char charAt = input.charAt(i);

			if (!Character.isDigit(charAt)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isEmpty(String input) {
		return (input == null || input.length() == 0);
	}

}
