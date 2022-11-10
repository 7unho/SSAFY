package com.april2nd.vueapi.vue.model.service;

import java.util.List;

import com.april2nd.vueapi.vue.model.HouseInfoDto;
import com.april2nd.vueapi.vue.model.SidoGugunCodeDto;

public interface HouseMapService {

	List<SidoGugunCodeDto> getSido() throws Exception;
	List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception;
	List<HouseInfoDto> getDongInGugun(String gugun) throws Exception;
	List<HouseInfoDto> getAptInDong(String dong) throws Exception;
	
}
