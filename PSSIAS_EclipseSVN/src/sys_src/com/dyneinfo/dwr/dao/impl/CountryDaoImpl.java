package com.dyneinfo.dwr.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


import com.dyneinfo.dwr.dao.CountryDao;
import com.dyneinfo.dwr.model.City;
import com.dyneinfo.dwr.model.Country;
import com.dyneinfo.dwr.model.Province;


public class CountryDaoImpl extends JdbcDaoSupport implements CountryDao {
	
	
	

	   
	public List<Country> queryAll() {
		String sql = "select CODE,CALLED,I_CODE from T_BUREAU";
		List listCountry = getJdbcTemplate().query(sql, new CountryMapper());
		return listCountry;
	}

	protected class CountryMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Country country = new Country();
			country.setId(rs.getString("CODE"));
			country.setCountryName(rs.getString("CALLED"));
			return country;

		}
	}
	
	
	
	
	
	
	public List<Province> queryProvinceById(String countryId) {
		//String sql = "select * from province where countryId = ?";
//		String sql = "select CODE,CALLED from T_STATION  where BUR_CODE = ? ";
		String sql ="select t.deptid CODE,t.deptname CALLED from SS_DEPT t where t.parentid = ?";
		System.out.println(sql);
		Object[] params = new Object[] { countryId };
		int[] types = new int[] { Types.CHAR };
		List listProvince = getJdbcTemplate().query(sql, params, types,
				new ProvinceMapper());
		return listProvince;
	}
	
	
	
	
	public List<City> queryXzqhById(String provinceId) {
		List listCity  = null;
		if(provinceId != null && provinceId.length() > 0){
		String sql = "select CODE,CALLED  from t_dic_xzqh  where substr(code,0,2)= ? and  substr(code,3)!='0000' order by CODE";
		Object[] params = new Object[] { provinceId };
		int[] types = new int[] { Types.CHAR };
		listCity = getJdbcTemplate().query(sql, params, types,
				new xzqhCityMapper());
		if(listCity == null || (listCity != null && listCity.size() == 0)){
			//System.out.println("provinceId="+provinceId);
			City city = new City();
			if(provinceId != null && provinceId.length() > 0)
			  city.setId(provinceId+"0000");
			  else { 
				  city.setId("");
				 // System.out.println("setId="+provinceId);
			  }
			city.setCityName("其他");
			listCity.add(city);
		}
		}
		return listCity;
	}
	
	
	protected class xzqhCityMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {	
			City city = new City();
			city.setId(rs.getString("CODE"));
			city.setCityName(rs.getString("CALLED"));
			return city;

		}
	}
	

	protected class ProvinceMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {	
			Province province = new Province();
			province.setId(rs.getString("CODE"));
			province.setProvinceName(rs.getString("CALLED"));
			return province;

		}
	}
	
	
	public List<City> queryCityById(String provinceId) {
		String sql = "select CPCODE AS CODE,CPNAME AS CALLED  from T_COMPANYINFO where STACODE = ? and STATUS = '1'";
		Object[] params = new Object[] { provinceId };
		int[] types = new int[] { Types.CHAR };
		List listCity = getJdbcTemplate().query(sql, params, types,
				new CityMapper());
		return listCity;
	}

	protected class CityMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {	
			City city = new City();
			city.setId(rs.getString("CODE"));
			city.setCityName(rs.getString("CALLED"));
			return city;

		}
	}
	
	
	
	public List<Province> queryPcsById(String countryId) {
		
		String sql = "select CODE,CALLED from T_STATION  where CODE = ? ";
		Object[] params = new Object[] { countryId };
		int[] types = new int[] { Types.CHAR };
		List listProvince = getJdbcTemplate().query(sql, params, types,
				new ProvinceMapper());
		return listProvince;
	}


}
