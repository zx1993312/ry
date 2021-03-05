package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商家对象 hy_business
 * 
 * @author Administrator
 * @date 2021-03-05
 */
public class HyBusiness extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商家id */
    private Long id;

    /** 商家名称 */
    @Excel(name = "商家名称")
    private String businessName;

    /** 法人代表 */
    @Excel(name = "法人代表")
    private String legalRepresentative;

    /** 法人代表电话 */
    @Excel(name = "法人代表电话")
    private Long legalTelphone;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private Long idCard;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String eMail;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBusinessName(String businessName) 
    {
        this.businessName = businessName;
    }

    public String getBusinessName() 
    {
        return businessName;
    }
    public void setLegalRepresentative(String legalRepresentative) 
    {
        this.legalRepresentative = legalRepresentative;
    }

    public String getLegalRepresentative() 
    {
        return legalRepresentative;
    }
    public void setLegalTelphone(Long legalTelphone) 
    {
        this.legalTelphone = legalTelphone;
    }

    public Long getLegalTelphone() 
    {
        return legalTelphone;
    }
    public void setIdCard(Long idCard) 
    {
        this.idCard = idCard;
    }

    public Long getIdCard() 
    {
        return idCard;
    }
    public void seteMail(String eMail) 
    {
        this.eMail = eMail;
    }

    public String geteMail() 
    {
        return eMail;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("businessName", getBusinessName())
            .append("legalRepresentative", getLegalRepresentative())
            .append("legalTelphone", getLegalTelphone())
            .append("idCard", getIdCard())
            .append("eMail", geteMail())
            .toString();
    }
}
