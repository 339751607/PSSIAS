package com.dyneinfo.dwr.dao;



import java.util.ArrayList;
import java.util.List;




	public interface CountryDao {
		
		/***************************************************************************
		 * 查询所有国家
		 */
		public List queryAll();
		/***************************************************************************
		 * 根据coutryId查询出旗下的省
		 * 
		 * @param countryId
		 * @return
		 */
		public List queryProvinceById(String countryId);
		/***************************************************************************
		 * 根据省id查询所有城市
		 * 
		 * @param provinceId
		 * @return
		 */
		public List queryCityById(String provinceId);
		public List queryXzqhById(String provinceId);
	}



