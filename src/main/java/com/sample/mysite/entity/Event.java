package com.sample.mysite.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Event {

	@Id
    @GeneratedValue(generator = "zizeng")    
    @GenericGenerator(name = "zizeng", strategy = "increment") 
	private int id;
	@Column
	private String eName;//活动名称
	@Column
	private Date eTimeStart;//活动开始时间
	@Column
	private Date eTimeEnd;//活动结束时间	
	@Column
	private String eContent;//活动内容
	@Column
	private String [] eReward;//活动奖励
	@Column
	@CreatedDate
	private Date createTime;//活动创建时间
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
	 * @return the e_name
	 */
	/**
	 * @return the eName
	 */
	public String geteName() {
		return eName;
	}
	/**
	 * @param eName the eName to set
	 */
	public void seteName(String eName) {
		this.eName = eName;
	}
	/**
	 * @return the eTimeStart
	 */
	public Date geteTimeStart() {
		return eTimeStart;
	}
	/**
	 * @param eTimeStart the eTimeStart to set
	 */
	public void seteTimeStart(Date eTimeStart) {
		this.eTimeStart = eTimeStart;
	}
	/**
	 * @return the eTimeEnd
	 */
	public Date geteTimeEnd() {
		return eTimeEnd;
	}
	/**
	 * @param eTimeEnd the eTimeEnd to set
	 */
	public void seteTimeEnd(Date eTimeEnd) {
		this.eTimeEnd = eTimeEnd;
	}
	/**
	 * @return the eContent
	 */
	public String geteContent() {
		return eContent;
	}
	/**
	 * @param eContent the eContent to set
	 */
	public void seteContent(String eContent) {
		this.eContent = eContent;
	}
	/**
	 * @return the eReward
	 */
	public String[] geteReward() {
		return eReward;
	}
	/**
	 * @param eReward the eReward to set
	 */
	public void seteReward(String[] eReward) {
		this.eReward = eReward;
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
