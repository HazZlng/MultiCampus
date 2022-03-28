package com.service;

import java.util.List;

import com.domain.BoardVO;

public interface BoardService {
	// �� ��� ��ȸ
	List<BoardVO> getBoardList();
	
	// �� �� ��ȸ
	BoardVO getContent(BoardVO vo);
	
	// �� ���
	void insertBoard(BoardVO vo);

	// �� ����
	void updateBoard(BoardVO vo);

	// �� ����
	void deleteBoard(BoardVO vo);
}
