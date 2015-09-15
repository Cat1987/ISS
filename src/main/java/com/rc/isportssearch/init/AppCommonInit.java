package com.rc.isportssearch.init;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.xml.DOMConfigurator;
import org.logicalcobwebs.proxool.ProxoolException;
import org.logicalcobwebs.proxool.configuration.JAXPConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rc.isportssearch.memload.UrlGlobal;
import com.rc.iss.dao.DBOperation;

/**
 * 初始工具类  日常初始化 如日志数据库等
 * 
 * @author xuzhicheng
 * @version 1.0
 * @since 2015年7月20日
 */
public class AppCommonInit
{
	private final static Logger logger = LoggerFactory.getLogger(AppCommonInit.class);
	
	/**
	 * 日志初始化
	 * @return
	 */
	public static final boolean initLog(String path)
	{
		//如果出错那边可以看到信息
		DOMConfigurator.configureAndWatch(path);		
		return true;
	}
	
	/**
	 * 数据库初始化 prooxl
	 * @return
	 */
	public static final boolean initProoxlDB(String path)
	{
		try
		{
			JAXPConfigurator.configure(path, false);
		} 
		catch (ProxoolException e)
		{
			e.printStackTrace();
			logger.error("初始化proxool连接池失败！");
			return false;
		}
		return true;
	}
	
	/**
	 * 初始化URL
	 */
	public static final boolean initUrl()
	{
 		List<Map<Integer,String >> urls = new ArrayList<Map<Integer,String >>();
		List<Map<String,Object>> records= DBOperation.getOperation()
				.query("select url_id ,url from tab_urls where statu = 1 ");
		for(Map<String,Object > map:records)
		{
			Map<Integer,String > mapForGUrl = new HashMap<Integer,String >();
			mapForGUrl.put((int)(map.get("url_id")),String.valueOf(map.get("url")));
			urls.add(mapForGUrl);
		}
		UrlGlobal.urlList = urls ;
		return true;
	}
}
