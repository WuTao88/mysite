package com.sample.mysite.entity;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Blog {
	@Id
    @GeneratedValue(generator = "zizeng")    
    @GenericGenerator(name = "zizeng", strategy = "increment") 
	private int id;
	@ManyToOne(optional = false, fetch = FetchType.LAZY) 
	@JoinColumn(name = "blogger",nullable=false) 
	private Account blogger;
	@Column
	private String content;
	@Column
	@CreatedDate
	private Date createTime;
	@Column
	@LastModifiedDate
	private Date modifyTime;
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
	 * @return the account
	 */


	
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @return the blogger
	 */
	public Account getBlogger() {
		return blogger;
	}
	/**
	 * @param blogger the blogger to set
	 */
	public void setBlogger(Account blogger) {
		this.blogger = blogger;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * @return the modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * @return the deleteTark
	 */
	public boolean isDeleteMark() {
		return deleteMark;
	}
	/**
	 * @param deleteTark the deleteTark to set
	 */
	public void setDeleteMark(boolean deleteMark) {
		this.deleteMark = deleteMark;
	}
	
	
}
