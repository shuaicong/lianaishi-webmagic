package com.lianaishi.dao;

import org.apache.ibatis.annotations.Insert;

import com.lianaishi.entity.JianshuArticle;
import com.lianaishi.entity.User;


/**
 * @描述: 
 * @作者: 南望孤笑
 * @时间：2017-6-19 下午4:21:26
 */
public interface LoveDao {
	
	@Insert("insert into t_topic(title,summary,content,user_id,create_date,modify_date,topic_type) " +
			"values(#{title}, #{summary}, #{content}, #{userId}, #{publishTime}, #{publishTime}, #{topicType})") 
// "insert into t_topic ( title,summary,content,user_id,create_date,modify_date,topic_type) values (? , ? , ? , ? , ? , ?, ? ) "
    public int saveTopic(JianshuArticle article);
	
	@Insert("insert into user(name, age) values(#{name}, #{age})")  
    public int addUser(User user);
}
