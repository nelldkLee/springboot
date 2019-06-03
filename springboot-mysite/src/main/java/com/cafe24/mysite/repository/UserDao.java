package com.cafe24.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StopWatch;

import com.cafe24.mysite.exception.UserDaoException;
import com.cafe24.mysite.vo.GuestbookVo;
import com.cafe24.mysite.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public Boolean insert(UserVo vo) {
		int count = sqlSession.insert("user.insert", vo);
		return 1 == count;
	}
	
	public Boolean delete(GuestbookVo vo) {
		int count = sqlSession.delete("user.delete", vo);
		return 1 == count;
	}

	public UserVo get(String email, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("password", password);
		UserVo userVo = sqlSession.selectOne("user.getByEmailAndPassword",map);
		return userVo;
	}

	public UserVo getByEmail(String email) {
		return sqlSession.selectOne("user.getByEmail", email);
	}
	/*
	 * 	StopWatch sw = new StopWatch();
		sw.start();
		UserVo vo =  sqlSession.selectOne("user.getByEmail", email);
		sw.stop();
		System.out.println("얼마나 걸리냐"+sw.getTotalTimeMillis());
		return vo;
	 */
}
