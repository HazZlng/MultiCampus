package com.service;

import javax.servlet.http.HttpSession;

import com.domain.MemberVO;

public interface MemberService {

	//�α��� üũ
	public boolean loginCheck(MemberVO vo,HttpSession session);
	
	//�α� �ƿ�
	public void logout(HttpSession session);
	
}