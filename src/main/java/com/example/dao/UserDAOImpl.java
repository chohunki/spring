package com.example.dao;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.dto.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SqlSession sqlSession1;
	private static final String Namespace1 = "com.example.mapper.UserMapper";
	
	@Override
	public void register(UserVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession1.insert(Namespace1 + ".register", vo);
	}

	@Override
	public boolean login(UserVO vo) throws Exception {
		// TODO Auto-generated method stub
		return (sqlSession1.selectOne(Namespace1 + ".login", vo) == null) ? false : true;
	}

}
