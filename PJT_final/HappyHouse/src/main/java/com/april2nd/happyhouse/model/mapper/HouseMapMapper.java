package com.april2nd.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.april2nd.happyhouse.model.DealInfoDto;
import com.april2nd.happyhouse.model.HouseInfoDto;
import com.april2nd.happyhouse.model.SidoGugunCodeDto;

@Mapper
public interface HouseMapMapper {

	List<SidoGugunCodeDto> getSido() throws SQLException;
	List<SidoGugunCodeDto> getGugunInSido(String sido) throws SQLException;
	List<HouseInfoDto> getDongInGugun(String gugun) throws SQLException;
	List<HouseInfoDto> getAptInDong(String dong) throws SQLException;
	
	HouseInfoDto getOneApt(String aptCode) throws SQLException;
	
	List<DealInfoDto> getAptFilteredDeals(String apt , String minPriceRange, String maxPriceRange,String minDateRange, String maxDateRange) throws SQLException;
	List<DealInfoDto> getAptDeals(String apt) throws SQLException;
	List<Map<String,String>> searchByDongName(String keyword) throws SQLException;
	List<Map<String,String>> searchByAptName(String keyword) throws SQLException;
	
	
}
