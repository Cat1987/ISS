package com.rc.isportssearch.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.rc.isportssearch.Util.TimeUtil;
import com.rc.isportssearch.memload.Constant;
import com.rc.isportssearch.memload.DateRex;

public class BasketBallSearch extends Search
{
	private static final String BASKETBALL_VIDEO_CLASS = "_videolink";
//	// 网页默认选中的视频链接
//	private static final String BASKETBALL_VIDEO_CLASS_SELECT = "J_Play_Item ";
	
	private Set<String> newURLSet = new HashSet<String>();
	private Set<String> picURLSet = new HashSet<String>();
	private Set<String> videoURLSet = new HashSet<String>();
	
	{
		getUrlType();
	}
	@Override
	public Object searchInfo()
	{
		
		Document doc = getDocument(newURLSet.iterator().next());
		Elements links = doc.getElementsByTag("a");
		for (Element link : links)
		{
			if (link.attr("href").contains("http://"))
			{
				System.out.println(link.text());
				System.out.println(link.attr("href"));
			}

		}
		return null;
	}

	@Override
	public void infoStorage(Object obj)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public List<Map<String,String>> searchPic()
	{
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Document doc = null;
		while (picURLSet.iterator().hasNext())
		{
			String url = picURLSet.iterator().next();
			doc = getDocument(url);
			// 做逻辑分组 Elements pngs = doc.select("img[src$=.png]");

			// png格式为球队LOGO
			Elements links = doc.select(Constant.PNG_REX);
//			Elements links1 = doc.select(Constant.JPG_REX);
			list.add(handlePicLinks(links));
		}
		return list;
	}

	@Override
	public List<Map<String,String>> searchNews()
	{
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Document doc = null;
		Iterator<String> it = newURLSet.iterator();
		while (it.hasNext())
		{
			String url = it.next();
			doc = getDocument(url);
			// 做逻辑分组
			Elements links = doc.getElementsByTag("a");
			list.add(handleNewsLinks(links));
		}
		return list;
	}

	@Override
	public List<Map<String,String>> searchVideo()
	{
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Document doc = null;
		while (newURLSet.iterator().hasNext())
		{
			String url = newURLSet.iterator().next();
			doc = getDocument(url);
			// 做逻辑分组
			Elements links = doc.getElementsByClass(BASKETBALL_VIDEO_CLASS);
			list.add(handleVideo(links)) ;
		}
		return list;
//		Document doc = getDocument("http://v.qq.com/cover/i/iy1pzzipwwrx7mq.html?vid=h0017a9g7kh");
//		String video = doc.html();
//		Elements links = doc.getElementsByClass(BASKETBALL_VIDEO_CLASS);
//		return handleVideo(links);
	}

	/**
	 * 处理 a href=
	 * 
	 * @param links
	 */
	private Map<String, String> handleNewsLinks(Elements links)
	{
		Map<String, String> newsMap = new HashMap<String, String>();
		if (null == links || 0 == links.size())
		{
			return newsMap;
		}
		for (Element link : links)
		{
			String name = link.text();
			String linkUrl = link.attr(Constant.HREF);
			// 包含'http://'
			if (linkUrl.contains(Constant.PROTOCOL_HEAD)
					&& linkUrl.contains(Constant.NEWS_END_CHAR))
			{
				newsMap.put(linkUrl, name);
			}
		}
		return newsMap;
	}

	/**
	 * 处理 img src=
	 * 
	 * @param links
	 */
	private Map<String, String> handlePicLinks(Elements links)
	{
		Map<String, String> newsMap = new HashMap<String, String>();
		if (null == links || 0 == links.size())
		{
			return newsMap;
		}
		for (Element link : links)
		{
			String name = link.text();
			String linkUrl = link.attr(Constant.SRC);
			// 包含'http://'
			if (linkUrl.contains(Constant.PROTOCOL_HEAD)
					&& linkUrl.contains(Constant.NEWS_END_CHAR))
			{
				newsMap.put(linkUrl, name);
			}
		}
		return newsMap;
	}

	/**
	 * 处理视频链接<br>
	 * ut =2015-07-18 08:40:59 vid
	 * 
	 * @param links
	 * @return
	 */
	private Map<String, String> handleVideo(Elements links)
	{
		Map<String, String> newsMap = new HashMap<String, String>();
		if (null == links || 0 == links.size())
		{
			return newsMap;
		}
		for (Element link : links)
		{
			String name = link.text();
			String linkUrl = link.attr(Constant.HREF);
			String ut = link.attr("ut");
			String sv = link.attr("sv");
			// 有vid同时要是今天的视频
			if (linkUrl.contains(Constant.VID)
					&& ut.contains(TimeUtil.getTodayTimeRex(DateRex.YMD_)))
			{
				newsMap.put(sv, name);
			}
		}
		return newsMap;
	}
	
	/**
	 * 获取链接类型 1：新闻 2：图片 3：视频
	 * @return
	 */
	private void getUrlType()
	{
		for(Map<Integer,String> map :urls)
		{
			for(Entry<Integer,String> en:map.entrySet())
			{
				switch(en.getKey())
				{
					case 1: newURLSet.add(en.getValue());
					break;
					case 2: picURLSet.add(en.getValue());
					break;
					case 3: videoURLSet.add(en.getValue());
					break;
					default:;
				}
			}
		}
		
		
	}

}
