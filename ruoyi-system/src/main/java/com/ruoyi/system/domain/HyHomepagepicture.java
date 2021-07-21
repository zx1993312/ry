package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 首页轮播图对象 hy_homepagepicture
 * 
 * @author Administrator
 * @date 2021-07-21
 */
public class HyHomepagepicture extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 首页轮播图id */
    private Long id;

    /** 图片 */
    @Excel(name = "图片")
    private String picture;

    /** 状态 */
    @Excel(name = "状态")
    private String state;
    
    /** 权重 */
    @Excel(name = "权重")
    private Long orderBy;

    /** 上线时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上线时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date onlineTime;

    /** 下线时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下线时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date logoutTime;
    
    /** 删除图片 */
    private String deleteFile;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPicture(String picture) 
    {
        this.picture = picture;
    }

    public String getPicture() 
    {
        return picture;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setOrderBy(Long orderBy) 
    {
        this.orderBy = orderBy;
    }

    public Long getOrderBy() 
    {
        return orderBy;
    }
    public void setOnlineTime(Date onlineTime) 
    {
        this.onlineTime = onlineTime;
    }

    public Date getOnlineTime() 
    {
        return onlineTime;
    }
    public void setLogoutTime(Date logoutTime) 
    {
        this.logoutTime = logoutTime;
    }

    public Date getLogoutTime() 
    {
        return logoutTime;
    }

    public String getDeleteFile() {
		return deleteFile;
	}

	public void setDeleteFile(String deleteFile) {
		this.deleteFile = deleteFile;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("picture", getPicture())
            .append("state", getState())
            .append("orderBy", getOrderBy())
            .append("onlineTime", getOnlineTime())
            .append("logoutTime", getLogoutTime())
            .append("createTime", getCreateTime())
            .append("deleteFile", getDeleteFile())
            .toString();
    }
}
