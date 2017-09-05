package edu.whut.web.servletdemo;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextSetServlet
 */
@WebServlet("/ServletContextSetServlet")
public class ServletContextSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {	// �������
		ServletContext app = super.getServletContext() ;	// ȡ��application
		System.out.println("��ʵ·����" + app.getRealPath("/"));
		app.setAttribute("appName", "ServletDemo");
		PrintWriter out = resp.getWriter(); 	// ׼�����
		out.println("appName --> " + app.getAttribute("appName"));
		out.println("appPath --> " + app.getRealPath("/"));
		out.close();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {	// �������
		this.doGet(req, resp);				// ����doGet()
	}

}
