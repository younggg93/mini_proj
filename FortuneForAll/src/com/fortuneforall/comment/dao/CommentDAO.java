package com.fortuneforall.comment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fortuneforall.comment.domain.Comment;
import com.fortuneforall.drink.domain.Drink;
import com.fortuneforall.fortunereview.domain.FortuneReview;
import com.fortuneforall.util.ConnectionPool;
import com.fortuneforall.util.JdbcUtil;

public class CommentDAO {
	
	public List<Drink> selectBoard(){
		List<Drink> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select board_no, member, writer, reg_date, from tb97_board where board_no = ?");

			pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Drink drink = new Drink();
				drink.setBoard_no(rs.getInt("board_no"));
				drink.setTitle(rs.getString("title"));
				drink.setWriter(rs.getString("writer"));
				drink.setRegDate(rs.getDate("reg_date"));
				list.add(drink);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		
		return list;
		
	}
	
	public void insertComment(Comment comment) {
		List<Comment> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into tb97_comment(board_no, member_no, comment_no, content) values(s_comment_no.nextval, ?, ?, ?)");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, comment.getMember_no());
			pstmt.setInt(2, comment.getComment_no());
			pstmt.setString(3, comment.getContent());
			
			int cnt = pstmt.executeUpdate();
			
			System.out.println("댓글 등록 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		
	}
	
	public void updateComment(Comment fortuneReviewComment) {
		List<Comment> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update tb97_comment set content = ?)");
			
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, fortuneReviewComment.getContent());
			list.add(fortuneReviewComment);
			
			int cnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	
	public boolean deleteBoard(int no) {
		List<Comment> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("delete from tb97_comment where comment_no = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			int cnt = pstmt.executeUpdate();
			if(cnt == 0) {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		
		return true;
	}
}
