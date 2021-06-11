package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 供应商对象 hy_supplier
 * 
 * @author Administrator
 * @date 2021-06-11
 */
public class HySupplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;

    /** 供应商营业执照 */
    @Excel(name = "供应商营业执照")
    private String supplierBusinessLicence;

    /** 供应商负责人 */
    @Excel(name = "供应商负责人")
    private String supplierCharge;

    /** 供应商联系电话 */
    @Excel(name = "供应商联系电话")
    private String supplierPhone;

    /** 供应商电子邮箱 */
    @Excel(name = "供应商电子邮箱")
    private String supplierEmail;

    /** 供应商地址 */
    @Excel(name = "供应商地址")
    private String supplierAddress;

    /** 成立日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "成立日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date incorporationDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
    }
    public void setSupplierBusinessLicence(String supplierBusinessLicence) 
    {
        this.supplierBusinessLicence = supplierBusinessLicence;
    }

    public String getSupplierBusinessLicence() 
    {
        return supplierBusinessLicence;
    }
    public void setSupplierCharge(String supplierCharge) 
    {
        this.supplierCharge = supplierCharge;
    }

    public String getSupplierCharge() 
    {
        return supplierCharge;
    }
    public void setSupplierPhone(String supplierPhone) 
    {
        this.supplierPhone = supplierPhone;
    }

    public String getSupplierPhone() 
    {
        return supplierPhone;
    }
    public void setSupplierEmail(String supplierEmail) 
    {
        this.supplierEmail = supplierEmail;
    }

    public String getSupplierEmail() 
    {
        return supplierEmail;
    }
    public void setSupplierAddress(String supplierAddress) 
    {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierAddress() 
    {
        return supplierAddress;
    }
    public void setIncorporationDate(Date incorporationDate) 
    {
        this.incorporationDate = incorporationDate;
    }

    public Date getIncorporationDate() 
    {
        return incorporationDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("supplierName", getSupplierName())
            .append("supplierBusinessLicence", getSupplierBusinessLicence())
            .append("supplierCharge", getSupplierCharge())
            .append("supplierPhone", getSupplierPhone())
            .append("supplierEmail", getSupplierEmail())
            .append("supplierAddress", getSupplierAddress())
            .append("incorporationDate", getIncorporationDate())
            .toString();
    }
}
