package com.sample.mysite.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Account {
	@Id
    @GeneratedValue(generator = "zizeng")    
    @GenericGenerator(name = "zizeng", strategy = "increment") 
	private int id;
	@ManyToOne(optional = false, fetch = FetchType.LAZY) 
	@JoinColumn(name = "role") 
	private Role role;
	@Column
	private String name;
	@Column
	private String passwd;
	@Column(length=11)
	private String phone;
	@Column
	private int point;
	@Column
	private String info;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "blogger", fetch = FetchType.LAZY) 
	private List<Blog> bloglist;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "writer", fetch = FetchType.LAZY) 
	private List<Article> articlelist;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "author", fetch = FetchType.LAZY) 
	private List<Novel> novellist;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "reporter", fetch = FetchType.LAZY) 
	private List<News> newslist;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "publisher", fetch = FetchType.LAZY) 
	private List<Photo> photelist;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "publisher", fetch = FetchType.LAZY) 
	private List<Song> songlist;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "publisher", fetch = FetchType.LAZY) 
	private List<Video> videolist;
	@Column
	@CreatedDate
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
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
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}
	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the point
	 */
	public int getPoint() {
		return point;
	}
	/**
	 * @param point the point to set
	 */
	public void setPoint(int point) {
		this.point = point;
	}
	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	/**
	 * @return the bloglist
	 */
	public List<Blog> getBloglist() {
		return bloglist;
	}
	/**
	 * @param bloglist the bloglist to set
	 */
	public void setBloglist(List<Blog> bloglist) {
		this.bloglist = bloglist;
	}
	/**
	 * @return the articlelist
	 */
	public List<Article> getArticlelist() {
		return articlelist;
	}
	/**
	 * @param articlelist the articlelist to set
	 */
	public void setArticlelist(List<Article> articlelist) {
		this.articlelist = articlelist;
	}
	/**
	 * @return the novellist
	 */
	public List<Novel> getNovellist() {
		return novellist;
	}
	/**
	 * @param novellist the novellist to set
	 */
	public void setNovellist(List<Novel> novellist) {
		this.novellist = novellist;
	}
	/**
	 * @return the newslist
	 */
	public List<News> getNewslist() {
		return newslist;
	}
	/**
	 * @param newslist the newslist to set
	 */
	public void setNewslist(List<News> newslist) {
		this.newslist = newslist;
	}
	/**
	 * @return the photelist
	 */
	public List<Photo> getPhotelist() {
		return photelist;
	}
	/**
	 * @param photelist the photelist to set
	 */
	public void setPhotelist(List<Photo> photelist) {
		this.photelist = photelist;
	}
	/**
	 * @return the songlist
	 */
	public List<Song> getSonglist() {
		return songlist;
	}
	/**
	 * @param songlist the songlist to set
	 */
	public void setSonglist(List<Song> songlist) {
		this.songlist = songlist;
	}
	/**
	 * @return the videolist
	 */
	public List<Video> getVideolist() {
		return videolist;
	}
	/**
	 * @param videolist the videolist to set
	 */
	public void setVideolist(List<Video> videolist) {
		this.videolist = videolist;
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
