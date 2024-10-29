package com.example.demo.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ListDto;
import com.example.demo.exception.StoreException;
import com.example.demo.mapper.BoardMapper;
import com.example.demo.util.Pagination;
import com.example.demo.vo.Board;

@Service
@Transactional
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;

	public void addNewBoard(Board board) {
		boardMapper.insertBoard(board);
	}

	public ListDto<Board> getBoards(Map<String, Object> condition) {
		// 조회조건에 맞는 총 데이터갯수를 조회한다.
		int totalRows = boardMapper.getTotalRows(condition);
		
		// 현재 페이지번호, 총 갯수로 Pagination 객체를 생성한다.
		int page = (Integer) condition.get("page");
		Pagination pagination = new Pagination(page, totalRows);
		
		// 페이지 번호에 맞는 데이터 조회범위를 조건에 추가한다.
		condition.put("begin", pagination.getBegin());
		condition.put("end", pagination.getEnd());
		
		// 검색 조건에 맞는 게시글 데이터 조회
		// condition -> page, opt, keyword, begin, end
		List<Board> boards = boardMapper.getBoards(condition);
		
		// 조회된 게시글목록, Pagination을 ListDto 객체에 저장
		ListDto<Board> dto = new ListDto<>(boards, pagination);
		
		return dto;
	}
	
	public Board getBoardDetail(int boardNo) {
		Board board = boardMapper.getBoardByNo(boardNo);
		if (board == null) {
			throw new StoreException("["+boardNo+"] 빈 게시글이 없습니다.");
		}
		return board;
	}
}