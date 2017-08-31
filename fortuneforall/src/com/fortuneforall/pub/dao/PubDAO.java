package com.fortuneforall.pub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fortuneforall.pub.domain.Pub;
import com.fortuneforall.util.ConnectionPool;
import com.fortuneforall.util.JdbcUtil;

public class PubDAO {
	int no = 0;
	List<Pub> list = new ArrayList<>();
	
	//전체 글조회
	public List<Pub> selectPub() {
		List<Pub> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT BOARD_NO, TITLE, WRITER, REG_DATE ");
			sql.append(" FROM TB97_BOARD ");
			sql.append(" ORDER BY NO DESC ");
			
			pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Pub pub = new Pub();
				pub.setBno(rs.getInt("bno"));
				pub.setTitle(rs.getString("title"));
				pub.setTitle(rs.getString("writer"));
				pub.setReg_date(rs.getDate("reg_date"));
				list.add(pub);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return list;
	}
	
	//선택 글조회
	public Pub selectPub(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT BOARD_NO, TITLE, WRITER, REG_DATE ");
			sql.append(" FROM TB97_BOARD ");
			sql.append(" WHERE BOARD_NO = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				Pub pub = new Pub();
				pub.setBno(rs.getInt("bno"));
				pub.setTitle(rs.getString("title"));
				pub.setWriter(rs.getString("writer"));
				pub.setReg_date(rs.getDate("reg_date"));
				return pub;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}
	
	// 글 등록
	public void insertPub(Pub p) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			
			sql.append(" INSERT INTO TB97_BOARD ");
			sql.append(" (BOARD_NO, TITLE, WRITER, CONTENT, FILES) ");
			sql.append(" VALUES(S_BOARD_NO.NEXTVAL, ?, ?, ?, ?) ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, p.getTitle());
			pstmt.setString(2, p.getWriter());
			pstmt.setString(3, p.getContent());
			pstmt.setString(4, p.getFile());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	
	// 글 수정
	public void updatePub(Pub p) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			
			sql.append(" UPDATE TB97_BOARD ");
			sql.append(" SET TITLE = ? ,CONTENT = ? ");
			sql.append(" WHERE BOARD_NO = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, p.getTitle());
			pstmt.setString(2, p.getContent());
			pstmt.setInt(3, p.getBno());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	
	// 글 삭제
	public boolean deletePub(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" DELETE ");
			sql.append(" FROM TB97_BOARD ");
			sql.append(" WHERE BOARD_NO = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setInt(1, no);
			
			int cnt = pstmt.executeUpdate();
			if (cnt == 0) {
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
