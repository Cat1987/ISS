package com.rc.isportssearch.test;

import java.io.IOException;
import java.net.URISyntaxException;

import com.rc.isportssearch.init.InforSearchInit;

public class Test 
{

	public static void main(String[] args) throws URISyntaxException, IOException 
	{
		new InforSearchInit().init();
//		Connection conn = DBUtil.getConection("proxool.issdb");
//		try
//		{
//			PreparedStatement ps = conn.prepareStatement("select id,name from tab_user");
//			ResultSet rs = ps.executeQuery();
//			ResultSetMetaData  rsd =rs.getMetaData();
//			while(rs.next())
//			{
//				System.out.println(rs.getInt("id"));
//				System.out.println(rs.getString("name"));
//			}
//		} catch (SQLException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Search bbs = new BasketBallSearch();
//		List<Map<String, String>> news = bbs.searchNews();
//		//入库
//		DealDateService ddsTest = new DealDateServiceByxu();
//		ddsTest.insertQQNews(news);
//		bbs.searchPic();
//		Map<String,String> videos  = bbs.searchVideo();
//		Set <String> lkey = videos.keySet();
//		while(lkey.iterator().hasNext())
//		{
//			java.net.URI uri = new java.net.URI(SearchUtil.qqVideoUrl()+lkey.iterator().next());                 
//			java.awt.Desktop.getDesktop().browse(uri);
//			break;
//		}
		
	}

}
