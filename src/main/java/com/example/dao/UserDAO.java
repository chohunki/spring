package com.example.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;

import com.example.dto.UserVO;

public interface UserDAO {
	//회원가입 처리
	public void register(UserVO vo) throws Exception;
	//로그인 처리
	public boolean login(UserVO vo) throws Exception;
	//회원 정보 조회
	public UserVO userInfo(UserVO vo) throws Exception;
	//회원정보 조회(세션으로)
	public UserVO userInfo_session(String id) throws Exception;
	public void user_modify(UserVO vo) throws Exception;
	public boolean user_delete(Map<String, String> info) throws Exception;
}
