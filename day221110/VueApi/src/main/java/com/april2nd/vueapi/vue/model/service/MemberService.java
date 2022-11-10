package com.april2nd.vueapi.vue.model.service;

import com.april2nd.vueapi.vue.model.MemberDto;

public interface MemberService {

	public MemberDto login(MemberDto memberDto) throws Exception;
	public MemberDto userInfo(String userid) throws Exception;
	
}
