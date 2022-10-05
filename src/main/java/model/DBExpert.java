package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBExpert {
	final private String driver = "oracle.jdbc.OracleDriver";
	final private String url = "jdbc:oracle:thin:@localhost:1521/xe";
	
	
	public ArrayList<DmList> areaList(){
		String select = "select area, count(area)"
				+" from bookinfo_tbl group by area";
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<DmList> list = new ArrayList<DmList>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "hr", "hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DmList dl = new DmList();
				dl.setArea(rs.getString(1));
				dl.setAreaCount(rs.getInt(2));
				list.add(dl);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { 
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	public boolean deleteDmListSecond(String custid) {
		String delete = "delete from bookinfo_tbl where custid = ?";
		Connection con = null; PreparedStatement pstmt = null;
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(delete);
			pstmt.setString(1, custid);
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	public boolean deleteDmListFirst(int dmno) {
		String delete = "delete from dminfo_tbl where dmno = ?";
		Connection con = null; PreparedStatement pstmt = null;
		boolean result = false;
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, dmno);
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	public boolean updateDmlIstSecond(DmList dl) {
		String update = "update bookinfo_tbl set author = ? where custid = ?";
		Connection con = null; PreparedStatement pstmt = null;
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "hr", "hr");
			pstmt = con.prepareStatement(update);
			//pstmt.setString(1, dl.getCustid());
			pstmt.setString(1, dl.getAuthor());
			pstmt.setString(2, dl.getCustid());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	public boolean updateDmListFirst(DmList dl) {
		String update = "update dminfo_tbl set custid=?, maildate = to_date(?, 'YYYY/MM/DD'), contents = ?, campain = ?"
				+ " where dmno = ?";
		Connection con = null; PreparedStatement pstmt = null;
		//DmList dl = new DmList();
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "hr","hr");
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, dl.getCustid());
			pstmt.setString(2, dl.getDate());
			pstmt.setString(3, dl.getContents());
			pstmt.setString(4, dl.getCampain());
			pstmt.setInt(5, dl.getDmno());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	public DmList dmHistoryView(int dmno) {
		String select = "select d.dmno, d.custid, b.author, to_char(d.maildate, 'YYYY-MM-DD'), d.contents, d.campain"
				+ " from dminfo_tbl d, bookinfo_tbl b"
				+ " where d.custid = b.custid and dmno = ?";
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		DmList dl = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setInt(1, dmno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dl = new DmList();
				dl.setDmno(rs.getInt(1));
				dl.setCustid(rs.getString(2));
				dl.setAuthor(rs.getString(3));
				dl.setDate(rs.getString(4));
				dl.setContents(rs.getString(5));
				dl.setCampain(rs.getString(6));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close();con.close();
			}catch(Exception e) {}
		}
		return dl;
	}
	
	public boolean dmListRegister(DmList dl) {
		String insert = "insert into dminfo_tbl values("
				+"?,?,to_date(?, 'YYYY/MM/DD'),?,?,?,?)";
		Connection con = null; PreparedStatement pstmt = null;
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, dl.getDmno());
			pstmt.setString(2, dl.getCustid());
			pstmt.setString(3, dl.getDate());
			pstmt.setString(4, dl.getContents());
			pstmt.setString(5, dl.getDept());
			pstmt.setString(6, dl.getGrade());
			pstmt.setString(7, dl.getCampain());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	public int maxDmno() {
		String select = "select max(dmno) from dminfo_tbl";
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		int max = -1;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			if(rs.next()) max = rs.getInt(1);
			max += 1;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return max;
	}
	
	public ArrayList<String> dmCampainSelect(){
		String select= "select distinct(campain) from dminfo_tbl"
				+ " order by campain asc";
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String grade = rs.getString(1);
				list.add(grade);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	
	public ArrayList<String> dmGradeSelect() {
		String select = "select distinct(grade) from dminfo_tbl"
				+ " order by grade asc";
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String grade = rs.getString(1);
				list.add(grade);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	
	public ArrayList<String> dmDeptSelect() {
		String select ="select distinct(dept) from dminfo_tbl order by dept asc";
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String dept = rs.getString(1);
				list.add(dept);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	
	public boolean custInfoRegister(CustInfo ci) {
		String insert = "insert into bookinfo_tbl values("
				+"?,?,?,?,?,?)";
		Connection con = null; PreparedStatement pstmt = null;
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, ci.getCustid());
			pstmt.setString(2, ci.getAuthor());
			pstmt.setString(3, ci.getGoods());
			pstmt.setString(4, ci.getPhone());
			pstmt.setString(5, ci.getEmail());
			pstmt.setString(6, ci.getArea());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	public ArrayList<DmList> getDmList(){
		String select = "select d.dmno, d.custid, b.author, to_char(d.maildate, 'YYYY-MM-DD'), d.contents, d.campain"
				+ " from dminfo_tbl d, bookinfo_tbl b"
				+ " where d.custid = b.custid order by d.dmno asc";
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<DmList> list = new ArrayList<DmList>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DmList dl = new DmList();
				dl.setDmno(rs.getInt(1));
				dl.setCustid(rs.getString(2));
				dl.setAuthor(rs.getString(3));
				dl.setDate(rs.getString(4));
				dl.setContents(rs.getString(5));
				dl.setCampain(rs.getString(6));
				list.add(dl);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();pstmt.close();con.close();
			}catch(Exception e) {}
		}
		return list;
	}
}
