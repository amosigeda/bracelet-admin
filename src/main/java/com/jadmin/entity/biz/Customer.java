package com.jadmin.entity.biz;

import com.jadmin.util.Tools;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * C端用户对象
 */
@SuppressWarnings("serial")
public class Customer implements Serializable{
	
	private Integer userId;
	private String username;
	private String password;
	private String avatar;
	private String nickname;
	private Integer sex;
	private String weight;
	private String height;
	private String address;
	private String dv;
	private String sd;
	private String imei;
	private Timestamp createtime;
	private Timestamp bindingtime;
	
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the dv
	 */
	public String getDv() {
		return dv;
	}
	/**
	 * @param dv the dv to set
	 */
	public void setDv(String dv) {
		this.dv = dv;
	}
	/**
	 * @return the sd
	 */
	public String getSd() {
		return sd;
	}
	/**
	 * @param sd the sd to set
	 */
	public void setSd(String sd) {
		this.sd = sd;
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
	/**
	 * @return the bindingtime
	 */
	public Timestamp getBindingtime() {
		return bindingtime;
	}
	/**
	 * @param bindingtime the bindingtime to set
	 */
	public void setBindingtime(Timestamp bindingtime) {
		this.bindingtime = bindingtime;
	}

	public String getCreatetimeStr() {
		return Tools.date2Str(this.createtime);
	}
	
	public String getBindingtimeStr() {
		return Tools.date2Str(this.bindingtime);
	}
	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}
	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * @return the sex
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}
	/**
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
}
