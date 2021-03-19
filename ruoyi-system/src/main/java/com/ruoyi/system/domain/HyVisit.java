package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 访客对象 hy_visit
 * 
 * @author Administrator
 * @date 2021-03-18
 */
public class HyVisit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 访客id */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 电话号 */
    @Excel(name = "电话号")
    private String telphone;

    /** 申请地址 */
    @Excel(name = "申请地址")
    private String applicationAddress;

    /** 申请时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applicationTime;

    /** 有效时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "有效时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date effectiveTime;

    /** 有效天数 */
    @Excel(name = "有效天数")
    private String effectiveDay;

    /** 小区id */
    @Excel(name = "小区id")
    private Long residentialQuartersId;
    
    /** 小区表*/
    @Excel(name = "小区表")
    private HyResidentialQuarters hyResidentialQuarters;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setTelphone(String telphone) 
    {
        this.telphone = telphone;
    }

    public String getTelphone() 
    {
        return telphone;
    }
    public void setApplicationAddress(String applicationAddress) 
    {
        this.applicationAddress = applicationAddress;
    }

    public String getApplicationAddress() 
    {
        return applicationAddress;
    }
    public void setApplicationTime(Date applicationTime) 
    {
        this.applicationTime = applicationTime;
    }

    public Date getApplicationTime() 
    {
        return applicationTime;
    }
    public void setEffectiveTime(Date effectiveTime) 
    {
        this.effectiveTime = effectiveTime;
    }

    public Date getEffectiveTime() 
    {
        return effectiveTime;
    }
    public void setEffectiveDay(String effectiveDay) 
    {
        this.effectiveDay = effectiveDay;
    }

    public String getEffectiveDay() 
    {
        return effectiveDay;
    }
    public void setResidentialQuartersId(Long residentialQuartersId) 
    {
        this.residentialQuartersId = residentialQuartersId;
    }

    public Long getResidentialQuartersId() 
    {
        return residentialQuartersId;
    }

    
    
    public HyResidentialQuarters getHyResidentialQuarters() {
		return hyResidentialQuarters;
	}

	public void setHyResidentialQuarters(HyResidentialQuarters hyResidentialQuarters) {
		this.hyResidentialQuarters = hyResidentialQuarters;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("telphone", getTelphone())
            .append("applicationAddress", getApplicationAddress())
            .append("applicationTime", getApplicationTime())
            .append("effectiveTime", getEffectiveTime())
            .append("effectiveDay", getEffectiveDay())
            .append("residentialQuartersId", getResidentialQuartersId())
            .toString();
    }
}
