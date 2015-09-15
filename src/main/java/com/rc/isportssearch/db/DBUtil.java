package com.rc.isportssearch.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 数据库
 * 
 * @author xuzhicheng
 * @version 1.0
 * @since 2015年7月20日
 */
public class DBUtil
{
	private final static Logger logger = LoggerFactory.getLogger(DBUtil.class);
	
	/**
	 * 获取指定数据库连接池的连接
	 * @param poolName
	 * @return
	 */
	public static Connection getConection(String poolName)
	{
		Connection connection = null;
		try
		{
			connection= DriverManager.getConnection(poolName);
			return connection;
		} catch (SQLException e)
		{
			e.printStackTrace();
			logger.error("获取连接出错！");
		}
		return connection;
	}
	
}
