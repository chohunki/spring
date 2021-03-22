package com.example.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.dto.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SqlSession sqlSession1;
	private static final String Namespace1 = "com.example.mapper.UserMapper"; //매퍼의 네임스페이스와 이름이 같아야 한다.
	
	@Override
	public void register(UserVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession1.insert(Namespace1 + ".register", vo);   //Namespace 뒤에 오는 이름은 매퍼의 select id와 같아야한다.
	}

	@Override
	public boolean login(UserVO vo) throws Exception {
		// TODO Auto-generated method stub
		//3항 연산자로 입력받은 아이디와 비밀번호가 일치하는 레코드가 있다면 true, 없다면 false를 반환한다.
		return (sqlSession1.selectOne(Namespace1 + ".login", vo) == null) ? false : true;  
		
	}

	@Override
	public UserVO userInfo(UserVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession1.selectOne(Namespace1 + ".userInfo", vo);
	}

	@Override
	public UserVO userInfo_session(String id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession1.selectOne(Namespace1 + ".userInfo_session", id);
	}

	@Override
	public void user_modify(UserVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession1.update(Namespace1 + ".user_modify", vo);
	}

	@Override
	public boolean user_delete(Map<String, String> info) throws Exception {
		// TODO Auto-generated method stub
		return (sqlSession1.selectOne(Namespace1 + ".user_delete", info) == null) ? false : true;  
	}




	



}
