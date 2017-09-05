package edu.whut.web.servletdemo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClientRedirect
 */
@WebServlet("/ClientRedirect")
public class ClientRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {	// �������
		req.getSession().setAttribute("name", "WHUT") ;	// ����session����
		req.setAttribute("info", "WEB COURSE") ;	// ����request����
		resp.sendRedirect("RedirectTarget") ;	// ҳ����ת
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {	// �������
		this.doGet(req, resp);				// ����doGet()
	}

}
