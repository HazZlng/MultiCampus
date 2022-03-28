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
	
	//�α��� üũ
	public boolean loginCheck(MemberVO vo) {
		System.out.println("===> Mybatis�� loginCheck() ��� ó��");
		int result = sqlSession.selectOne("memberMapper.loginCheck",vo);
		
		// �˻��� �ȵǸ� 0�� ��ȯ���ֱ� ������ 0�� ���ؼ� ���̸� false, Ʋ���� true�� ��ȯ
		return (result==0)?false:true;
	}
	
	//�α� �ƿ�
	public void logout(HttpSession session) {
		System.out.println("===> �α׾ƿ� ��� ó��");
		session.invalidate();
	}
}
