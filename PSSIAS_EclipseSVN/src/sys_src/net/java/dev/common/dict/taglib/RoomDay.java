package net.java.dev.common.dict.taglib;

public class RoomDay {
	private String styleId = null;
    private String styleClass = null;
	private String ctx = null;
    private String roomImageLine = null;//房间状态图片  
    private String checkInImageLine = null;//有旅客入住再入住小图标
    private String todayLiveImageLine = null;//今日新入住小图标
    private String roomUseImageLine = null;//房间用途小图标
	private  int livePersonCount = 0;//入住人员数
	private  int liveMaleCount = 0;//入住男性数
	private  int liveFemaleCount = 0;//入住女性数
	private  java.math.BigDecimal roomTotalLiveCount = null;//房间总入住数



	 private String roomNo = null;//房号
	 protected String roomDefaultIcon = null;
	 protected String roomDefaultIconLink = null;
    
	// 0 房间信息
	
	private java.math.BigDecimal roomBedNum;// 床位数
	private String roomTel; //房间电话
	private String roomType;// 房间类型ID
	private String roomTypeName;// 房间类型
	private java.math.BigDecimal roomAddBed;// 允许加床数;
	private java.math.BigDecimal roomPrice;// 价格
	private String roomLong;//  是否包房  0 否 1 是
	private String roomUse;// 房间用途
	private String roomUseName;// 房间用途
	
	


	//1 旅客信息
	private String LiveName;// 入住人姓名
	private String LiveIntime;// 入住时间
	private String LiveSex;// 入住人sex
	private String LiveSexName;// 入住人sex
	private String LiveIdcard;// 证件号码
	private String flagcqbf;// 是否包房   0 否 1 是
	private String roomTodayLive;// 今日新入住 0 否 1 是
	private String link; // 退宿或其他链接
	
    public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getCheckInImageLine() {
		return checkInImageLine;
	}
	public void setCheckInImageLine(String checkInImageLine) {
		this.checkInImageLine = checkInImageLine;
	}
	public String getTodayLiveImageLine() {
		return todayLiveImageLine;
	}
	public void setTodayLiveImageLine(String todayLiveImageLine) {
		this.todayLiveImageLine = todayLiveImageLine;
	}
	public int getLiveMaleCount() {
		return liveMaleCount;
	}
	public void setLiveMaleCount(int liveMaleCount) {
		this.liveMaleCount = liveMaleCount;
	}
	public int getLiveFemaleCount() {
		return liveFemaleCount;
	}
	public void setLiveFemaleCount(int liveFemaleCount) {
		this.liveFemaleCount = liveFemaleCount;
	}
	
	public java.math.BigDecimal getRoomTotalLiveCount() {
		return roomTotalLiveCount;
	}
	public void setRoomTotalLiveCount(java.math.BigDecimal roomTotalLiveCount) {
		this.roomTotalLiveCount = roomTotalLiveCount;
	}


	public java.math.BigDecimal getRoomBedNum() {
		return roomBedNum;
	}
	public void setRoomBedNum(java.math.BigDecimal roomBedNum) {
		this.roomBedNum = roomBedNum;
	}
	public String getRoomTel() {
		return roomTel;
	}
	public void setRoomTel(String roomTel) {
		this.roomTel = roomTel;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	public String getRoomTypeName() {
		return roomTypeName;
	}
	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}
	
