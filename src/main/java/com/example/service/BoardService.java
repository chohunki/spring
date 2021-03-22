package com.example.service;

import java.util.List;

import com.example.dto.BoardVO;
import com.example.dto.PagingVO;

public interface BoardService {
	
	//전체게시글 불러오기(페이징 적용 x)
	public List<BoardVO> selectMember() throws Exception;
	//게시글 상세 조회
	public BoardVO view(int idx) throws Exception;
	//게시글 삭제
	public void delete(int idx) throws Exception;
	//게시글 수정
	public void modify(BoardVO vo) throws Exception;
	//게시글 작성
	public void write(BoardVO vo) throws Exception;
	//게시글 조회수
	public void count(int idx) throws Exception;
	// 게시물 총 갯수
	public int countBoard() throws Exception;
	// 페이징 처리 게시글 조회
	public List<BoardVO> selectBoard(PagingVO vo) throws Exception;
}
