package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberJoinService {

	public int memberJoin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String savePath = "D:\\JAVA\\Ser\\MembershipProject\\WebContent\\ImgFile";
		MultipartRequest multi = new MultipartRequest(
				request, 
				savePath,
				10*1024*1024,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		
		
		
		String mid = request.getParameter("mid"); //아이디
		String mpassword = request.getParameter("mpassword"); //비번
		String mname = request.getParameter("mname"); //이름 
		String mbirth = request.getParameter("mbirth"); //생일
		String mphone = request.getParameter("mphone"); //전번
		String memail = request.getParameter("memail"); //메일
		String postcode = request.getParameter("postcode"); //우편번호
		String address = request.getParameter("address"); //주소
		String detailAddress = request.getParameter("detailAddress"); //상세주소
		String extraAddress = request.getParameter("extraAddress"); //참고항목
		String mgender = request.getParameter("mgender"); //성별
		String imgfile = 
				multi.getOriginalFileName((String)multi.getFileNames().nextElement());
		
		
		
		MemberDTO member = new MemberDTO();
		member.setMid(mid);
		member.setMpassword(mpassword);
		member.setMname(mname);
		member.setMbirth(mbirth);
		member.setMphone(mphone);
		member.setMemail(memail);
		member.setPostcode(postcode);
		member.setAddress(address);
		member.setDetailAddress(detailAddress);
		member.setExtraAddress(extraAddress);
		member.setMgender(mgender);
		member.setImgfile(imgfile);
		
		MemberDAO mDAO = new MemberDAO();
		
		mDAO.dbConnection();
		
		int joinResult = mDAO.memberJoin(member);
		
		mDAO.dbClose();
		return joinResult;
	}

}




