package com.lianaishi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import us.codecraft.webmagic.Spider;

import com.lianaishi.repo.JianshuArticleProcessor;
import com.lianaishi.service.LoveService;

@Configuration
@EnableScheduling //启用定时任务
public class SchedulingConfig {
	
	@Autowired
	private LoveService loveService;
	
	@Autowired
	private JianshuArticleProcessor jianshuArticleProcessor;

	int count = 0;
	@Scheduled(cron = "0 55 20 * * ? ") 
	public void scheduler()
	{
		count++; 
		System.out.println("定时任务" + count);
		
		/*JianshuArticle ja = new JianshuArticle();
		ja.setContent("1111");
		ja.setModifyDate("2017-06-19 22:47:00");
		ja.setPublishTime("2017-06-19 22:47:00");
		ja.setSummary("11111111");
		ja.setTitle("@@@");
		ja.setTopicType("small_image_1");
		ja.setUserId("7");
		loveService.saveTopic(ja);*/
		
		//JianshuArticleProcessor.startProcessor(loveService);
		
		//异步
        Spider.create(jianshuArticleProcessor).addUrl("http://www.jianshu.com/c/GQ5FAs").thread(5).start();
		System.out.println("@@@@");
	}
}