	public java.math.BigDecimal getRoomAddBed() {
		return roomAddBed;
	}
	public void setRoomAddBed(java.math.BigDecimal roomAddBed) {
		this.roomAddBed = roomAddBed;
	}
	public java.math.BigDecimal getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(java.math.BigDecimal roomPrice) {
		this.roomPrice = roomPrice;
	}
	public String getRoomLong() {
		return roomLong;
	}
	public void setRoomLong(String roomLong) {
		this.roomLong = roomLong;
	}
	public String getRoomUse() {
		return roomUse;
	}
	public void setRoomUse(String roomUse) {
		this.roomUse = roomUse;
	}
	public String getLiveName() {
		return LiveName;
	}
	public void setLiveName(String liveName) {
		LiveName = liveName;
	}
	public String getLiveSexName() {
		return LiveSexName;
	}
	public void setLiveSexName(String liveSexName) {
		LiveSexName = liveSexName;
	}
	public String getLiveIntime() {
		return LiveIntime;
	}
	public void setLiveIntime(String liveIntime) {
		LiveIntime = liveIntime;
	}
	public String getLiveSex() {
		return LiveSex;
	}
	public void setLiveSex(String liveSex) {
		LiveSex = liveSex;
	}
	public String getLiveIdcard() {
		return LiveIdcard;
	}
	public void setLiveIdcard(String liveIdcard) {
		LiveIdcard = liveIdcard;
	}
	public String getFlagcqbf() {
		return flagcqbf;
	}
	public void setFlagcqbf(String flagcqbf) {
		this.flagcqbf = flagcqbf;
	}
	public String getRoomTodayLive() {
		return roomTodayLive;
	}
	public void setRoomTodayLive(String roomTodayLive) {
		this.roomTodayLive = roomTodayLive;
	}





	
	


	

	private StringBuffer lines = new StringBuffer() ;
    
