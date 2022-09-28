package dm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBExpert;
import model.DmList;

@WebServlet("/dmListRegister.do")
public class DmListRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DmListRegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String dmno = request.getParameter("DMNO");
		String custid = request.getParameter("CUSTID");
		String maildate = request.getParameter("MAILDATE");
		String contents = request.getParameter("CONTENTS");
		String dept = request.getParameter("DEPT");
		String grade = request.getParameter("GRADE");
		String campain = request.getParameter("CAMPAIN");
		DmList dl = new DmList();
		dl.setDmno(Integer.parseInt(dmno));
		dl.setCustid(custid);
		dl.setDate(maildate);
		dl.setContents(contents);
		dl.setDept(dept);
		dl.setGrade(grade);
		dl.setCampain(campain);
		DBExpert dbe = new DBExpert();
		boolean result = dbe.dmListRegister(dl);
		if(result) {
			response.sendRedirect("dmListRegisterResult.jsp?R=Y");
		}else {
			response.sendRedirect("dmListRegisterResult.jsp?R=N");
		}
	}
}
