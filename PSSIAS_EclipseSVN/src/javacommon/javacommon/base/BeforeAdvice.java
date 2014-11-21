package javacommon.base;

public class BeforeAdvice {

	/**
	 * 默认治安综合数据源
	 */
	public void setZazhDataSource() {
		DBContextHolder.setDBType("zazh");
	}

	/**
	 * 散装汽油数据源
	 */
	public void setGasDataSource() {
		DBContextHolder.setDBType("gas");
	}

	/**
	 * 机修业数据源
	 */
	public void setJxyDataSource() {
		DBContextHolder.setDBType("jxy");
	}
	
	/**
	 * 典当业数据源
	 */
	public void setPmddDataSource() {
		DBContextHolder.setDBType("pmdd");
	}

	/**
	 * 废旧业数据源
	 */
	public void setFjyDataSource() {
		DBContextHolder.setDBType("fjy");
	}

	/**
	 * 娱乐场所数据源
	 */
	public void setYlcsDataSource() {
		DBContextHolder.setDBType("ylcs");
	}
	
	/**
	 * 旅馆业数据源
	 */
	public void setHotelDataSource() {
		DBContextHolder.setDBType("hotel");
	}
	/**
	 * 重点门卫数据源
	 * **/
	public void setZdmwDataSource(){
		DBContextHolder.setDBType("zdmw");
	}
}
