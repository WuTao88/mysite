package com.sample.mysite.entity;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Entity
@EntityListeners(AuditingEntityListener.class)
public class News {
	@Id
    @GeneratedValue(generator = "zizeng")    
    @GenericGenerator(name = "zizeng", strategy = "increment")
	private int id;
	@Column
	private String newsTitle;
	@ManyToOne(optional = false, fetch = FetchType.LAZY) 
	@JoinColumn(name = "reporter") 
	private Account reporter;
	@Column
	private String newsContent;
	@Column
	private Date publishTime;
	@Column
	@CreatedDate
	private Date createTime;
	
	@Column
	private boolean deleteMark;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the reporter
	 */
	public Account getReporter() {
		return reporter;
	}
	/**
	 * @param reporter the reporter to set
	 */
	public void setReporter(Account reporter) {
		this.reporter = reporter;
	}
	/**
	 * @return the newsTitle
	 */
	public String getNewsTitle() {
		return newsTitle;
	}
	/**
	 * @param newsTitle the newsTitle to set
	 */
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	/**
	 * @return the newsContent
	 */
	public String getNewsContent() {
		return newsContent;
	}
	/**
	 * @param newsContent the newsContent to set
	 */
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	/**
	 * @return the publishTime
	 */
	public Date getPublishTime() {
		return publishTime;
	}
	/**
	 * @param publishTime the publishTime to set
	 */
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the deleteMark
	 */
	public boolean isDeleteMark() {
		return deleteMark;
	}
	/**
	 * @param deleteMark the deleteMark to set
	 */
	public void setDeleteMark(boolean deleteMark) {
		this.deleteMark = deleteMark;
	}
	
}
