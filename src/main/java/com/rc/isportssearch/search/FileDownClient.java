package com.rc.isportssearch.search;

import java.io.File;

/**
 * 下载服务器文件
 * 
 * @author xuzhicheng
 * @version 1.0
 * @since 2015年7月14日
 */
public class FileDownClient {

	public static void main(String[] args) 
	{
		File file = new File("http://sports.sina.com.cn/nba/2015-07-14/"); 
		file.listFiles();
	}

}
