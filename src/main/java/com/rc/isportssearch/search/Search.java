package com.rc.isportssearch.search;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.rc.isportssearch.memload.Constant;
import com.rc.isportssearch.memload.UrlGlobal;

/**
 * 搜索引擎抽象类
 * 
 * 搜索关注的信息</br>
 * 主要用于 搜索引擎的核心主要功能包括信息采集，信息存储
 * @author xuzhicheng
 * @version 1.0
 * @since 2015年7月14日
 */
public abstract class Search 
{
	protected static String VIDEO_URL = "http://video.sina.com.cn/z/sports/k/nba/sinanbavideo/index.html";
	
	/**
	 * URL集合
	 */
	protected List<Map<Integer,String>> urls =  UrlGlobal.urlList;
	
			
	/**
	 * 搜索信息方法
	 * @return 返回信息
	 */
	public abstract Object searchInfo();
	
	/**
	 * 信息存储
	 * 多种方式如：1.数据库，2.文件系统
	 */
	public abstract void infoStorage(Object obj);
	
	/**
	 * 图片抓取
	 * @return key:url value:pic_name
	 */
	public abstract List<Map<String,String>> searchPic();
	
	/**
	 * 新闻抓取
	 * @return key:url value:news_name
	 */
	public abstract List<Map<String,String>> searchNews();
	
	/**
	 * 视频抓取
	 * @return key:url value:video_name
	 */
	public abstract List<Map<String,String>> searchVideo();
	
	/**
	 * 解析URL看是否正常
	 * @return 正常与否
	 */
	protected boolean parseUrl(String url)
	{
		try
		{
			Jsoup.connect(url).timeout(Constant.JSOUP_TIME_OUT).get();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 获取Jousp的的Document对象
	 * @return doc
	 */
	protected static Document getDocument(String url)
	{
		Document doc = null;
		try
		{
			doc = Jsoup.connect(url).timeout(Constant.JSOUP_TIME_OUT).get();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			return doc;
		}
		return doc;
	}
	
	/**
	 * 获取Jousp的的Document对象
	 * @return doc
	 */
	protected static Document getDocFollowRedirects(String url)
	{
//		File input =new File("http://video.sina.com.cn/z/sports/k/nba/sinanbavideo/index.html);
		Document doc = null;
		try
		{
			doc = Jsoup.connect(url).timeout(Constant.JSOUP_TIME_OUT).followRedirects(true).execute().parse();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			return doc;
		}
		return doc;
	}
}
