package dto;

public class MemberDTO {
	// DB의 컬럼명과 동일하게 쓸 것
	private String mid;
	private String mpassword;
	private String mname;
	private String mphone;
	private String memail;
	private String mgender;
	private String mbirth;
	private String postcode;
	private String address;
	private String detailAddress;
	private String extraAddress;
	private String imgfile;
	
	public MemberDTO() {
		
	}

	@Override
	public String toString() {
		return "MemberDTO [mid=" + mid + ", mpassword=" + mpassword + ", mname=" + mname + ", mphone=" + mphone
				+ ", memail=" + memail + ", mgender=" + mgender + ", mbirth=" + mbirth + ", postcode=" + postcode
				+ ", address=" + address + ", detailAddress=" + detailAddress + ", extraAddress=" + extraAddress
				+ ", imgfile=" + imgfile + "]";
	}

	public String getMid() {
		return mid;
	}

	public String getMpassword() {
		return mpassword;
	}

	public String getMname() {
		return mname;
	}

	public String getMphone() {
		return mphone;
	}

	public String getMemail() {
		return memail;
	}

	public String getMgender() {
		return mgender;
	}

	public String getMbirth() {
		return mbirth;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getAddress() {
		return address;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public String getExtraAddress() {
		return extraAddress;
	}

	public String getImgfile() {
		return imgfile;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public void setMgender(String mgender) {
		this.mgender = mgender;
	}

	public void setMbirth(String mbirth) {
		this.mbirth = mbirth;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public void setExtraAddress(String extraAddress) {
		this.extraAddress = extraAddress;
	}

	public void setImgfile(String imgfile) {
		this.imgfile = imgfile;
	}

	
}