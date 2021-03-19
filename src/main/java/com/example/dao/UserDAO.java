package com.example.dao;

import javax.servlet.http.HttpSession;

import com.example.dto.UserVO;

public interface UserDAO {
	//회원가입 처리
	public void register(UserVO vo) throws Exception;
	public boolean login(UserVO vo) throws Exception;
}
