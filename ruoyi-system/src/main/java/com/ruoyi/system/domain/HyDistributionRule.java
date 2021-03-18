package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 分销规则对象 hy_distribution_rule
 * 
 * @author Administrator
 * @date 2021-03-09
 */
public class HyDistributionRule extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 分销规则id */
    private Long id;

    /** 销售额 */
    @Excel(name = "销售额")
    private String salesVolume;

    /** 上级提成 */
    @Excel(name = "上级提成")
    private String commissionFromSuperior;

    /** 顶级提成 */
    @Excel(name = "顶级提成")
    private String topCommission;

    /** 分销id */
    @Excel(name = "分销id")
    private Long distributionId;
    /**是否开启分销*/
    @Excel(name="是否开启分销")
    private String startDistribution;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSalesVolume(String salesVolume) 
    {
        this.salesVolume = salesVolume;
    }

    public String getSalesVolume() 
    {
        return salesVolume;
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
    public void setDistributionId(Long distributionId) 
    {
        this.distributionId = distributionId;
    }

    public Long getDistributionId() 
    {
        return distributionId;
    }

    public String getStartDistribution() {
		return startDistribution;
	}

	public void setStartDistribution(String startDistribution) {
		this.startDistribution = startDistribution;
	}

	@Override
	public String toString() {
		return "HyDistributionRule [id=" + id + ", salesVolume=" + salesVolume + ", commissionFromSuperior="
				+ commissionFromSuperior + ", topCommission=" + topCommission + ", distributionId=" + distributionId
				+ ", startDistribution=" + startDistribution + ", getId()=" + getId() + ", getSalesVolume()="
				+ getSalesVolume() + ", getCommissionFromSuperior()=" + getCommissionFromSuperior()
				+ ", getTopCommission()=" + getTopCommission() + ", getDistributionId()=" + getDistributionId()
				+ ", getStartDistribution()=" + getStartDistribution() + ", getSearchValue()=" + getSearchValue()
				+ ", getCreateBy()=" + getCreateBy() + ", getCreateTime()=" + getCreateTime() + ", getUpdateBy()="
				+ getUpdateBy() + ", getUpdateTime()=" + getUpdateTime() + ", getRemark()=" + getRemark()
				+ ", getParams()=" + getParams() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


}
