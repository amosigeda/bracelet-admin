package com.jadmin.entity.biz;

import com.jadmin.util.Tools;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 系统配置
 */
@SuppressWarnings("serial")
public class Sys implements Serializable{
	
	private Integer id;
	private String serviceContent;
	private Timestamp createtime;
	private Timestamp updatetime;

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
	 * @return the serviceContent
	 */
	public String getServiceContent() {
		return serviceContent;
	}
	/**
	 * @param serviceContent the serviceContent to set
	 */
	public void setServiceContent(String serviceContent) {
		this.serviceContent = serviceContent;
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
	 * @return the updatetime
	 */
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	/**
	 * @param updatetime the updatetime to set
	 */
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getCreatetimeStr() {
		return Tools.date2Str(this.createtime);
	}

	public String getUpdatetimeStr() {
		return Tools.date2Str(this.updatetime);
	}
	
}
