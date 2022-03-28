package com.dao;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.domain.MemberVO;

@Repository
public class MemberDAO {
	@Autowired
	SqlSession sqlSession;
	
	//로그인 체크
	public boolean loginCheck(MemberVO vo) {
		System.out.println("===> Mybatis로 loginCheck() 기능 처리");
		int result = sqlSession.selectOne("memberMapper.loginCheck",vo);
		
		// 검색이 안되면 0을 반환해주기 때문에 0과 비교해서 참이면 false, 틀리면 true를 반환
		return (result==0)?false:true;
	}
	
	//로그 아웃
	public void logout(HttpSession session) {
		System.out.println("===> 로그아웃 기능 처리");
		session.invalidate();
	}
}
