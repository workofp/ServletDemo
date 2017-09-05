package edu.whut.web.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet
 */
@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException { 		// ����get����
		String info = req.getParameter("info") ;		// �����������
		PrintWriter out = resp.getWriter(); 			// ׼�����
		out.println("<html>"); 					// ���htmlԪ��		out.println("<head><title>MLDNJAVA</title></head>"); 	// ���htmlԪ��
		out.println("<body>");				// ���htmlԪ��
		out.println("<h1>" + info + "</h1>"); 			// ���htmlԪ��
		out.println("</body>");				// ���htmlԪ��
		out.println("</html>");				// ���htmlԪ��
		out.close() ;					// �ر����
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		// ����post����
		this.doGet(req, resp) ;				// ͬһ�ַ����崦��
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		String info = req.getParameter("info") ;		// �����������
//		PrintWriter out = resp.getWriter(); 			// ׼�����
//		out.println("<html>"); 				// ���htmlԪ��		out.println("<head><title>MLDNJAVA</title></head>"); 	// ���htmlԪ��
//		out.println("<body>");				// ���htmlԪ��
//		out.println("<h1>" + info + "</h1>"); 			// ���htmlԪ��
//		out.println("</body>");				// ���htmlԪ��
//		out.println("</html>");				// ���htmlԪ��
//		out.close() ;					// �ر����
//	}


}
