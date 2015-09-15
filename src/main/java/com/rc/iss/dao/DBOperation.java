package com.rc.iss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc.isportssearch.db.DBUtil;
import com.rc.isportssearch.memload.Constant;

/**
 * ISS DBOperation
 * ClassName: IssDao <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason: TODO ADD REASON(可选). <br/>  
 * date: 2015-7-25 下午12:48:39 <br/>  
 *  
 * @author cat 
 * @version   
 * @since JDK 1.7 
 * 多写一点，离梦想近一点！
 */
public class DBOperation
{
	private static DBOperation op = null;
	
	private DBOperation()
	{
	}
	
	public static DBOperation getOperation()
	{
		if(null == op)
		{
			op = new DBOperation();
		}
		return op;
	}
	
	/**
	 * 修改
	 * @param sqlList
	 * @return
	 */
	public int[] update(List<String> sqlList)
	{
		Connection con  = DBUtil.getConection(Constant.DB_NAME);
		Statement st = null;
		int [] updateCounts = null;
		try 
		{
			st= con.createStatement();
			for(String sql :sqlList)
			{
				st.addBatch(sql);
			}
			updateCounts = st.executeBatch();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				st.close();
				con.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
		return updateCounts;
	}
	
	public List<Map<String,Object>>  query(String sql)
	{
		Connection con  = DBUtil.getConection(Constant.DB_NAME);
		PreparedStatement ps = null;
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>(); 
		
		try 
		{
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData  rsd = rs.getMetaData();
			//取列数
			int column = rsd.getColumnCount();
			while(rs.next())
			{
				Map<String,Object> map = new HashMap<String,Object>();
				//拿出列名
				for(int i = 1;i<=column; i++)
				{
					map.put(rsd.getColumnName(i),rs.getObject(i));
				}
				list.add(map);
			}	
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				ps.close();
				con.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
		return list;
	}
}
