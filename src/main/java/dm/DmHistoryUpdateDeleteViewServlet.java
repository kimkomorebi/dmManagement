package dm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBExpert;
import model.DmList;

@WebServlet("/DmHistoryUpdateDeleteView")
public class DmHistoryUpdateDeleteViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DmHistoryUpdateDeleteViewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String dmno = request.getParameter("DMNO");
		String btn = request.getParameter("BTN");
		DBExpert dbe = new DBExpert();
		DmList dl = dbe.dmHistoryView(Integer.parseInt(dmno));
		request.setAttribute("DL", dl);
	
		if(btn.equals("수정")) {
			RequestDispatcher rd = request.getRequestDispatcher("dmHistoryView.jsp");
			rd.forward(request, response);
		}else if(btn.equals("삭제")) {
			RequestDispatcher rd = request.getRequestDispatcher("dmHistoryDeleteView.jsp");
			rd.forward(request, response);
		}
	}

}
