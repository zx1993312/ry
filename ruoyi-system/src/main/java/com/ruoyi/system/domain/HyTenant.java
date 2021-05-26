package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 租户资料登记对象 hy_tenant
 * 
 * @author Administrator
 * @date 2021-05-25
 */
public class HyTenant extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 租户id */
    private Long id;

    /** 租户名称 */
    @Excel(name = "租户名称")
    private String tenantName;

    /** 固定电话 */
    @Excel(name = "固定电话")
    private String tenantTelephone;

    /** 移动电话 */
    @Excel(name = "移动电话")
    private String tenantPhone;

    /** 证件号码 */
    @Excel(name = "证件号码")
    private String idCardNum;

    /** 联系地址 */
    @Excel(name = "联系地址")
    private String tenantAddress;

    /** 性别 */
    @Excel(name = "性别")
    private Integer tenantSex;
    
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
    public void setTenantName(String tenantName) 
    {
        this.tenantName = tenantName;
    }

    public String getTenantName() 
    {
        return tenantName;
    }
    public void setTenantTelephone(String tenantTelephone) 
    {
        this.tenantTelephone = tenantTelephone;
    }

    public String getTenantTelephone() 
    {
        return tenantTelephone;
    }
    public void setTenantPhone(String tenantPhone) 
    {
        this.tenantPhone = tenantPhone;
    }

    public String getTenantPhone() 
    {
        return tenantPhone;
    }
    public void setIdCardNum(String idCardNum) 
    {
        this.idCardNum = idCardNum;
    }

    public String getIdCardNum() 
    {
        return idCardNum;
    }
    public void setTenantAddress(String tenantAddress) 
    {
        this.tenantAddress = tenantAddress;
    }

    public String getTenantAddress() 
    {
        return tenantAddress;
    }
    public void setTenantSex(Integer tenantSex) 
    {
        this.tenantSex = tenantSex;
    }

    public Integer getTenantSex() 
    {
        return tenantSex;
    }

    public HyHouseInf getHyHouseInf() {
		return hyHouseInf;
	}

	public void setHyHouseInf(HyHouseInf hyHouseInf) {
		this.hyHouseInf = hyHouseInf;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("tenantName", getTenantName())
            .append("tenantTelephone", getTenantTelephone())
            .append("tenantPhone", getTenantPhone())
            .append("idCardNum", getIdCardNum())
            .append("tenantAddress", getTenantAddress())
            .append("tenantSex", getTenantSex())
            .append("hyHouseInf", getHyHouseInf())
            .toString();
    }
}
