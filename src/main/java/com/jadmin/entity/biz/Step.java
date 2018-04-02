package com.jadmin.entity.biz;

import com.jadmin.util.Tools;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 步数
 */
@SuppressWarnings("serial")
public class Step implements Serializable{
	
	private Integer id;
	private Integer userId;
	private String imei;
	private Integer stepNumber;
	private Timestamp createtime;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @return the imei
	 */
	public String getImei() {
		return imei;
	}
	/**
	 * @param imei the imei to set
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}
	/**
	 * @return the stepNumber
	 */
	public Integer getStepNumber() {
		return stepNumber;
	}
	/**
	 * @param stepNumber the stepNumber to set
	 */
	public void setStepNumber(Integer stepNumber) {
		this.stepNumber = stepNumber;
	}
	/**
	 * @return the createtime
	 */
	public Timestamp getCreatetime() {
		return createtime;
	}
	/**
	 * @param createtime the createtime to set
	 */
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getCreatetimeStr() {
		return Tools.date2Str(this.createtime);
	}
	
}
