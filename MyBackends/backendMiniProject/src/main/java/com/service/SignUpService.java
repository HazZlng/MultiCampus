package com.service;

import com.domain.MemberVO;

public interface SignUpService {
	//아이디 중복 체크
	public int idCheck(String userId);
	
	//회원 가입
	public void signUp(MemberVO vo);
}
