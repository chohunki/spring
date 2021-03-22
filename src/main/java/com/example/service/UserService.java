package com.example.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.dto.UserVO;


public interface UserService {
	//회원가입처리
	public void register(UserVO vo) throws Exception;
	//로그인 처리
	public boolean login(UserVO vo, HttpSession session) throws Exception;
	//회원정보 조회
	public UserVO userInfo(UserVO vo) throws Exception;
	//회원정보 조회(세션으로)
	public UserVO userInfo_session(String id) throws Exception;
	public void user_modify(UserVO vo) throws Exception;
	public boolean user_delete(Map<String, String> info) throws Exception;
}
