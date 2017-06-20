package com.lianaishi.repo;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import com.lianaishi.dao.LoveDao;
import com.lianaishi.entity.JianshuArticle;

@Component("JobInfoDaoPipeline")
public class JobInfoDaoPipeline implements PageModelPipeline<JianshuArticle> {

	@Resource
	private LoveDao loveDao;
	
	@Override
	public void process(JianshuArticle article, Task arg1) {
		loveDao.saveTopic(article);
	}

}
