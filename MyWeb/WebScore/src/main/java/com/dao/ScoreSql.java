package com.dao;

public interface ScoreSql {
	String selectAll = "select * from Score";
	String insertScore = "insert into score values(?,?,?,?,?,?,?)";
	String findScore = "select * from score where name = ?";
	String updateScore = "update Score  set  kor=?, eng=?, mat=? where name=?";
	String deleteScore = "delete from Score where name = ?";
}
