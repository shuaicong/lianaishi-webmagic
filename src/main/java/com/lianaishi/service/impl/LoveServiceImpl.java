package com.lianaishi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.lianaishi.dao.LoveDao;
import com.lianaishi.entity.JianshuArticle;
import com.lianaishi.entity.User;
import com.lianaishi.service.LoveService;



@Component
public class LoveServiceImpl implements LoveService {

	@Autowired
	private LoveDao loveDao;
	
	public int saveTopic(JianshuArticle article) {
		return loveDao.saveTopic(article);
	}
	
	@Override
	public int addUser(User user) {
		return loveDao.addUser(user);
	}
	
}
