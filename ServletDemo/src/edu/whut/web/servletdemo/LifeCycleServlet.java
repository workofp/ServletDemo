package edu.whut.web.servletdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * Servlet implementation class LifeCycleServlet
 */
@WebServlet(urlPatterns={"/LifeCycleServlet"},loadOnStartup=1)      
public class LifeCycleServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
       
	public void init() throws ServletException {		// ��ʼ������
		System.out.println("** 1��Servlet��ʼ�� --> init()");
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {	// �������
		System.out.println("** 2��Servlet���� --> doGet()��doPost()");
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {	// �������
		this.doGet(req, resp);				// ����doGet()
	}
	public void destroy() {	 			// Servlet����
		System.out.println("** 3��Servlet���� --> destroy()");
	}


}
