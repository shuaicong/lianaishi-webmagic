package com.lianaishi.repo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import com.lianaishi.dao.LoveDao;
import com.lianaishi.entity.JianshuArticle;
import com.lianaishi.service.LoveService;
import com.lianaishi.service.impl.LoveServiceImpl;
import com.lianaishi.utils.JsonUtils;

@Component
public class JianshuArticleProcessor implements PageProcessor  {
	private static Logger _log = Logger.getLogger(JianshuArticleProcessor.class);  
	
	
	//private LoveDao loveDao;
	@Autowired 
	private LoveServiceImpl loveServiceImpl;

	//抓取网站的相关配置，包括：编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(10).setSleepTime(1000);
    //文章数量
    private static int num = 0;
    //数据库持久化对象，用于将用户信息存入数据库
    //private jianshuDao jianshuDao = new jianshuDaoImpl();
    
	@Override
	public Site getSite() {
		return this.site;
	}

	@Override
	public void process(Page  page) {
		
		JianshuArticle article = new JianshuArticle();
		//1. 如果是列表页面 【入口页面】，将所有文章的详细页面的url放入target集合中。
		if(page.getUrl().regex("http://www\\.jianshu\\.com/c/[\\s\\S]+").match()){
            page.addTargetRequests(page.getHtml().xpath("//a[@class='title']/@href").all());
        }
		//2. 如果是文章详细页面
		else
		{
			num++;//文章数++
            
            String title = page.getHtml().xpath("//div[@class='article']/h1[@class='title']/text()").get();
            //String authorName = page.getHtml().xpath("//span[@class='name']/a/text()").get();
            //String avatar = page.getHtml().xpath("//a[@class='avatar']/@href").get();
            String publishTime = page.getHtml().xpath("//div[@class='meta']/span[@class='publish-time']/text()").get();
            publishTime = publishTime.replace(".", "-")+":00";
            String content = page.getHtml().xpath("//div[@class='show-content']").get();

            //对象赋值
            article.setTitle(title);
            //article.setAuthorName(authorName);
            //article.setAvatar(avatar);
            article.setPublishTime(publishTime);
            article.setModifyDate(publishTime);
            article.setContent(content);
            article.setTopicType("small_image_1");
            article.setUserId("7");
            //System.out.println("num:"+num +" " + article.toString());//输出对象
            
            String textFromTHML = getTextFromTHML(content);
            if(textFromTHML !=null && textFromTHML.length()>100){
            	textFromTHML=textFromTHML.substring(0,100);
			}
            String url = page.getHtml().xpath("//div[@class='image-package']/img/@src").get();
            String summary = saveSummary( url, textFromTHML);
            article.setSummary(summary);
            //jianshuDao.saveTopic(article);//保存文章信息到数据库
            loveServiceImpl.saveTopic(article);
            //loveService.saveTopic(article);
            _log.info("======== 保存文章信息到数据库=========" + new Date());  
		}
	}
	
/*	public static void startProcessor() {
		//异步
        Spider.create(new JianshuArticleProcessor()).addUrl("http://www.jianshu.com/c/GQ5FAs").thread(5).start();
        _log.info("========简书文章小爬虫【结束】喽！=========" + new Date());  
	}*/
	
	public static String saveSummary(String url, String content)
	{
		/*String s = "{\"url_list\":"
				+ "[{\"alt\":\"test1\","
				+ "\"url\":"+url+"}],"
				+ "\"content\":"+content+","
				+ "\"type\":\"small_image_1\"}";*/
		Map<String,Object> dataMap = new HashMap<String,Object>();
		Map<String,Object> dataMap2 = new HashMap<String,Object>();
		dataMap2.put("alt", "test1");
		dataMap2.put("url", url);
		List<HashMap> urlList = new ArrayList<HashMap>();  
		urlList.add((HashMap) dataMap2);
		dataMap.put("url_list", urlList);
		dataMap.put("content", content);
		dataMap.put("type", "small_image_1");
		
		String str = JsonUtils.obj2JsonString(dataMap);
		
		return str;
	}
	
	public static String getTextFromTHML(String htmlStr) {
		Document doc = Jsoup.parse(htmlStr);
		String text = doc.text();
		// remove extra white space
		StringBuilder builder = new StringBuilder(text);
		int index = 0;
		while(builder.length()>index){
			char tmp = builder.charAt(index);
			if(Character.isSpaceChar(tmp) || Character.isWhitespace(tmp)){
				builder.setCharAt(index, ' ');
			}
			index++;
		}
		text = builder.toString().replaceAll(" +", " ").trim();
		return text;
	}
	
	/*public static void main(String[] args) {
		//saveSummary("http://120.76.123.23:8080/lianaishi/uploadImage/w4.jpg", "111");
		//startProcessor();
	}*/
	
}