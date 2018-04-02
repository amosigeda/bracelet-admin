package com.jadmin.entity.biz;

import com.jadmin.util.Tools;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 短信发送记录
 */
@SuppressWarnings("serial")
public class Smslog implements Serializable{
	
	private Integer id;
	private String name;
	private String mobile;
	private String tplCode;
	private String tplParam;
	private Integer rstatus;
	private String rmsg;
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
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the tplCode
	 */
	public String getTplCode() {
		return tplCode;
	}
	/**
	 * @param tplCode the tplCode to set
	 */
	public void setTplCode(String tplCode) {
		this.tplCode = tplCode;
	}
	/**
	 * @return the tplParam
	 */
	public String getTplParam() {
		return tplParam;
	}
	/**
	 * @param tplParam the tplParam to set
	 */
	public void setTplParam(String tplParam) {
		this.tplParam = tplParam;
	}
	/**
	 * @return the rstatus
	 */
	public Integer getRstatus() {
		return rstatus;
	}
	/**
	 * @param rstatus the rstatus to set
	 */
	public void setRstatus(Integer rstatus) {
		this.rstatus = rstatus;
	}
	/**
	 * @return the rmsg
	 */
	public String getRmsg() {
		return rmsg;
	}
	/**
	 * @param rmsg the rmsg to set
	 */
	public void setRmsg(String rmsg) {
		this.rmsg = rmsg;
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
