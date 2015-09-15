package com.rc.isportssearch.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rc.isportssearch.memload.Constant;

/**
 * 搜索引擎模块初始化</rb>
 * </br>
 * 日志</br>
 * 数据源</br>
 * 内存常量
 * @author xuzhicheng
 * @version 1.0
 * @since 2015年7月14日
 */
public class InforSearchInit 
{
	private final static Logger logger = LoggerFactory.getLogger(InforSearchInit.class);
	
	public void init()
	{
//		Global.urlSet.add("http://sports.sina.com.cn/nba/");
		//日志初始化
		AppCommonInit.initLog(Constant.APP_ROOT_DIR+"/conf/log4j.xml");
		logger.info("log is Complete ! ");
		
		AppCommonInit.initProoxlDB(Constant.APP_ROOT_DIR+"/conf/prox.xml");
		AppCommonInit.initUrl();
		
	}
	
}
