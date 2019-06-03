package com.cafe24.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.mysite.repository.BoardDao;
import com.cafe24.mysite.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;
	
	public Boolean register(BoardVo vo) {
		boardDao.updateOrderNo(vo);
		return boardDao.insert(vo);
	}
	public List<BoardVo> getList() {
		return boardDao.getList();
	}
	public BoardVo read(Integer no) {
		return boardDao.read(no);
	}
	public Boolean delete(Integer no) {
		return boardDao.delete(no);
	}
	public Boolean modify(BoardVo vo) {
		return boardDao.update(vo);
	}
}
