package com.service;

import java.util.List;

import com.domain.BoardVO;

public interface BoardService {
	// 글 목록 조회
	List<BoardVO> getBoardList();
	
	// 글 상세 조회
	BoardVO getContent(BoardVO vo);
	
	// 글 등록
	void insertBoard(BoardVO vo);

	// 글 수정
	void updateBoard(BoardVO vo);

	// 글 삭제
	void deleteBoard(BoardVO vo);
}
