package com.rc.iss.db.service;

import java.sql.SQLException;
import java.util.Map;

/**
 * 
 * ClassName: DealDateService <br/>  
 * Function: 处理每天的数据入库 ADD FUNCTION. <br/>  
 * Reason: TODO ADD REASON(可选). <br/>  
 * date: 2015-7-25 下午12:01:59 <br/>  
 *  
 * @author cat 
 * @version   
 * @since JDK 1.7 
 * 多写一点，离梦想近一点！
 */

public interface DealDateService
{
	/**
	 * 插入QQ视频信息
	 * @return
	 * @throws SQLException 
	 */
	public int insertQQVideo(Map<String,String> map) throws SQLException;
	
	/**
	 * 插入QQ视频新闻
	 * @return
	 */
	public int insertQQNews(Map<String,String> map);
	
	/**
	 * 插入QQ图片
	 * @return
	 */
	public int insertQQPic(Map<String,String> map);
	
	/**
	 * 去取URL
	 */
	public  Map<String,String>  queryUrl();

}
