package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 装修管理对象 hy_fitment_manage
 * 
 * @author Administrator
 * @date 2021-04-13
 */
public class HyFitmentManage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 装修管理id */
    private Long id;

    /** 装修状态 */
    @Excel(name = "装修状态")
    private String fitmentManageState;

    /** 装修描述 */
    @Excel(name = "装修描述")
    private String fitmentManageContent;

    /** 预期工期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预期工期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fitmentManageExpect;

    /** 业主id */
    @Excel(name = "业主id")
    private Long ownerRegistrationId;
    
    /** 业主表 */
    @Excel(name = "业主表")
    private HyOwnerRegistration hyOwnerRegistration;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFitmentManageState(String fitmentManageState) 
    {
        this.fitmentManageState = fitmentManageState;
    }

    public String getFitmentManageState() 
    {
        return fitmentManageState;
    }
    public void setFitmentManageContent(String fitmentManageContent) 
    {
        this.fitmentManageContent = fitmentManageContent;
    }

    public String getFitmentManageContent() 
    {
        return fitmentManageContent;
    }
    public void setFitmentManageExpect(Date fitmentManageExpect) 
    {
        this.fitmentManageExpect = fitmentManageExpect;
    }

    public Date getFitmentManageExpect() 
    {
        return fitmentManageExpect;
    }
    public void setOwnerRegistrationId(Long ownerRegistrationId) 
    {
        this.ownerRegistrationId = ownerRegistrationId;
    }

    public Long getOwnerRegistrationId() 
    {
        return ownerRegistrationId;
    }

    public HyOwnerRegistration getHyOwnerRegistration() {
		return hyOwnerRegistration;
	}

	public void setHyOwnerRegistration(HyOwnerRegistration hyOwnerRegistration) {
		this.hyOwnerRegistration = hyOwnerRegistration;
	}

	@Override
	public String toString() {
		return "HyFitmentManage [id=" + id + ", fitmentManageState=" + fitmentManageState + ", fitmentManageContent="
				+ fitmentManageContent + ", fitmentManageExpect=" + fitmentManageExpect + ", ownerRegistrationId="
				+ ownerRegistrationId + ", hyOwnerRegistration=" + hyOwnerRegistration + "]";
	}

	
}
