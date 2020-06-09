package com.sample.mysite.entity;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Video {
	@Id
    @GeneratedValue(generator = "zizeng")    
    @GenericGenerator(name = "zizeng", strategy = "increment")   
	private int id;
	@Column
	private String videoName;
	@Column
	private String path;
	@ManyToOne(optional = false, fetch = FetchType.LAZY) 
	@JoinColumn(name = "publisher",nullable=false) 
	private Account publisher;
	@Column
	@CreatedDate
	private Date publishTime;
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
	 * @return the videoName
	 */
	public String getVideoName() {
		return videoName;
	}
	/**
	 * @param videoName the videoName to set
	 */
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @return the publisher
	 */
	public Account getPublisher() {
		return publisher;
	}
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(Account publisher) {
		this.publisher = publisher;
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
