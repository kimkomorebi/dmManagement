package dm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBExpert;
import model.DmList;

@WebServlet("/updateDmList.do")
public class UpdateDmListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateDmListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String dmno = request.getParameter("DMNO");
		String custid = request.getParameter("CUSTID");
		String author = request.getParameter("AUTHOR");
		String date = request.getParameter("DATE");
		String contents = request.getParameter("CONTENTS");
		String campain = request.getParameter("CAMPAIN");
		DmList dl = new DmList();
		dl.setDmno(Integer.parseInt(dmno));
		dl.setCustid(custid);
		dl.setAuthor(author);
		dl.setDate(date);
		dl.setContents(contents);
		dl.setCampain(campain);
		DBExpert dbe = new DBExpert();
		boolean result1= dbe.updateDmListFirst(dl);
		boolean result2 = dbe.updateDmlIstSecond(dl);
		
		if(result1 && result2) {
			response.sendRedirect("DmListUpdateResult.jsp?R=Y");
		}else {
			response.sendRedirect("DmListUpdateResult.jsp?R=N");
		}
	}

}
