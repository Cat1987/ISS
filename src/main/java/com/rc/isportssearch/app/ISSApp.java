package com.rc.isportssearch.app;

import com.rc.isportssearch.init.InforSearchInit;
import com.rc.isportssearch.search.BasketBallSearch;
import com.rc.isportssearch.search.Search;
import com.rc.iss.db.service.DealDateService;
import com.rc.iss.db.service.DealDateServiceByxu;

/**
 * 入口逻辑实现
 * ClassName: ISSApp <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason: TODO ADD REASON(可选). <br/>  
 * date: 2015-8-1 上午8:16:32 <br/>  
 *  
 * @author cat 
 * @version   
 * @since JDK 1.7 
 * 多写一点，离梦想近一点！
 */
public class ISSApp
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//初始化
		new InforSearchInit().init();
		Search bbs =  new BasketBallSearch();
		DealDateService ddsTest = new DealDateServiceByxu();
		ddsTest.insertQQNews(bbs.searchNews().get(0));

	}

}
