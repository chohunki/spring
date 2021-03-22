package com.example.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.dao.BoardDAO;
import com.example.dto.BoardVO;
import com.example.dto.PagingVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	@Override
	public List<BoardVO> selectMember() throws Exception {
		return dao.selectMember();
	}

	@Override
	public BoardVO view(int idx) throws Exception {
		return dao.view(idx);
	}

	@Override
	public void delete(int idx) throws Exception {
		dao.delete(idx);
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		dao.modify(vo);
		
	}

	@Override
	public void write(BoardVO vo) throws Exception {
		dao.write(vo);
	}

	@Override
	public void count(int idx) throws Exception {
		dao.count(idx);
	}

	@Override
	public int countBoard() throws Exception {
		return dao.countBoard();
	}

	@Override
	public List<BoardVO> selectBoard(PagingVO vo) throws Exception {
		return dao.selectBoard(vo);
	}



}
