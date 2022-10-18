package com.april2nd.live1.member.model.service;

import com.april2nd.live1.member.model.MemberDto;
import com.april2nd.live1.member.model.dao.MemberDao;
import com.april2nd.live1.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService{
    private static MemberService memberService = new MemberServiceImpl();
    private MemberDao memberDao;
    private MemberServiceImpl(){
        memberDao = MemberDaoImpl.getMemberDao();
    };

    public static MemberService getMemberService(){
        return memberService;
    }
    @Override
    public int idCheck(String userId) throws Exception {
        return memberDao.idCheck(userId);
    }

    @Override
    public void joinMember(MemberDto memberDto) throws Exception {
        // validation check
        memberDao.joinMember(memberDto);
    }

    @Override
    public MemberDto loginMember(String userId, String password) throws Exception {
        return memberDao.loginMember(userId, password);
    }
}
