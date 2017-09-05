package edu.whut.web.servletdemo;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RedirctTarget
 */
@WebServlet("/RedirectTarget")
public class RedirectTarget extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {	// �������
		HttpSession ses = req.getSession() ;		// ȡ��session����
		PrintWriter out = resp.getWriter(); 	// ׼�����
		out.println("Name in SESSION --> " + ses.getAttribute("name"));
		out.println("info in Request --> " + req.getAttribute("info"));
		out.close();		
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {	// �������
		this.doGet(req, resp);				// ����doGet()
	}

}
