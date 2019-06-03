package com.cafe24.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.mysite.vo.BoardVo;

@Repository
public class BoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	public Boolean insert(BoardVo vo) {
		int count = sqlSession.insert("board.insert", vo);
		return 1 == count;
	}

	public List<BoardVo> getList() {
		return sqlSession.selectList("board.getList");
	}

	public BoardVo read(Integer no) {
		return sqlSession.selectOne("board.read", no);
	}

	public Boolean delete(Integer no) {
		int count = sqlSession.delete("board.delete", no);
		return 1 == count;
	}

	public Boolean update(BoardVo vo) {
		int count = sqlSession.update("board.update", vo);
		return 1 == count;
	}

	public void updateOrderNo(BoardVo vo) {
		sqlSession.update("board.updateOrderNo", vo);
	}
}
