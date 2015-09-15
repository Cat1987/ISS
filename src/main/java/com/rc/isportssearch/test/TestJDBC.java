package com.rc.isportssearch.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * ClassName: TestJDBC <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason: TODO ADD REASON(可选). <br/>  
 * date: 2015-7-20 下午9:59:31 <br/>  
 *  
 * @author cat 
 * @version   
 * @since JDK 1.7 
 * 多写一点，离梦想近一点！
 */
public class TestJDBC
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://192.168.2.101/iss?user=root&password=7967517&useUnicode=true&&characterEncoding=utf8&autoReconnect = true";
			Connection conn = DriverManager.getConnection(url,"root","7967517");
			System.out.println(conn.hashCode());
			conn.close();
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
