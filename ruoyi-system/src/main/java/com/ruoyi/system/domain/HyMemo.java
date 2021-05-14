package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * 设备维修保养备忘录对象 hy_memo
 * 
 * @author Administrator
 * @date 2021-05-13
 */
public class HyMemo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备维修保养备忘录id */
    private Long id;

    /** 备忘录号 */
    @Excel(name = "备忘录号")
    private Long memoNo;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date memoDate;

    /** 内容 */
    @Excel(name = "内容")
    private String memoContent;

    /** 设备档案id */
    @Excel(name = "设备档案id")
    private Long archivesId;
    
    /** 设备档案表 */
    @Excel(name = "设备档案表")
    private HyEquipmentArchives hyEquipmentArchives;

    /** 设备类别id */
    @Excel(name = "设备类别id")
    private Long equipmentId;
    
    /** 设备类别表 */
    @Excel(name = "设备类别表")
    private HyEquipment hyEquipment;

    /** 员工id */
    @Excel(name = "员工id")
    private Long userId;
    
    /** 员工表 */
    @Excel(name = "员工表")
    private SysUser sysUser;

    /** 部门id */
    @Excel(name = "部门id")
    private Long deptId;
    
    /** 部门表 */
    @Excel(name = "部门表")
    private SysDept sysDept;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMemoNo(Long memoNo) 
    {
        this.memoNo = memoNo;
    }

    public Long getMemoNo() 
    {
        return memoNo;
    }
    public void setMemoDate(Date memoDate) 
    {
        this.memoDate = memoDate;
    }

    public Date getMemoDate() 
    {
        return memoDate;
    }
    public void setMemoContent(String memoContent) 
    {
        this.memoContent = memoContent;
    }

    public String getMemoContent() 
    {
        return memoContent;
    }
    public void setArchivesId(Long archivesId) 
    {
        this.archivesId = archivesId;
    }

    public Long getArchivesId() 
    {
        return archivesId;
    }
    public void setEquipmentId(Long equipmentId) 
    {
        this.equipmentId = equipmentId;
    }

    public Long getEquipmentId() 
    {
        return equipmentId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }

    public HyEquipmentArchives getHyEquipmentArchives() {
		return hyEquipmentArchives;
	}

	public void setHyEquipmentArchives(HyEquipmentArchives hyEquipmentArchives) {
		this.hyEquipmentArchives = hyEquipmentArchives;
	}

	public HyEquipment getHyEquipment() {
		return hyEquipment;
	}

	public void setHyEquipment(HyEquipment hyEquipment) {
		this.hyEquipment = hyEquipment;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public SysDept getSysDept() {
		return sysDept;
	}

	public void setSysDept(SysDept sysDept) {
		this.sysDept = sysDept;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("memoNo", getMemoNo())
            .append("memoDate", getMemoDate())
            .append("memoContent", getMemoContent())
            .append("archivesId", getArchivesId())
            .append("equipmentId", getEquipmentId())
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .append("hyEquipmentArchives", getHyEquipmentArchives())
            .append("hyEquipment", getHyEquipment())
            .append("sysUser", getSysUser())
            .append("sysDept", getSysDept())
            .toString();
    }
}
