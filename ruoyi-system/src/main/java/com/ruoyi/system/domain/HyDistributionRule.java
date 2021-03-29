package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 分销规则对象 hy_distribution_rule
 * 
 * @author Administrator
 * @date 2021-03-29
 */
public class HyDistributionRule extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 分销规则id */
    private Long id;

    /** 一级固定金额 */
    @Excel(name = "一级固定金额")
    private String commissionFromSuperior;

    /** 二级固定金额 */
    @Excel(name = "二级固定金额")
    private String topCommission;

    /** 产品id */
    @Excel(name = "产品id")
    private Long productId;

    /** 三级固定金额 */
    @Excel(name = "三级固定金额")
    private String threeLevelDistribution;

    /** 是否开启分销 */
    @Excel(name = "是否开启分销")
    private Integer startDistribution;

    /** 分销类型 */
    @Excel(name = "分销类型")
    private String distributionType;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCommissionFromSuperior(String commissionFromSuperior) 
    {
        this.commissionFromSuperior = commissionFromSuperior;
    }

    public String getCommissionFromSuperior() 
    {
        return commissionFromSuperior;
    }
    public void setTopCommission(String topCommission) 
    {
        this.topCommission = topCommission;
    }

    public String getTopCommission() 
    {
        return topCommission;
    }
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setThreeLevelDistribution(String threeLevelDistribution) 
    {
        this.threeLevelDistribution = threeLevelDistribution;
    }

    public String getThreeLevelDistribution() 
    {
        return threeLevelDistribution;
    }
    public void setStartDistribution(Integer startDistribution) 
    {
        this.startDistribution = startDistribution;
    }

    public Integer getStartDistribution() 
    {
        return startDistribution;
    }
    public void setDistributionType(String distributionType) 
    {
        this.distributionType = distributionType;
    }

    public String getDistributionType() 
    {
        return distributionType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("commissionFromSuperior", getCommissionFromSuperior())
            .append("topCommission", getTopCommission())
            .append("productId", getProductId())
            .append("threeLevelDistribution", getThreeLevelDistribution())
            .append("startDistribution", getStartDistribution())
            .append("distributionType", getDistributionType())
            .toString();
    }
}
