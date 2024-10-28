package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.BoardRegisterForm;
import com.example.demo.mapper.BoardMapper;
import com.example.demo.vo.Board;

@Service
@Transactional
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;

	public void addNewBoard(Board board) {
		boardMapper.insertBoard(board);
	}
}