    public String getLines() {
        return lines.toString();
    }
    public void addLine(String line) {
        if (this.lines.length() != 0){
            this.lines.append("<br/>"); 
        }
        this.lines.append(line);
    }
    public String getStyleClass() {
        return styleClass;
    }
    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }
    public String getStyleId() {
        return styleId;
    }
    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }
    
    public String getRoomImageLine() {
		return roomImageLine;
	}
	public void setRoomImageLine(String roomImageLine) {
		this.roomImageLine = roomImageLine;
	}
	public int getLivePersonCount() {
		return livePersonCount;
	}
	public void setLivePersonCount(int livePersonCount) {
		this.livePersonCount = livePersonCount;
	}

	 public String getRoomNo() {
			return roomNo;
		}
		public void setRoomNo(String roomNo) {
			this.roomNo = roomNo;
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


		public String getCtx() {
			return ctx;
		}
		public void setCtx(String ctx) {
			this.ctx = ctx;
		}


		public String getRoomUseName() {
			return roomUseName;
		}
		public void setRoomUseName(String roomUseName) {
			this.roomUseName = roomUseName;
		}


//入住选择
		
		 public String getSelectRoomHtmlIconString(){
		        StringBuffer sb = new StringBuffer();
		        sb.append("<td ");
		        if (styleClass != null){
		            sb.append(" class=\"" + styleClass + "\"");
		        }
		        if (styleId != null){
		            sb.append(" id=\"" + styleId + "\"");
		        }
		        
		        //房间类型
		        if(getRoomType() != null && getRoomType().length() > 0) {
		        if(getRoomType() == null || (getRoomType() != null && getRoomType().length() ==0))
		        	roomType = "0";
		        roomUseImageLine = "<img class=\"tgCalIcon\" border=\"0\"  title=\""
					+ getRoomTypeName()
					+ "\" src=\""
					+ getCtx()
					+ "/images/room/"+roomType+".gif\"/>";
		        }
		        if (livePersonCount == 0) { // 入住人员数
		        	if( getRoomType() != null && getRoomPrice() != null )
		        	roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
						+ "<img class=\"tgCalIcon\" border=\"0\"  title=\"房间类型： "
						+ getRoomTypeName() + " \r\n床位数： " + getRoomTotalLiveCount()
						+ " \r\n加床数： " + getRoomAddBed() + " \" src=\""
						+ getRoomDefaultIcon() + "\"/>" + "</a>";
		        	else 
		        		roomImageLine = "<img class=\"tgCalIcon\" border=\"0\"  title=\"房间不存在\"  src=\""
							+ getCtx() + "/images/room/notexist.gif\"/>";
		        		
				if (getRoomLong() != null && getRoomLong().equals("1"))// 包房
//					roomImageLine = "<img class=\"tgCalIcon\" border=\"0\"  title=\"包房\"  src=\""
//							+ getCtx() + "/images/room/stop.gif\"/>";
				
				
				roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
				+ "<img class=\"tgCalIcon\" border=\"0\"  title=\"包房 "
				+ " \r\n床位数 " + getRoomTotalLiveCount()
				+ " \r\n加床数： " + getRoomAddBed() +  " \" src=\""
				+ getCtx() + "/images/room/stop.gif\"/>" + "</a>";
			    }
		        
		     // 有旅客入住再入住小图标
		        if(roomTotalLiveCount != null) {
		        int int_roomTotalLiveCount =  roomTotalLiveCount.intValue();
		        if(livePersonCount < int_roomTotalLiveCount && livePersonCount > 0)
		        	roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
						+ "<img class=\"tgCalIcon\" border=\"0\"  title=\"点击入住\r\n房间类型： "
						+ getRoomTypeName() + " \r\n床位数： " + getRoomTotalLiveCount()
						+ " \r\n已住人数： " + getLivePersonCount() + " \" src=\""
						+ getCtx() + "/images/room/roomin.gif\"/>" + "</a>";
		        }
				// 今日新入住小图标
		        if(roomTodayLive != null && roomTodayLive.equals("1"))
		        	todayLiveImageLine = "<img class=\"tgCalIcon\" border=\"0\"  title=\"今日入住\"  src=\""
					+ getCtx() + "/images/room/iconCalendar.gif\"/>";
		        
		        
		        
		        if(getRoomUse() != null &&  getRoomUse().equals("1") && roomTotalLiveCount != null) {
		        	  int int_roomTotalLiveCount =  roomTotalLiveCount.intValue();
		        	   if(livePersonCount < int_roomTotalLiveCount ) { //房间是否满人，没有可以继续入住
		        
		        if( livePersonCount == 1){ //入住人员数
		        	if(liveMaleCount ==0 && liveFemaleCount ==1){//一个女性
		        		roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
							+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
							+ getLiveName() + " \r\n入住时间： "
							+ getLiveIntime() + " \" src=\"" +getCtx() + "/images/room/one_female.gif"
							+ "\"/>" + "</a>";
					
		        	}
		        	else if(liveMaleCount ==1 && liveFemaleCount ==0){//一个男性
		        		roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
						+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
						+ getLiveName() + " \r\n入住时间： "
						+ getLiveIntime() + " \" src=\"" +getCtx() + "/images/room/one_male.gif"
						+ "\"/>" + "</a>";
		        	}
		        	else {//其他
		        		roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
						+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
						+ getLiveName() + " \r\n入住时间： "
						+ getLiveIntime() + " \" src=\"" +getCtx() + "/images/room/one_other.gif"
						+ "\"/>" + "</a>";
		        	}
		        }
		        if (livePersonCount == 2) { // 入住人员数
				if (liveMaleCount == 0 && liveFemaleCount == 2) {// 二个女性
					roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
							+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
							+ getLiveName() + " \r\n入住时间： " + getLiveIntime()
							+ " \" src=\"" + getCtx() + "/images/room/two_female.gif"
							+ "\"/>" + "</a>";
				} else if (liveMaleCount == 2 && liveFemaleCount == 0) {// 二个男性
					roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
							+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
							+ getLiveName() + " \r\n入住时间： " + getLiveIntime()
							+ " \" src=\"" + getCtx() + "/images/room/two_male.gif"
							+ "\"/>" + "</a>";
				} else if (liveMaleCount == 1 && liveFemaleCount == 1) {// 一男一女
					roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
							+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
							+ getLiveName() + " \r\n入住时间： " + getLiveIntime()
							+ " \" src=\"" + getCtx() + "/images/room/two_male_female.gif"
							+ "\"/>" + "</a>";
				} else  {// 其他
					roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
							+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
							+ getLiveName() + " \r\n入住时间： " + getLiveIntime()
							+ " \" src=\"" + getCtx() + "/images/room/two_other.gif"
							+ "\"/>" + "</a>";
				}
		        	
		        }
		        if( livePersonCount == 3){ //入住人员数
				if (liveMaleCount == 3 && liveFemaleCount == 0) {// 三男
					roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
							+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
							+ getLiveName() + " \r\n入住时间： " + getLiveIntime()
							+ " \" src=\"" + getCtx()
							+ "/images/room/three_male.gif" + "\"/>" + "</a>";
				} else if (liveMaleCount == 0 && liveFemaleCount == 3) {// 三女
					roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
							+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
							+ getLiveName() + " \r\n入住时间 ：" + getLiveIntime()
							+ " \" src=\"" + getCtx()
							+ "/images/room/three_female.gif" + "\"/>" + "</a>";
				} else {// 其他
					roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
							+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
							+ getLiveName() + " \r\n入住时间 ：" + getLiveIntime()
							+ " \" src=\"" + getCtx()
							+ "/images/room/three_other.gif" + "\"/>" + "</a>";
				}
		        	
		        }
		        if( livePersonCount > 3){ //入住人员数
		        	roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
					+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
					+ getLiveName() + " \r\n入住时间： " + getLiveIntime()
					+ " \" src=\"" + getCtx()
					+ "/images/room/three_over.gif" + "\"/>" + "</a>";
		        }
		        
		        	   } else {
		        		   //房间已满
		        			roomImageLine = "<img class=\"tgCalIcon\" border=\"0\"  title=\"房间已住满\"  src=\""
								+ getCtx() + "/images/room/manren.gif\"/>";
		        		   
		        	   }
		        }  else {  //非客房
		        	if(getRoomUse() != null && !getRoomUse().equals("0"))
		        	roomImageLine = "<img class=\"tgCalIcon\" border=\"0\"  title=\"房间用途："+getRoomUseName()+"\"  src=\""
						+ getCtx() + "/images/room/use"+getRoomUse()+".gif\"/>";
		        	
		        }
		        
		        if(getRoomUse() != null &&  getRoomUse().equals("1") && roomTotalLiveCount != null) {
		        sb.append(">" + lines.toString()+"&nbsp;"+(roomUseImageLine == null?"":roomUseImageLine)+(todayLiveImageLine==null?"":todayLiveImageLine)+"<br/>"+roomImageLine + "</td>");
		        return sb.toString();
		        } else {
		        	 sb.append(">" + lines.toString()+"&nbsp;"+"<br/>"+roomImageLine + "</td>");
				        return sb.toString();
		        }
		        	
		    }
		


		 //退宿选择，房间满人也可以点击
		 
		 public String getSelectOutRoomHtmlIconString(){
		        StringBuffer sb = new StringBuffer();
		        sb.append("<td ");
		        if (styleClass != null){
		            sb.append(" class=\"" + styleClass + "\"");
		        }
		        if (styleId != null){
		            sb.append(" id=\"" + styleId + "\"");
		        }
		        
		        //房间类型
		        if(getRoomType() != null && getRoomType().length() > 0) {
		        if(getRoomType() == null || (getRoomType() != null && getRoomType().length() ==0))
		        	roomType = "0";
		        roomUseImageLine = "<img class=\"tgCalIcon\" border=\"0\"  title=\""
					+ getRoomTypeName()
					+ "\" src=\""
					+ getCtx()
					+ "/images/room/"+roomType+".gif\"/>";
		        }
		        if (livePersonCount == 0) { // 入住人员数
		        	if( getRoomType() != null && getRoomPrice() != null )
		        	roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
						+ "<img class=\"tgCalIcon\" border=\"0\"  title=\"房间类型： "
						+ getRoomTypeName() + " \r\n床位数： " + getRoomTotalLiveCount()
						+ " \r\n加床数： " + getRoomAddBed() +  " \" src=\""
						+ getRoomDefaultIcon() + "\"/>" + "</a>";
		        	else 
		        		roomImageLine = "<img class=\"tgCalIcon\" border=\"0\"  title=\"房间不存在\"  src=\""
							+ getCtx() + "/images/room/notexist.gif\"/>";
		        		
				if (getRoomLong() != null && getRoomLong().equals("1"))// 包房
//					roomImageLine = "<img class=\"tgCalIcon\" border=\"0\"  title=\"包房\"  src=\""
//							+ getCtx() + "/images/room/stop.gif\"/>";
				
				
				roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
				+ "<img class=\"tgCalIcon\" border=\"0\"  title=\"包房 "
				+ " \r\n床位数 " + getRoomTotalLiveCount()
				+ " \r\n加床数： " + getRoomAddBed() + " \" src=\""
				+ getCtx() + "/images/room/stop.gif\"/>" + "</a>";
			    }
		        
		     // 有旅客入住再入住小图标
		        if(roomTotalLiveCount != null) {
		        int int_roomTotalLiveCount =  roomTotalLiveCount.intValue();
		        if(livePersonCount < int_roomTotalLiveCount && livePersonCount > 0)
		        	roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
						+ "<img class=\"tgCalIcon\" border=\"0\"  title=\"点击入住\r\n房间类型： "
						+ getRoomTypeName() + " \r\n床位数： " + getRoomTotalLiveCount()
						+ " \r\n已住人数： " + getLivePersonCount() + " \" src=\""
						+ getCtx() + "/images/room/roomin.gif\"/>" + "</a>";
		        }
				// 今日新入住小图标
		        if(roomTodayLive != null && roomTodayLive.equals("1"))
		        	todayLiveImageLine = "<img class=\"tgCalIcon\" border=\"0\"  title=\"今日入住\"  src=\""
					+ getCtx() + "/images/room/iconCalendar.gif\"/>";
		        
		        
		        
		        if(getRoomUse() != null &&  getRoomUse().equals("1") && roomTotalLiveCount != null) {
		        	  int int_roomTotalLiveCount =  roomTotalLiveCount.intValue();
		        	   if(livePersonCount < int_roomTotalLiveCount ) { //房间是否满人，没有可以继续入住
		        
		        if( livePersonCount == 1){ //入住人员数
		        	if(liveMaleCount ==0 && liveFemaleCount ==1){//一个女性
		        		roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
							+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
							+ getLiveName() + " \r\n入住时间： "
							+ getLiveIntime() + " \" src=\"" +getCtx() + "/images/room/one_female.gif"
							+ "\"/>" + "</a>";
					
		        	}
		        	else if(liveMaleCount ==1 && liveFemaleCount ==0){//一个男性
		        		roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
						+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
						+ getLiveName() + " \r\n入住时间： "
						+ getLiveIntime() + " \" src=\"" +getCtx() + "/images/room/one_male.gif"
						+ "\"/>" + "</a>";
		        	}
		        	else {//其他
		        		roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
						+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
						+ getLiveName() + " \r\n入住时间： "
						+ getLiveIntime() + " \" src=\"" +getCtx() + "/images/room/one_other.gif"
						+ "\"/>" + "</a>";
		        	}
		        }
		        if (livePersonCount == 2) { // 入住人员数
				if (liveMaleCount == 0 && liveFemaleCount == 2) {// 二个女性
					roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
							+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
							+ getLiveName() + " \r\n入住时间： " + getLiveIntime()
							+ " \" src=\"" + getCtx() + "/images/room/two_female.gif"
							+ "\"/>" + "</a>";
				} else if (liveMaleCount == 2 && liveFemaleCount == 0) {// 二个男性
					roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
							+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
							+ getLiveName() + " \r\n入住时间： " + getLiveIntime()
							+ " \" src=\"" + getCtx() + "/images/room/two_male.gif"
							+ "\"/>" + "</a>";
				} else if (liveMaleCount == 1 && liveFemaleCount == 1) {// 一男一女
					roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
							+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
							+ getLiveName() + " \r\n入住时间： " + getLiveIntime()
							+ " \" src=\"" + getCtx() + "/images/room/two_male_female.gif"
							+ "\"/>" + "</a>";
				} else  {// 其他
					roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
							+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
							+ getLiveName() + " \r\n入住时间： " + getLiveIntime()
							+ " \" src=\"" + getCtx() + "/images/room/two_other.gif"
							+ "\"/>" + "</a>";
				}
		        	
		        }
		        if( livePersonCount == 3){ //入住人员数
				if (liveMaleCount == 3 && liveFemaleCount == 0) {// 三男
					roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
							+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
							+ getLiveName() + " \r\n入住时间： " + getLiveIntime()
							+ " \" src=\"" + getCtx()
							+ "/images/room/three_male.gif" + "\"/>" + "</a>";
				} else if (liveMaleCount == 0 && liveFemaleCount == 3) {// 三女
					roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
							+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
							+ getLiveName() + " \r\n入住时间 ：" + getLiveIntime()
							+ " \" src=\"" + getCtx()
							+ "/images/room/three_female.gif" + "\"/>" + "</a>";
				} else {// 其他
					roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
							+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
							+ getLiveName() + " \r\n入住时间 ：" + getLiveIntime()
							+ " \" src=\"" + getCtx()
							+ "/images/room/three_other.gif" + "\"/>" + "</a>";
				}
		        	
		        }
		        if( livePersonCount > 3){ //入住人员数
		        	roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
					+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
					+ getLiveName() + " \r\n入住时间： " + getLiveIntime()
					+ " \" src=\"" + getCtx()
					+ "/images/room/three_over.gif" + "\"/>" + "</a>";
		        }
		        
		        	   } else {
		        		   //房间已满
		        			roomImageLine = "<a onclick=\"javascript:selRoom('"+roomNo+"');\" href=\"#\" class=\"tgcalDayLink\">"
		        			    + "<img class=\"tgCalIcon\" border=\"0\"  title=\"房间已住满\"  src=\""
								+ getCtx() + "/images/room/manren.gif\"/></a>";
		        		   
		        	   }
		        }  else {  //非客房
		        	if(getRoomUse() != null && !getRoomUse().equals("0"))
		        	roomImageLine = "<img class=\"tgCalIcon\" border=\"0\"  title=\"房间用途："+getRoomUseName()+"\"  src=\""
						+ getCtx() + "/images/room/use"+getRoomUse()+".gif\"/>";
		        	
		        }
		        
		        if(getRoomUse() != null &&  getRoomUse().equals("1") && roomTotalLiveCount != null) {
		        sb.append(">" + lines.toString()+"&nbsp;"+(roomUseImageLine == null?"":roomUseImageLine)+(todayLiveImageLine==null?"":todayLiveImageLine)+"<br/>"+roomImageLine + "</td>");
		        return sb.toString();
		        } else {
		        	 sb.append(">" + lines.toString()+"&nbsp;"+"<br/>"+roomImageLine + "</td>");
				        return sb.toString();
		        }
		        	
		    }
	
	 public String getShowRoomHtmlIconString(){
	        StringBuffer sb = new StringBuffer();
	        sb.append("<td ");
	        if (styleClass != null){
	            sb.append(" class=\"" + styleClass + "\"");
	        }
	        if (styleId != null){
	            sb.append(" id=\"" + styleId + "\"");
	        }
	        
	        
	        //房间类型
	        if(getRoomType() != null && getRoomType().length() > 0) {
	        if(getRoomType() == null || (getRoomType() != null && getRoomType().length() ==0))
	        	roomType = "0";
	        roomUseImageLine = "<img class=\"tgCalIcon\" border=\"0\"  title=\""
				+ getRoomTypeName()
				+ "\" src=\""
				+ getCtx()
				+ "/images/room/"+roomType+".gif\"/>";
	        }
	        if (livePersonCount == 0) { // 入住人员数
	        	if( getRoomType() != null && getRoomPrice() != null )
	        	roomImageLine = "<a href =\"" + getRoomDefaultIconLink()
					+ "?roomNo=" + roomNo + "\" class=\"tgcalDayLink\">"
					+ "<img class=\"tgCalIcon\" border=\"0\"  title=\"房间类型 ："
					+ getRoomTypeName() + " \r\n床位数： " + getRoomTotalLiveCount()
					+ " \r\n加床数： " + getRoomAddBed() +  " \" src=\""
					+ getRoomDefaultIcon() + "\"/>" + "</a>";
	        	else 
	        		roomImageLine = "<img class=\"tgCalIcon\" border=\"0\"  title=\"房间不存在\"  src=\""
						+ getCtx() + "/images/room/notexist.gif\"/>";
	        		
			if (getRoomLong() != null && getRoomLong().equals("1"))// 包房
//				roomImageLine = "<img class=\"tgCalIcon\" border=\"0\"  title=\"包房\"  src=\""
//						+ getCtx() + "/images/room/stop.gif\"/>";
				
				roomImageLine = "<a href =\"" + getRoomDefaultIconLink()
				+ "?roomNo=" + roomNo + "\" class=\"tgcalDayLink\">"
				+ "<img class=\"tgCalIcon\" border=\"0\"  title=\"包房 "
			+ " \r\n床位数： " + getRoomTotalLiveCount()
				+ " \r\n加床数： " + getRoomAddBed() +  " \" src=\""
						+ getCtx() + "/images/room/stop.gif\"/>" + "</a>";
		}
	        
	     // 有旅客入住再入住小图标
	        if(roomTotalLiveCount != null) {
	        int int_roomTotalLiveCount =  roomTotalLiveCount.intValue();
	        if(livePersonCount < int_roomTotalLiveCount && livePersonCount > 0)
	        	checkInImageLine = "<a href =\""
					+ getRoomDefaultIconLink()
					+ "?roomNo="
					+ roomNo
					+ "\" class=\"tgcalDayLink\">"
					+ "<img class=\"tgCalIcon\" border=\"0\"  title=\"点击入住\r\n房间类型： "
					+ getRoomTypeName() + " \r\n床位数： " + getRoomTotalLiveCount()
					+ " \r\n已住人数： " + getLivePersonCount() + " \" src=\""
					+ getCtx() + "/images/room/roomin.gif\"/>" + "</a>";
	        }
			// 今日新入住小图标
	        if(roomTodayLive != null && roomTodayLive.equals("1"))
	        	todayLiveImageLine = "<img class=\"tgCalIcon\" border=\"0\"  title=\"今日入住\"  src=\""
				+ getCtx() + "/images/room/iconCalendar.gif\"/>";
	        
	        
	        
	        if(getRoomUse() != null &&  getRoomUse().equals("1") && roomTotalLiveCount != null) {
	        	  int int_roomTotalLiveCount =  roomTotalLiveCount.intValue();
	        	   if(livePersonCount < int_roomTotalLiveCount ) { //房间是否满人，没有可以继续入住
	        
	        
	        
	        if( livePersonCount == 1){ //入住人员数
	        	if(liveMaleCount ==0 && liveFemaleCount ==1){//一个女性
	        		roomImageLine = "<a href =\"" + getLink()
						+ "\" class=\"tgcalDayLink\">"
						+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
						+ getLiveName() + " \r\n入住时间 ："
						+ getLiveIntime() + " \" src=\"" +getCtx() + "/images/room/one_female.gif"
						+ "\"/>" + "</a>";
				
	        	}
	        	else if(liveMaleCount ==1 && liveFemaleCount ==0){//一个男性
	        		roomImageLine = "<a href =\"" + getLink()
					+ "\" class=\"tgcalDayLink\">"
					+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名 ："
					+ getLiveName() + " \r\n入住时间： "
					+ getLiveIntime() + " \" src=\"" +getCtx() + "/images/room/one_male.gif"
					+ "\"/>" + "</a>";
	        	}
	        	else {//其他
	        		roomImageLine = "<a href =\"" + getLink()
					+ "\" class=\"tgcalDayLink\">"
					+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
					+ getLiveName() + " \r\n入住时间： "
					+ getLiveIntime() + " \" src=\"" +getCtx() + "/images/room/one_other.gif"
					+ "\"/>" + "</a>";
	        	}
	        }
	        if (livePersonCount == 2) { // 入住人员数
			if (liveMaleCount == 0 && liveFemaleCount == 2) {// 二个女性
				roomImageLine = "<a href =\"" + getLink()
						+ "\" class=\"tgcalDayLink\">"
						+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
						+ getLiveName() + " \r\n入住时间 ：" + getLiveIntime()
						+ " \" src=\"" + getCtx() + "/images/room/two_female.gif"
						+ "\"/>" + "</a>";
			} else if (liveMaleCount == 2 && liveFemaleCount == 0) {// 二个男性
				roomImageLine = "<a href =\"" + getLink()
						+ "\" class=\"tgcalDayLink\">"
						+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名 ："
						+ getLiveName() + " \r\n入住时间： " + getLiveIntime()
						+ " \" src=\"" + getCtx() + "/images/room/two_male.gif"
						+ "\"/>" + "</a>";
			} else if (liveMaleCount == 1 && liveFemaleCount == 1) {// 一男一女
				roomImageLine = "<a href =\"" + getLink()
						+ "\" class=\"tgcalDayLink\">"
						+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名 ："
						+ getLiveName() + " \r\n入住时间： " + getLiveIntime()
						+ " \" src=\"" + getCtx() + "/images/room/two_male_female.gif"
						+ "\"/>" + "</a>";
			} else  {// 其他
				roomImageLine = "<a href =\"" + getLink()
						+ "\" class=\"tgcalDayLink\">"
						+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
						+ getLiveName() + " \r\n入住时间 ：" + getLiveIntime()
						+ " \" src=\"" + getCtx() + "/images/room/two_other.gif"
						+ "\"/>" + "</a>";
			}
	        	
	        }
	        if( livePersonCount == 3){ //入住人员数
			if (liveMaleCount == 3 && liveFemaleCount == 0) {// 三男
				roomImageLine = "<a href =\"" + getLink()
						+ "\" class=\"tgcalDayLink\">"
						+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名 ："
						+ getLiveName() + " \r\n入住时间： " + getLiveIntime()
						+ " \" src=\"" + getCtx()
						+ "/images/room/three_male.gif" + "\"/>" + "</a>";
			} else if (liveMaleCount == 0 && liveFemaleCount == 3) {// 三女
				roomImageLine = "<a href =\"" + getLink()
						+ "\" class=\"tgcalDayLink\">"
						+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
						+ getLiveName() + " \r\n入住时间： " + getLiveIntime()
						+ " \" src=\"" + getCtx()
						+ "/images/room/three_female.gif" + "\"/>" + "</a>";
			} else {// 其他
				roomImageLine = "<a href =\"" + getLink()
						+ "\" class=\"tgcalDayLink\">"
						+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
						+ getLiveName() + " \r\n入住时间 ：" + getLiveIntime()
						+ " \" src=\"" + getCtx()
						+ "/images/room/three_other.gif" + "\"/>" + "</a>";
			}
	        	
	        }
	        if( livePersonCount > 3){ //入住人员数
	        	roomImageLine = "<a href =\"" + getLink()
				+ "\" class=\"tgcalDayLink\">"
				+ "<img class=\"tgCalIcon\" border=\"0\" title=\"姓名： "
				+ getLiveName() + " \r\n入住时间 ：" + getLiveIntime()
				+ " \" src=\"" + getCtx()
				+ "/images/room/three_over.gif" + "\"/>" + "</a>";
	        }
	        	   } else {
	        		   //房间已满
	        			roomImageLine = "<a href =\"" + getLink()
						+ "\" class=\"tgcalDayLink\">"
						+ "<img class=\"tgCalIcon\" border=\"0\" title=\"房间已住满  姓名 ："
						+ getLiveName() + " \r\n入住时间： " + getLiveIntime()
						+ " \" src=\"" + getCtx()
						+ "/images/room/manren.gif" + "\"/>" + "</a>";
	        		   
	        	   }
	        }  else {  //非客房
	        	if(getRoomUse() != null && !getRoomUse().equals("0"))
	        	roomImageLine = "<img class=\"tgCalIcon\" border=\"0\"  title=\"房间用途："+getRoomUseName()+"\"  src=\""
					+ getCtx() + "/images/room/use"+getRoomUse()+".gif\"/>";
	        	
	        }
	        
	        
	        
	        if(getRoomUse() != null &&  getRoomUse().equals("1") && roomTotalLiveCount != null) {
	        sb.append(">" + lines.toString()+"&nbsp;"+(roomUseImageLine == null?"":roomUseImageLine)+(todayLiveImageLine==null?"":todayLiveImageLine)+(checkInImageLine == null?"":checkInImageLine)+"<br/>"+roomImageLine + "</td>");
	        return sb.toString();
	        } else {
	        	 sb.append(">" + lines.toString()+"&nbsp;"+"<br/>"+roomImageLine + "</td>");
	 	        return sb.toString();
	        }
	    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("<td ");
        if (styleClass != null){
            sb.append(" class=\"" + styleClass + "\"");
        }
        if (styleId != null){
            sb.append(" id=\"" + styleId + "\"");
        }
        sb.append(">" + lines.toString() + "</td>");
        return sb.toString();
    }

}
