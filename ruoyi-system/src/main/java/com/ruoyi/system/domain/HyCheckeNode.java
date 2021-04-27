package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysDept;

/**
 * 巡检节点对象 hy_checke_node
 * 
 * @author Administrator
 * @date 2021-04-25
 */
public class HyCheckeNode extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 巡检节点id */
    private Long id;

    /** 巡检节点名称 */
    @Excel(name = "巡检节点名称")
    private String name;

    /** 巡检节点地址 */
    @Excel(name = "巡检节点地址")
    private String address;

    /** 扫描码 */
    @Excel(name = "扫描码")
    private String scanCode;

    /** 经度 */
    @Excel(name = "经度")
    private String longitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private String latitude;

    /** 组织机构id */
    @Excel(name = "组织机构id")
    private Long deptId;
    
    /** 组织机构表 */
    @Excel(name = "组织机构表")
    private SysDept sysDept;

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
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setScanCode(String scanCode) 
    {
        this.scanCode = scanCode;
    }

    public String getScanCode() 
    {
        return scanCode;
    }
    public void setLongitude(String longitude) 
    {
        this.longitude = longitude;
    }

    public String getLongitude() 
    {
        return longitude;
    }
    public void setLatitude(String latitude) 
    {
        this.latitude = latitude;
    }

    public String getLatitude() 
    {
        return latitude;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }

    public SysDept getSysDept() {
		return sysDept;
	}

	public void setSysDept(SysDept sysDept) {
		this.sysDept = sysDept;
	}

	@Override
	public String toString() {
		return "HyCheckeNode [id=" + id + ", name=" + name + ", address=" + address + ", scanCode=" + scanCode
				+ ", longitude=" + longitude + ", latitude=" + latitude + ", deptId=" + deptId + ", sysDept=" + sysDept
				+ "]";
	}

}
