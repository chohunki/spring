package com.example.service;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.dao.UserDAO;
import com.example.dto.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDAO userDAO;
	


	@Override
	public void register(UserVO vo) throws Exception {
		// TODO Auto-generated method stub
		userDAO.register(vo);
	}

	@Override
	public boolean login(UserVO vo, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		boolean result = userDAO.login(vo);
		if(result) //입력받은 아이디와 비밀번호가 일치하는 레코드가 있다면 세션을 생성한다.
		{
			session.setAttribute("id", vo.getId());  
		}
		
		return result;
		
	}

	@Override
	public UserVO userInfo(UserVO vo) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.userInfo(vo);
	}

	@Override
	public UserVO userInfo_session(String id) throws Exception {
		 //TODO Auto-generated method stub
		return userDAO.userInfo_session(id);
	}

	@Override
	public void user_modify(UserVO vo) throws Exception {
		// TODO Auto-generated method stub
		userDAO.user_modify(vo);
	}


	@Override
	public boolean user_delete(Map<String, String> info) throws Exception{
		// TODO Auto-generated method stub
		boolean result = userDAO.user_delete(info);
		if(result) //입력받은 아이디와 비밀번호가 일치하는 레코드가 있다면 세션을 생성한다.
		{
			return true;
		}
		
		return false;
		
		
	
	}




}
