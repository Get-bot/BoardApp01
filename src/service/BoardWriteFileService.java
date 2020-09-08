package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardWriteFileService {

	public int boardWriteFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// �뙆�씪�씠 ���옣�맆 �쐞移섎�� savePath 蹂��닔�뿉 ���옣 
		String savePath = "D:\\JAVA\\Ser\\MembershipProject\\WebContent\\UploadFile";
		
		MultipartRequest multi = new MultipartRequest(
				request, 
				savePath,
				10*1024*1024,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		BoardDTO board = new BoardDTO();
		String bwriter = multi.getParameter("bwriter");
		String btitle = multi.getParameter("btitle");
		String bcontents = multi.getParameter("bcontents");
		String bpass = request.getParameter("bpass");
		String bfilename = 
				multi.getOriginalFileName((String)multi.getFileNames().nextElement());
		board.setBwriter(bwriter);
		board.setBtitle(btitle);
		board.setBcontents(bcontents);
		board.setBfilename(bfilename);
		board.setBpass(bpass);
		
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		int writeResult = bDAO.boardWriteFile(board);
		bDAO.dbClose();
		return writeResult;
		// DAO boardWriteFile 硫붿냼�뱶 �옉�꽦�븯怨� 
		// BoardWriteFile.jsp �떎�뻾�빐�꽌 洹몃┝�뙆�씪 �븯�굹 泥⑤��빐�꽌 湲��벐湲� �빐蹂닿퀬
		// DB�쓽 BFILENAME 而щ읆�뿉 �뾽濡쒕뱶�븳 �뙆�씪 �씠由꾩씠 ���옣�릱�뒗吏�, 
		// UploadFile �뤃�뜑�뿉 �뾽濡쒕뱶 �뙆�씪�씠 �뱾�뼱媛붾뒗吏� �솗�씤 
	}

}






