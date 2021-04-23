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

    /** 物料id */
    @Excel(name = "物料id")
    private Long materialId;
    
    /** 物料表 */
    @Excel(name = "物料表")
    private HyMaterial hyMaterial;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public Long getMaterialNumber() {
		return materialNumber;
	}

	public void setMaterialNumber(Long materialNumber) {
		this.materialNumber = materialNumber;
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
    public Long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}

	public HyMaterial getHyMaterial() {
		return hyMaterial;
	}

	public void setHyMaterial(HyMaterial hyMaterial) {
		this.hyMaterial = hyMaterial;
	}

	@Override
	public String toString() {
		return "HyLifting [id=" + id + ", materialNumber=" + materialNumber + ", materialUse=" + materialUse
				+ ", isreturn=" + isreturn + ", depts=" + depts + ", proposer=" + proposer + ", materialId="
				+ materialId + ", hyMaterial=" + hyMaterial + "]";
	}

	


	

	

    
}
