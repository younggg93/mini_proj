package com.fortuneforall.fortunereview.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.fortuneforall.util.ConnectionPool;
import com.fortuneforall.util.JdbcUtil;


import com.fortuneforall.fortunereview.domain.FortuneReview;

public class FortuneReviewDAO {
	
	public List<FortuneReview> selectBoard(){
		List<FortuneReview> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select m.member_id, b.reg_Date, c.content from tb_member m inner join tb_board2 b on m.member_no = b.member_no inner join tb_fortunereviewcomment c on b.board_no = c.board_no;");

			pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				FortuneReview fr = new FortuneReview();
				fr.setNo(rs.getInt("m.member_id"));
				fr.setDate(rs.getDate("b.reg_date"));
				fr.setContent(rs.getString("c.content"));
				list.add(fr);
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
	
	public FortuneReview selectBoardByNo(int no) {
		List<FortuneReview> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select board_no, title, writer, content, reg_date, file from tb_fortuneReview where = '" +no);
			
			pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				FortuneReview fr = new FortuneReview();
				fr.setNo(rs.getInt("board_no"));
				fr.setTitle(rs.getString("title"));
				fr.setWriter(rs.getString("writer"));
				fr.setContent(rs.getString("content"));
				fr.setFile(rs.getString("file"));
				fr.setDate(rs.getDate("reg_date"));
				list.add(fr);
				
				return fr;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		
		
		return null;
	}
	
	public void insertBoard(FortuneReview fortuneReivew) {
		List<FortuneReview> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into tb_fortunereview(board_no, title, writer, content, table_type) valuse(s_fortuneReview_no_nextval, ?, ?, ?, '4')");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, fortuneReivew.getTitle());
			pstmt.setString(2, fortuneReivew.getWriter());
			pstmt.setString(3, fortuneReivew.getContent());
			
			int cnt = pstmt.executeUpdate();
			
			System.out.println("글 등록 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateBoard(FortuneReview fortuneReview) {
		List<FortuneReview> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update tb_board set title = ?, content = ? where board_no = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, fortuneReview.getTitle());
			pstmt.setString(2, fortuneReview.getContent());
			pstmt.setInt(3, fortuneReview.getNo());
			list.add(fortuneReview);
			
		int cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	public boolean deleteBoard(int no) {
		List<FortuneReview> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("delete from tb_fortunereview where board_no = ?");
			
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
	
