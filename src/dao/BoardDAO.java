package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import dto.BoardDTO;

public class BoardDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void dbConnection() {
		con = DBConnection.getConnection();
	}
	
	public void dbClose() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void pstmtClose() {
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void rsClose() {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int boardWrite(BoardDTO board) {
		String sql = "INSERT INTO BOARD1(BNUMBER,BWRITER,BTITLE,BCONTENTS,BDATE,BHITS,BPASSWORD)"
				+ " VALUES(BOARD1_SEQ.NEXTVAL,?,?,?,SYSDATE,0,?)";
		int writeResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getBwriter());
			pstmt.setString(2, board.getBtitle());
			pstmt.setString(3, board.getBcontents());
			pstmt.setString(4, board.getBpass());
			writeResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return writeResult;
	}

	public List<BoardDTO> boardList() {
		String sql = "SELECT * FROM BOARD1 ORDER BY BNUMBER DESC";
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		BoardDTO board = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board = new BoardDTO();
				board.setBnumber(rs.getInt("BNUMBER"));
				board.setBwriter(rs.getString("BWRITER"));
				board.setBtitle(rs.getString("BTITLE"));
				board.setBcontents(rs.getString("BCONTENTS"));
				board.setBdate(rs.getString("BDATE"));
				board.setBhits(rs.getInt("BHITS"));
				board.setBpass(rs.getString("BPASSWORD"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return boardList;
	}

	public void boardHits(int bnumber) {
		String sql = "UPDATE BOARD1 SET BHITS=BHITS+1 WHERE BNUMBER=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bnumber);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
	}

	public BoardDTO boardView(int bnumber) {
		String sql = "SELECT * FROM BOARD1 WHERE BNUMBER=?";
		BoardDTO boardView = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bnumber);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardView = new BoardDTO();
				boardView.setBnumber(rs.getInt("BNUMBER"));
				boardView.setBwriter(rs.getString("BWRITER"));
				boardView.setBtitle(rs.getString("BTITLE"));
				boardView.setBcontents(rs.getString("BCONTENTS"));
				boardView.setBdate(rs.getString("BDATE"));
				boardView.setBhits(rs.getInt("BHITS"));
				boardView.setBfilename(rs.getString("BFILENAME"));
				boardView.setBpass(rs.getString("BPASSWORD"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return boardView;
	}

	public int boardUpdate(BoardDTO board) {
		String sql = "UPDATE BOARD1 SET BWRITER=?,BTITLE=?,BCONTENTS=? WHERE BNUMBER=?";
		int updateResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getBwriter());
			pstmt.setString(2, board.getBtitle());
			pstmt.setString(3, board.getBcontents());
			pstmt.setInt(4, board.getBnumber());
			updateResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return updateResult;
	}

	public List<BoardDTO> boardSearch(String keyword,String keyfield) {
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		if(keyfield.equals("title")) {
		String sql = "SELECT * FROM BOARD1 WHERE BTITLE LIKE ?";
		BoardDTO board = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, '%'+keyword+'%');
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board = new BoardDTO();
				board.setBnumber(rs.getInt("BNUMBER"));
				board.setBwriter(rs.getString("BWRITER"));
				board.setBtitle(rs.getString("BTITLE"));
				board.setBcontents(rs.getString("BCONTENTS"));
				board.setBdate(rs.getString("BDATE"));
				board.setBhits(rs.getInt("BHITS"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return boardList;
	} else if(keyfield.equals("id")) {
		String sql = "SELECT * FROM BOARD1 WHERE BWRITER LIKE ?";
		BoardDTO board = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, '%'+keyword+'%');
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board = new BoardDTO();
				board.setBnumber(rs.getInt("BNUMBER"));
				board.setBwriter(rs.getString("BWRITER"));
				board.setBtitle(rs.getString("BTITLE"));
				board.setBcontents(rs.getString("BCONTENTS"));
				board.setBdate(rs.getString("BDATE"));
				board.setBhits(rs.getInt("BHITS"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return boardList;
	}else if(keyfield.equals("hits")) {
		String sql = "SELECT * FROM BOARD1 ORDER BY BHITS DESC";
		BoardDTO board = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board = new BoardDTO();
				board.setBnumber(rs.getInt("BNUMBER"));
				board.setBwriter(rs.getString("BWRITER"));
				board.setBtitle(rs.getString("BTITLE"));
				board.setBcontents(rs.getString("BCONTENTS"));
				board.setBdate(rs.getString("BDATE"));
				board.setBhits(rs.getInt("BHITS"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return boardList;
	}
		return boardList;
				
	}

	public int boardDelete(int bnumber) {
		String sql = "DELETE FROM BOARD1 WHERE BNUMBER=?";
		int deleteResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bnumber);
			deleteResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return deleteResult;
	}

	public int boardWriteFile(BoardDTO board) {
		String sql = "INSERT INTO BOARD1(BNUMBER,BWRITER,BTITLE,BCONTENTS,BDATE,BHITS,BFILENAME,BPASSWORD)"
				+ " VALUES(BOARD1_SEQ.NEXTVAL,?,?,?,SYSDATE,0,?,?)";
		int writeResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getBwriter());
			pstmt.setString(2, board.getBtitle());
			pstmt.setString(3, board.getBcontents());
			pstmt.setString(4, board.getBfilename());
			pstmt.setString(5, board.getBpass());
			writeResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return writeResult;
	}

	public int listCount() {
		String sql = "SELECT COUNT(BNUMBER) FROM BOARDLIST";
		int listCount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return listCount;
	}

	public List<BoardDTO> boardListPaging(int startRow, int endRow) {
		String sql = "SELECT * FROM BOARDLIST WHERE RN BETWEEN ? AND ?";
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		BoardDTO board = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board = new BoardDTO();
				board.setBnumber(rs.getInt("BNUMBER"));
				board.setBwriter(rs.getString("BWRITER"));
				board.setBtitle(rs.getString("BTITLE"));
				board.setBcontents(rs.getString("BCONTENTS"));
				board.setBdate(rs.getString("BDATE"));
				board.setBhits(rs.getInt("BHITS"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return boardList;
	}

	public int boardPass(int bnumber,String bpass) {
		String sql = "SELECT BPASSWORD FROM BOARD1 WHERE BNUMBER=? AND BPASSWORD = ?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bnumber);
			pstmt.setString(2, bpass);	
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return result;
	}

	public int boardcount(String mid) {
		String sql = "SELECT COUNT(BNUMBER) FROM BOARDLIST WHERE BWRITER=?";
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		
		
		return count;
	}


}










