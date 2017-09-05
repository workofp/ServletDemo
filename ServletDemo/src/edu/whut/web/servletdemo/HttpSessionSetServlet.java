package edu.whut.web.servletdemo;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HttpSessionSetServlet
 */
@WebServlet("/HttpSessionSetServlet")
public class HttpSessionSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {	// �������
		HttpSession ses = req.getSession() ;		// ȡ��session����
		System.out.println("SESSION ID --> " + ses.getId());// ȡ��session id
		ses.setAttribute("username", "administrator") ;		// ��������
		System.out.println("username�������ݣ�" + ses.getAttribute("username"));
		PrintWriter out = resp.getWriter(); 	// ׼�����
		out.println("SESSION ID --> " + ses.getId());
		out.println("username --> " + ses.getAttribute("username"));
		out.close();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {	// �������
		this.doGet(req, resp);				// ����doGet()
	}
       

}
