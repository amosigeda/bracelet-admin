package com.jadmin.entity.system;

import java.io.Serializable;

/**
 * 增删改查权限表
 */
@SuppressWarnings("serial")
public class Permission implements Serializable{
	
    private Integer permId;

    private String permName;

    private String permission;

    private String permDesc;

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName == null ? null : permName.trim();
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public String getPermDesc() {
        return permDesc;
    }

    public void setPermDesc(String permDesc) {
        this.permDesc = permDesc == null ? null : permDesc.trim();
    }
}