package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 装修审核对象 hy_fitment_audit
 * 
 * @author Administrator
 * @date 2021-04-13
 */
public class HyFitmentAudit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 装修审核id */
    private Long id;

    /** 实地审核图片地址 */
    @Excel(name = "实地审核图片地址")
    private String  pictureAddress;

    /** 是否同意 */
    @Excel(name = "是否同意")
    private Integer fitmentAuditAgree;

    /** 房屋id */
    @Excel(name = "房屋id")
    private Long houseInfId;
    
    /** 房屋表 */
    @Excel(name = "房屋表")
    private HyHouseInf hyHouseInf;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPictureAddress(String  pictureAddress) 
    {
        this. pictureAddress =  pictureAddress;
    }

    public String getPictureAddress() 
    {
        return  pictureAddress;
    }
    public void setFitmentAuditAgree(Integer fitmentAuditAgree) 
    {
        this.fitmentAuditAgree = fitmentAuditAgree;
    }

    public Integer getFitmentAuditAgree() 
    {
        return fitmentAuditAgree;
    }
    public void setHouseInfId(Long houseInfId) 
    {
        this.houseInfId = houseInfId;
    }

    public Long getHouseInfId() 
    {
        return houseInfId;
    }

    public HyHouseInf getHyHouseInf() {
		return hyHouseInf;
	}

	public void setHyHouseInf(HyHouseInf hyHouseInf) {
		this.hyHouseInf = hyHouseInf;
	}

	@Override
	public String toString() {
		return "HyFitmentAudit [id=" + id + ", pictureAddress=" + pictureAddress + ", fitmentAuditAgree="
				+ fitmentAuditAgree + ", houseInfId=" + houseInfId + ", hyHouseInf=" + hyHouseInf + "]";
	}

	
}
