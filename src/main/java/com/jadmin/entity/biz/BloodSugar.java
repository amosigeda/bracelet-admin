package com.jadmin.entity.biz;

import com.jadmin.util.Tools;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 电量
 */
@SuppressWarnings("serial")
public class BloodSugar implements Serializable{
	
	private Integer id;
	private Integer bloodSugar;
	private Integer userId;
	private Timestamp uploadTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBloodSugar() {
		return bloodSugar;
	}
	public void setBloodSugar(Integer bloodSugar) {
		this.bloodSugar = bloodSugar;
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
	 * @return the uploadTime
	 */
	public Timestamp getUploadTime() {
		return uploadTime;
	}
	/**
	 * @param uploadTime the uploadTime to set
	 */
	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getUploadTimeStr() {
		return Tools.date2Str(this.uploadTime);
	}
	
}
