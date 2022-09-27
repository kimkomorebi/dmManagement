package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBExpert {
	final private String driver = "oracle.jdbc.OracleDriver";
	final private String url = "jdbc:oracle:thin:@localhost:1521/xe";
	
	public ArrayList<DmList> getDmList(){
		String select = "select d.dmno, d.custid, b.author, d.maildate, d.contents, d.campain"
				+ " from dminfo_tbl d, bookinfo_tbl b"
				+ " where d.custid = b.custid";
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
