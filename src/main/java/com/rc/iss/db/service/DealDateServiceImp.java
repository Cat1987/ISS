package com.rc.iss.db.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import com.rc.isportssearch.db.DBUtil;
import com.rc.isportssearch.memload.Constant;

/**
 * 实现类
 * ClassName: DealDateServiceImp <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason: TODO ADD REASON(可选). <br/>  
 * date: 2015-7-25 下午12:05:26 <br/>  
 *  
 * @author cat 
 * @version   
 * @since JDK 1.7 
 * 多写一点，离梦想近一点！
 */
public class DealDateServiceImp implements DealDateService
{

	@Override
	public int insertQQVideo(Map<String,String> map) throws SQLException
	{
		Connection con = DBUtil.getConection(Constant.DB_NAME);
		Statement ps = con.createStatement();

		return 0;
	}

	@Override
	public int insertQQNews(Map<String,String> map)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertQQPic(Map<String,String> map)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, String> queryUrl()
	{
		String sql = "select id ,url from tab_url";
		
		return null;
	}

}
