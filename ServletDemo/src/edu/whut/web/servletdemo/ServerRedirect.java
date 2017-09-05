package edu.whut.web.servletdemo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServerRedirect
 */
@WebServlet("/ServerRedirect")
public class ServerRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {	// �������
		req.getSession().setAttribute("name", "WHUT");	// ����session����
		req.setAttribute("info", "WEB COURSE") ;		// ����request����
		// ʵ����RequestDispatcher����ͬʱָ����ת·��
		RequestDispatcher rd = req.getRequestDispatcher("RedirectTarget");
		rd.forward(req, resp) ;				// ��������ת
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {	// �������
		this.doGet(req, resp);				// ����doGet()
	}
	

}
