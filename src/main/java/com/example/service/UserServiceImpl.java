package com.example.service;

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
		if(result)
		{
			session.setAttribute("id", vo.getId());
		}
		
		return result;
		
	}


}
