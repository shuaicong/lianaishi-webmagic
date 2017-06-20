package com.lianaishi.service;

import com.lianaishi.entity.JianshuArticle;
import com.lianaishi.entity.User;

public interface LoveService {

	public int saveTopic(JianshuArticle article);
	
	public int addUser(User user);
}
