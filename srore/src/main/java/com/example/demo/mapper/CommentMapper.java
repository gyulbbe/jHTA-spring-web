package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.vo.Comment;

@Mapper
public interface CommentMapper {

	void insertComment(@Param("comment") Comment comment);
	List<Comment> getCommentsByBoardNo(@Param("boardNo") int boardNo);
}
