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
import model.DmList;

@WebServlet("/searchDmList.do")
public class searchDmListServet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public searchDmListServet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	DBExpert dbe = new DBExpert();
    	ArrayList<DmList> list = dbe.getDmList();
    	ArrayList<DmList> area = dbe.areaList();
    	request.setAttribute("LIST", list);
    	request.setAttribute("AREA", area);
    	RequestDispatcher rd = request.getRequestDispatcher("dmList.jsp");
    	rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
