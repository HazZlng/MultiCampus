package com.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.domain.BoardVO;
import com.service.BoardService;

@Controller
@SessionAttributes("board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		 List<BoardVO> boardList = boardService.getBoardList();
		 
		// Model 정보 저장
		model.addAttribute("boardList",boardList);
		return "boardList"; // View 이름 리턴
	}

	// 글 상세 조회
	@RequestMapping("/getContent.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getContent(vo)); // Model 정보 저장
		return "content"; // View 이름 리턴
	}
	
	// 글 쓰기
	@RequestMapping(value="/insertBoard.do") 
	public String insertBoard(BoardVO vo) throws IOException { 
			boardService.insertBoard(vo); 
			return "redirect:getBoardList.do"; 
	}
	
	// 글 쓰기 페이지 이동
	@RequestMapping("/moveInsertBoard.do") 
	public String moveInsertBoard()throws Exception{
		return "insertBoard";
	}
	 

	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		boardService.updateBoard(vo);
		return "redirect:getBoardList.do";
	}

	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
}
