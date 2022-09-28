package dm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBExpert;

@WebServlet("/dmDeptSelect.do")
public class DmDeptSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DmDeptSelectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBExpert dbe = new DBExpert();
		ArrayList<String> list = dbe.dmDeptSelect();
		ArrayList<String> grade = dbe.dmGradeSelect();
		ArrayList<String> campain = dbe.dmCampainSelect();
		int max = dbe.maxDmno();
		request.setAttribute("LIST", list);
		request.setAttribute("GRADE", grade);
		request.setAttribute("CAMPAIN", campain);
		//request.setAttribute("MAX", max);
		RequestDispatcher rd = request.getRequestDispatcher("sendDmListForm.jsp?MAX="+max);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
