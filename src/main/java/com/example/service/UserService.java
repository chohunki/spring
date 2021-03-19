package com.example.service;

import javax.servlet.http.HttpSession;

import com.example.dto.UserVO;


public interface UserService {
	//회원가입처리
	public void register(UserVO vo) throws Exception;
	public boolean login(UserVO vo, HttpSession session) throws Exception;
}
