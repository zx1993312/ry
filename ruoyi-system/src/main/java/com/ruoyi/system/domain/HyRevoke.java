package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 撤销操作对象 hy_revoke
 * 
 * @author Administrator
 * @date 2021-01-26
 */
public class HyRevoke extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 房屋编号 */
    @Excel(name = "房屋编号")
    private String houseNum;

    /** 撤销时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "撤销时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date revokeDate;

    /** 撤销原因 */
    @Excel(name = "撤销原因")
    private String revokeReason;
    
    /** 备注 */
    @Excel(name = "备注")
    private String revokeRemark;
    
    /** 票据id */
    @Excel(name = "票据id")
    private Long setId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setHouseNum(String houseNum) 
    {
        this.houseNum = houseNum;
    }

    public String getHouseNum() 
    {
        return houseNum;
    }
    public void setRevokeDate(Date revokeDate) 
    {
        this.revokeDate = revokeDate;
    }

    public Date getRevokeDate() 
    {
        return revokeDate;
    }
    public void setRevokeReason(String revokeReason) 
    {
        this.revokeReason = revokeReason;
    }

    public String getRevokeReason() 
    {
        return revokeReason;
    }

    public String getRevokeRemark() {
		return revokeRemark;
	}

	public void setRevokeRemark(String revokeRemark) {
		this.revokeRemark = revokeRemark;
	}

	public Long getSetId() {
		return setId;
	}

	public void setSetId(Long setId) {
		this.setId = setId;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("houseNum", getHouseNum())
            .append("revokeDate", getRevokeDate())
            .append("revokeReason", getRevokeReason())
            .append("revokeRemark", getRevokeRemark())
            .append("setId", getSetId())
            .toString();
    }
}
