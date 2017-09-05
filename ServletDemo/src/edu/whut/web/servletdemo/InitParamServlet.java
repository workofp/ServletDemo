package edu.whut.web.servletdemo;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamServlet
 */
@WebServlet(urlPatterns={"/InitParamServlet"}
	, initParams={
		@WebInitParam(name="ref", value="www.whut.edu.cn")} )
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String initParam = null ;		// ���ڽ��ճ�ʼ������
	public void init(ServletConfig config) throws ServletException{
		this.initParam = config.getInitParameter("ref") ;// ���ճ�ʼ������
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {// �������
		System.out.println("��ʼ��������" + this.initParam);// �����ʼ������
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {// �������
		this.doGet(req, resp);				// ����doGet()
	}


}
