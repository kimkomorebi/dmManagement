package model;

public class DmList {
	private Integer dmno; //�߼۹�ȣ
	private String custid;//��id
	private String author;// �� ����
	private String date;//�߼���
	private String contents;//����
	private String dept;//�μ�
	private String grade;//�� ���
	private String campain;//ķ���� ����
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
