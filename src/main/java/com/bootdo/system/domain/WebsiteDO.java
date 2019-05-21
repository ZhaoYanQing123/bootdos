package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-20 15:44:15
 */
public class WebsiteDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//@主键
	private Integer id;
	//网站名称
	private String title;
	//关键词
	private String keyword;
	//描述
	private String descr;
	//客服电话
	private String phone;
	//邮箱
	private String mail;
	//备案号
	private String baknum;
	//版权
	private String versions;

	private String baknumAndVersions;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getBaknumAndVersions() {
		return versions+" 版权所有 "+versions;
	}

	public void setBaknumAndVersions(String baknumAndVersions) {
		this.baknumAndVersions = baknumAndVersions;
	}

	/**
	 * 设置：@主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：@主键
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：网站名称
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：网站名称
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：关键词
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	/**
	 * 获取：关键词
	 */
	public String getKeyword() {
		return keyword;
	}
	/**
	 * 设置：描述
	 */
	public void setDescr(String descr) {
		this.descr = descr;
	}
	/**
	 * 获取：描述
	 */
	public String getDescr() {
		return descr;
	}
	/**
	 * 设置：客服电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：客服电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：邮箱
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * 获取：邮箱
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * 设置：备案号
	 */
	public void setBaknum(String baknum) {
		this.baknum = baknum;
	}
	/**
	 * 获取：备案号
	 */
	public String getBaknum() {
		return baknum;
	}
	/**
	 * 设置：版权
	 */
	public void setVersions(String versions) {
		this.versions = versions;
	}
	/**
	 * 获取：版权
	 */
	public String getVersions() {
		return versions;
	}
}
