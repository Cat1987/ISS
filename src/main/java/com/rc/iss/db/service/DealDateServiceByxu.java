package com.rc.iss.db.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.rc.isportssearch.Util.TimeUtil;
import com.rc.isportssearch.memload.DateRex;
import com.rc.iss.dao.DBOperation;

public class DealDateServiceByxu implements DealDateService
{

	@Override
	public int insertQQVideo(Map<String,String> map) throws SQLException
	{
		for(Entry<String, String> en:map.entrySet())
		{
			//如果是今天的才加入
			if(!String.valueOf(en.getValue()).contains(TimeUtil.getTodayTimeRex(DateRex.YMD_)))
			{
				map.remove(en.getKey());
			}
		}
		
		return 0;
	}

	@Override
	public int insertQQNews(Map<String,String> map)
	{
		//存放SQLs
		List <String> sqlList = new ArrayList<String>();
		String sql = "";
		for(Entry<String, String> en:map.entrySet())
		{
			//如果是今天的才加入
			if(String.valueOf(en.getKey()).contains(TimeUtil.getTodayTimeRex(DateRex.YMD_)))
			{
				String currentTime = TimeUtil.getTodayTimeRex(DateRex.YMDhhmmss_);
				sql = "insert into tab_news(url,new_name,add_time) values ( '"+ en.getKey()+"', '"+en.getValue()+"','"+currentTime+"')";
				sqlList.add(sql);
			}
		}
		DBOperation.getOperation().update(sqlList);
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
		
		return null;
	}



}
