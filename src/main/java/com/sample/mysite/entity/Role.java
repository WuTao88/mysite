package com.sample.mysite.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Role {
	@Id
    @GeneratedValue(generator = "zizeng")    
    @GenericGenerator(name = "zizeng", strategy = "increment") 
	private int id;
	@Column(unique=true,nullable=false)
	private String roleName;
	@Column
	private String descrption;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "role", fetch = FetchType.LAZY) 
	private List<Account> list;
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
	 * @return the role_name
	 */

	/**
	 * @return the descrption
	 */
	public String getDescrption() {
		return descrption;
	}
	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @param descrption the descrption to set
	 */
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	/**
	 * @return the list
	 */
	public List<Account> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<Account> list) {
		this.list = list;
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
