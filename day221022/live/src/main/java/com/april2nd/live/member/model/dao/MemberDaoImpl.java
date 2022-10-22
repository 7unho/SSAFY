package com.april2nd.live.member.model.dao;

import java.sql.SQLException;
import java.util.Map;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.april2nd.live.member.model.MemberDto;
import com.april2nd.live.util.SqlMapConfig;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MemberDaoImpl implements MemberDao {
	private final String NAMESPACE = "com.april2nd.live.member.model.dao.MemberDao.";
	@Override
	public int idCheck(String userId) throws SQLException {
		try(SqlSession sqlSession = SqlMapConfig.getSqlSession()){
			// 1번 째 인자는 어떤 mapper의 id를 호출할거냐, 2번 째는 어떤 값을 보낼거냐
			return sqlSession.selectOne(NAMESPACE + "idCheck", userId);
		}
	}

	@Override
//	@Transactional -> sqlSession.commit()을 하지 않아도 자동으로 커밋해주는 어노테이션
	public void joinMember(MemberDto memberDto) throws SQLException {
		try(SqlSession sqlSession = SqlMapConfig.getSqlSession()){
			sqlSession.insert(NAMESPACE + "joinMember", memberDto);
			sqlSession.commit();
		}
	}

	// map 으로 보내준 이유, 파라미터를 받으려고 억지로 dto를 새로 만드는 것 보다,
	// map으로 필요한 데이터만 보내주는게 효율적일 수 있다.
	@Override
	public MemberDto loginMember(Map<String, String> map) throws SQLException {
		try(SqlSession sqlSession = SqlMapConfig.getSqlSession()){
			return sqlSession.selectOne(NAMESPACE + "loginMember", map);
		}
	}

}
