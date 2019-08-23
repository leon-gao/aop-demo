package com.gaolong.working.beans;

import java.util.Date;

/**
 * @auther: liangyy
 * @className: BaseModel
 * @date: 2018-10-21 00:07
 * @since: 1.0-SNAPSHOT
 */
public class BaseBean {

    protected Short dataStatus; // 数据状态：1：有效  0：无效

    protected Date createTime; // 创建时间

    protected Date updateTime; // 更新时间

    public Short getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Short dataStatus) {
        this.dataStatus = dataStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
