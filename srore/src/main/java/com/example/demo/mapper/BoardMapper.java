package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.vo.Board;

@Mapper
public interface BoardMapper {

	void insertBoard(@Param("board") Board board);
	int getTotalRows(@Param("condition") Map<String, Object> condition);
	List<Board> getBoards(@Param("condition") Map<String, Object> condition);
	Board getBoardByNo(@Param("no") int no);
}
