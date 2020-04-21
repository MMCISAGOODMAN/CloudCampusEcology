package com.service.thirdparty.model;

import java.util.Date;

public class ThirdpartyDeviceChangelog {
    private String id;

    private String deviceId;

    private String changeType;

    private String changeBefore;

    private String changeAfter;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType == null ? null : changeType.trim();
    }

    public String getChangeBefore() {
        return changeBefore;
    }

    public void setChangeBefore(String changeBefore) {
        this.changeBefore = changeBefore == null ? null : changeBefore.trim();
    }

    public String getChangeAfter() {
        return changeAfter;
    }

    public void setChangeAfter(String changeAfter) {
        this.changeAfter = changeAfter == null ? null : changeAfter.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}