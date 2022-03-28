package com.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.domain.MemberVO;

@Repository
public class SignUpDAO {
	@Autowired
	SqlSession sqlsession;
	
	//���̵� üũ
	public int idCheck(String userId) {
		System.out.println("===> Mybatis�� idCheck");
		int result = sqlsession.selectOne("memberMapper.idCheck", userId);
		return result;
	}
	
	//ȸ������
	public void signUp(MemberVO vo) {
		System.out.println("===> Mybatis�� ȸ������(signUp)");
		sqlsession.insert("memberMapper.signUp",vo);
	}
}
