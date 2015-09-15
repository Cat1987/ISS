package com.rc.isportssearch.memload;
/**
 * 常量接口
 * 
 * @author xuzhicheng
 * @version 1.0
 * @since 2015年7月14日
 */
public interface Constant 
{
	/**
	 * URL超时时间
	 */
	public static final int JSOUP_TIME_OUT = 5000;
	
	/**
	 * 路径元素
	 */
	public static final String HREF = "href";
	
	/**
	 * src元素
	 */
	public static final String SRC = "src";
	
	/**
	 * 元素a
	 */
	public static final String TAG_A = "a";
	
	/**
	 * "http://"
	 */
	public static final String  PROTOCOL_HEAD = "http://";
	
	/**
	 * 新闻链接结尾标志
	 */
	public static final String NEWS_END_CHAR = ".shtml";
	
	/**
	 * 图片链接结尾标志jpg
	 */
	public static final String PIC_END_CHAR_JPG = ".jpg";
	
	/**
	 * 图片链接结尾标志png
	 */
	public static final String PIC_END_CHAR_PNG = ".png";
	
	/**
	 * .png图片
	 */
	public static final String PNG_REX = "img[src$=.png]";
	
	/**
	 * .jpg图片
	 */
	public static final String JPG_REX = "img[src$=.jpg]";
	
	/**
	 * url-data
	 */
	public static final String URL_DATA = "url-data";
	
	/**
	 * title-data
	 */
	public static final String TITLE_DATA = "title-data";
	
	/**
	 * QQ视频的VID
	 */
	public static final String VID = "vid";
	/**
	 * QQ播放前端URL
	 */
	public static final String QQPlayFontUrl = "http://static.video.qq.com/TPout.swf?auto=1&";
	
	/**
	 * 程序目录
	 */
	public static final String APP_ROOT_DIR = System.getProperty("user.dir");
	
	/**
	 * 数据库名称
	 */
	public static final String DB_NAME = "proxool.issdb";
}
