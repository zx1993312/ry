package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 分销对象 hy_distribution
 * 
 * @author Administrator
 * @date 2021-03-09
 */
public class HyDistribution extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 分销id */
    private Long id;

    /** 上级分销id */
    @Excel(name = "上级分销id")
    private Long distributionId;

    /** 销售额 */
    @Excel(name = "销售额")
    private String salesVolume;

    /** 提成 */
    @Excel(name = "提成")
    private String commission;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDistributionId(Long distributionId) 
    {
        this.distributionId = distributionId;
    }

    public Long getDistributionId() 
    {
        return distributionId;
    }
    public void setSalesVolume(String salesVolume) 
    {
        this.salesVolume = salesVolume;
    }

    public String getSalesVolume() 
    {
        return salesVolume;
    }
    public void setCommission(String commission) 
    {
        this.commission = commission;
    }

    public String getCommission() 
    {
        return commission;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("distributionId", getDistributionId())
            .append("salesVolume", getSalesVolume())
            .append("commission", getCommission())
            .append("userId", getUserId())
            .toString();
    }
}
