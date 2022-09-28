package customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CustInfo;
import model.DBExpert;

@WebServlet("/custInfoRegister.do")
public class CustInfoRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustInfoRegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("ID");
		String name = request.getParameter("NAME");
		String goods = request.getParameter("GOODS");
		String phone = request.getParameter("PHONE");
		String email = request.getParameter("EMAIL");
		String area = request.getParameter("AREA");
		CustInfo ci = new CustInfo();
		ci.setCustid(id);
		ci.setAuthor(name);
		ci.setGoods(goods);
		ci.setPhone(phone);
		ci.setEmail(email);
		ci.setArea(area);
		DBExpert dbe = new DBExpert();
		boolean result = dbe.custInfoRegister(ci);
		if(result) {
			response.sendRedirect("custInfoRegiseterResult.jsp?R=Y");
		}else {
			response.sendRedirect("custInfoRegiseterResult.jsp?R=N");
		}
		
	}

}
