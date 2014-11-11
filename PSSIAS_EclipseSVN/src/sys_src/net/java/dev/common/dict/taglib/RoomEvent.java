package net.java.dev.common.dict.taglib;

public class RoomEvent {
	
	
	private String type; // 0 房间信息 1旅客信息

	private String title;
	private String icon;
	private String link;
	
	// 0 房间信息
	private String roomStyleId = "tgcalEvent";// css tgcalEventjw  国外  tgcalEvent 国内
	private String roomNo;
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
	private String flagcqbf;// 是否包房
	private String roomTodayLive;// 今日新入住 0 否 1 是
	
	

	public String getFlagcqbf() {
		return flagcqbf;
	}
	public void setFlagcqbf(String flagcqbf) {
		this.flagcqbf = flagcqbf;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getRoomStyleId() {
		return roomStyleId;
	}
	public void setRoomStyleId(String roomStyleId) {
		this.roomStyleId = roomStyleId;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
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
	public String getLiveIntime() {
		return LiveIntime;
	}
	public void setLiveIntime(String liveIntime) {
		LiveIntime = liveIntime;
	}
	public String getRoomTodayLive() {
		return roomTodayLive;
	}
	public void setRoomTodayLive(String roomTodayLive) {
		this.roomTodayLive = roomTodayLive;
	}
	public String getLiveSex() {
		return LiveSex;
	}
	public void setLiveSex(String liveSex) {
		LiveSex = liveSex;
	}
	public String getLiveSexName() {
		return LiveSexName;
	}
	public void setLiveSexName(String liveSexName) {
		LiveSexName = liveSexName;
	}
	public String getLiveIdcard() {
		return LiveIdcard;
	}
	public void setLiveIdcard(String liveIdcard) {
		LiveIdcard = liveIdcard;
	}
	
	
	
	public String getRoomUseName() {
		return roomUseName;
	}
	public void setRoomUseName(String roomUseName) {
		this.roomUseName = roomUseName;
	}
	
	
	



}
