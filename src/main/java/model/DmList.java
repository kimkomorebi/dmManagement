package model;

public class DmList {
	private Integer dmno; //발송번호
	private String custid;//고객id
	private String author;// 고객 성명
	private String date;//발송일
	private String contents;//내용
	private String dept;//부서
	private String grade;//고객 등급
	private String campain;//캠페인 구분
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Integer getDmno() {
		return dmno;
	}
	public void setDmno(Integer dmno) {
		this.dmno = dmno;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getCampain() {
		return campain;
	}
	public void setCampain(String campain) {
		this.campain = campain;
	}
}
