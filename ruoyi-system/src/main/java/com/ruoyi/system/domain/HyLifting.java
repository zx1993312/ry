package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 提料人对象 hy_lifting
 * 
 * @author Administrator
 * @date 2021-04-20
 */
public class HyLifting extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 提料人id */
    private Long id;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String materialName;

    /** 物料类型 */
    @Excel(name = "物料类型")
    private String materialType;

    /** 需求数量 */
    @Excel(name = "需求数量")
    private Long materialNumber;

    /** 物料用途 */
    @Excel(name = "物料用途")
    private String materialUse;

    /** 是否归还 */
    @Excel(name = "是否归还")
    private String isreturn;

    /** 申请部门 */
    @Excel(name = "申请部门")
    private String depts;

    /** 申请人 */
    @Excel(name = "申请人")
    private String proposer;

    /** 审核单位 */
    @Excel(name = "审核单位")
    private String unit;

    /** 审核人 */
    @Excel(name = "审核人")
    private String auditor;
    
    /** 审核状态 */
    @Excel(name = "审核状态")
    private String state;

    /** 盘点员 */
    @Excel(name = "盘点员")
    private String checkName;

    /** 物料列表id */
    @Excel(name = "物料列表id")
    private Long billId;

    /** 接收员id */
    @Excel(name = "接收员id")
    private Long specimenId;

    /** 盘点员id */
    @Excel(name = "盘点员id")
    private Long checkId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMaterialName(String materialName) 
    {
        this.materialName = materialName;
    }

    public String getMaterialName() 
    {
        return materialName;
    }
    public void setMaterialType(String materialType) 
    {
        this.materialType = materialType;
    }

    public String getMaterialType() 
    {
        return materialType;
    }
    public void setMaterialNumber(Long materialNumber) 
    {
        this.materialNumber = materialNumber;
    }

    public Long getMaterialNumber() 
    {
        return materialNumber;
    }
    public void setMaterialUse(String materialUse) 
    {
        this.materialUse = materialUse;
    }

    public String getMaterialUse() 
    {
        return materialUse;
    }
    public void setIsreturn(String isreturn) 
    {
        this.isreturn = isreturn;
    }

    public String getIsreturn() 
    {
        return isreturn;
    }
    public void setDepts(String depts) 
    {
        this.depts = depts;
    }

    public String getDepts() 
    {
        return depts;
    }
    public void setProposer(String proposer) 
    {
        this.proposer = proposer;
    }

    public String getProposer() 
    {
        return proposer;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setAuditor(String auditor) 
    {
        this.auditor = auditor;
    }

    public String getAuditor() 
    {
        return auditor;
    }
    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCheckName(String checkName) 
    {
        this.checkName = checkName;
    }

    public String getCheckName() 
    {
        return checkName;
    }
    public void setBillId(Long billId) 
    {
        this.billId = billId;
    }

    public Long getBillId() 
    {
        return billId;
    }
    public void setSpecimenId(Long specimenId) 
    {
        this.specimenId = specimenId;
    }

    public Long getSpecimenId() 
    {
        return specimenId;
    }
    public void setCheckId(Long checkId) 
    {
        this.checkId = checkId;
    }

    public Long getCheckId() 
    {
        return checkId;
    }

	@Override
	public String toString() {
		return "HyLifting [id=" + id + ", materialName=" + materialName + ", materialType=" + materialType
				+ ", materialNumber=" + materialNumber + ", materialUse=" + materialUse + ", isreturn=" + isreturn
				+ ", depts=" + depts + ", proposer=" + proposer + ", unit=" + unit + ", auditor=" + auditor + ", state="
				+ state + ", checkName=" + checkName + ", billId=" + billId + ", specimenId=" + specimenId
				+ ", checkId=" + checkId + "]";
	}

    
}
