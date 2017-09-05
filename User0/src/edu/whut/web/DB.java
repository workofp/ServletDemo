package edu.whut.web;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DB {
	//һ������
	private Connection conn;
	//Statement����ִ�о�̬ SQL ��䲢�����������ɽ���Ķ��� 
	private Statement stmt;
	//һ�������
	private ResultSet rst;
	/*
	//����һ�����ݿ�����
	private void init(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl="jdbc:mysql://localhost:4306/users";
			String dbName="root";
			String dbPassword="123456";
			try {
				conn = DriverManager.getConnection(dbUrl, dbName, dbPassword);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/

	//����һ�����ݿ�����
	private void init(){
		try {
			Context env = new InitialContext();
			DataSource pool = (DataSource) env.lookup("java:comp/env/jdbc/users");
			if (pool == null)
				throw new Exception("jdbc/users is an unknown DataSource");
			conn = pool.getConnection();
			stmt = conn.createStatement();
		} catch (Exception e) {
			System.out.println("naming:" + e.getMessage());
		}

	}

	//����Connectionһ������
	public DB(){
		try {
			init();
			stmt=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//ִ�����ݿ��ѯ���
	public ResultSet excuteQuery(String s){
		if(stmt!=null){
			try {
				rst=stmt.executeQuery(s);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rst;
	}
	public int excuteUpdata(String s){
		int status=0;
		if(stmt!=null){
			try {
				status=stmt.executeUpdate(s);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;
	}
	public boolean next(){
		try {
			return rst.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//�����Ǹ�ֵ����
	public int getInt(int i) throws Exception{
		return rst.getInt(i);
	}
	public String getString(String s) throws Exception{
		return rst.getString(s);
	}
	public void close(){
			try {
				if(conn!=null)	conn.close();
				if(stmt!=null)	stmt.close();
				if(rst!=null)	rst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
