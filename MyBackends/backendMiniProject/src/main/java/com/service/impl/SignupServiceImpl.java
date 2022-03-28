package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.SignUpDAO;
import com.domain.MemberVO;
import com.service.SignUpService;

@Service
public class SignupServiceImpl implements SignUpService {
	@Autowired
	SignUpDAO dao;
	
	@Override
	public int idCheck(String userId) {
		int result = dao.idCheck(userId);
		return result;
	}

	@Override
	public void signUp(MemberVO vo) {
		dao.signUp(vo);
	}
}
