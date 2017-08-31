package com.fortuneforall.drink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.fortuneforall.drink.domain.Drink;
import com.fortuneforall.util.ConnectionPool;
import com.fortuneforall.util.JdbcUtil;

public class DrinkDAO {
	
	public List<Drink> selectBoard() {
		List<Drink> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select board_no, title, writer, reg_date from tb97_board where table_type = 1 order by board_no desc");
			
			stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Drink drink = new Drink();
				drink.setBoard_no(rs.getInt("board_no"));
				drink.setTitle(rs.getString("title"));
				drink.setWriter(rs.getString("writer"));
				drink.setRegDate(rs.getDate("reg_date"));
				list.add(drink);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return list;
	}
	public Drink selectByNo(int no) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select board_no, title, writer,content,reg_table from tb97_board where table_type = 1");
			
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, no);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Drink drink = new Drink();
				drink.setBoard_no(rs.getInt("board_no"));
				drink.setTitle(rs.getString("title"));
				drink.setWriter(rs.getString("writer"));
				drink.setContent(rs.getString("content"));
				drink.setRegDate(rs.getTimestamp("reg_date"));
				return drink;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}
	public void insertDrink(Drink drink) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into tb97_board(board_no,member,title,writer,content,table_type) values(s_board_no.nextval,?,?,?,?,1)");
			
			stmt = con.prepareStatement(sql.toString());
			
			stmt.setInt(1, 3);
			stmt.setString(2, drink.getTitle());
			stmt.setString(3, "ㅋㄷ");
			stmt.setString(4, drink.getContent());

			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	public void updateDrink(Drink drink) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update tb97_board set title = ?, content = ?, file = ? where board_no = ?");
			
			stmt = con.prepareStatement(sql.toString());
			
			stmt.setString(1, drink.getTitle());
			stmt.setString(2, drink.getContent());
			stmt.setString(3, drink.getFiles());
			stmt.setInt(4, drink.getBoard_no());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	public boolean deleteDrink(int no) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("delete from tb97_board where board_no = ?");
			
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, no);
			int cnt = stmt.executeUpdate();
			
			if(cnt == 0) {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return true;
	}
}
