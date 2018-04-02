package com.jadmin.entity.biz;

import com.jadmin.util.Tools;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 脉搏
 */
@SuppressWarnings("serial")
public class HeartRate implements Serializable{
	
	private Integer id;
	private Integer heartRate;
	private Integer userId;
	private String imei;
	private Timestamp uploadTime;
	
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
	 * @return the heartRate
	 */
	public Integer getHeartRate() {
		return heartRate;
	}
	/**
	 * @param heartRate the heartRate to set
	 */
	public void setHeartRate(Integer heartRate) {
		this.heartRate = heartRate;
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
