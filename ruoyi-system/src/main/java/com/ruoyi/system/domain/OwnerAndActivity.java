package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 业主活动中间对象 owner_and_activity
 * 
 * @author Administrator
 * @date 2021-07-14
 */
public class OwnerAndActivity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 活动id */
    @Excel(name = "活动id")
    private Long activityId;

    /** 业主id */
    @Excel(name = "业主id")
    private Long ownerId;

    public void setActivityId(Long activityId) 
    {
        this.activityId = activityId;
    }

    public Long getActivityId() 
    {
        return activityId;
    }
    public void setOwnerId(Long ownerId) 
    {
        this.ownerId = ownerId;
    }

    public Long getOwnerId() 
    {
        return ownerId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("activityId", getActivityId())
            .append("ownerId", getOwnerId())
            .toString();
    }
}