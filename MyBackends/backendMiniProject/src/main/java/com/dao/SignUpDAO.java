package com.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.domain.MemberVO;

@Repository
public class SignUpDAO {
	@Autowired
	SqlSession sqlsession;
	
	//아이디 체크
	public int idCheck(String userId) {
		System.out.println("===> Mybatis로 idCheck");
		int result = sqlsession.selectOne("memberMapper.idCheck", userId);
		return result;
	}
	
	//회원가입
	public void signUp(MemberVO vo) {
		System.out.println("===> Mybatis로 회원가입(signUp)");
		sqlsession.insert("memberMapper.signUp",vo);
	}
}
