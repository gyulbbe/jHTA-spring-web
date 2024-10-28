package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.vo.Board;

@Mapper
public interface BoardMapper {

	void insertBoard(@Param("board") Board board);
}
