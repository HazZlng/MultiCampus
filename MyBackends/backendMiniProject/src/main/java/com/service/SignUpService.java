package com.service;

import com.domain.MemberVO;

public interface SignUpService {
	//���̵� �ߺ� üũ
	public int idCheck(String userId);
	
	//ȸ�� ����
	public void signUp(MemberVO vo);
}
