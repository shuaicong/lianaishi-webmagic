package com.lianaishi.entity;

/**
 * @描述: 
 * @作者: 南望孤笑
 * @时间：2017-6-19 下午4:19:49
 */
public class JianshuArticle {

	private String topicId;
	
	private String userId;
	
	private String modifyDate;
	
	private String topicType;
	
	private String title;

    private String avatar;

    private String authorName;

    private String publishTime;

    private String content;
    
    private String summary;

    public String getTitle() {
        return title;
    }

    public String getAvatar() {
        return avatar;
    }

    @Override
    public String toString() {
        return "JianshuArticle{" +
                "title='" + title + '\'' +
                ", avatar='" + avatar + '\'' +
                ", authorName='" + authorName + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public String getContent() {
        return content;
    }

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getTopicType() {
		return topicType;
	}

	public void setTopicType(String topicType) {
		this.topicType = topicType;
	}
	
	
}
