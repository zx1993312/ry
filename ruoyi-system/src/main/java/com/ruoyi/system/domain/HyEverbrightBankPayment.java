package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 光大银行支付对象 hy_everbright_bank_payment
 * 
 * @author Administrator
 * @date 2021-03-19
 */
public class HyEverbrightBankPayment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 渠道标识id */
    private Long id;

    /** 渠道标识 */
    @Excel(name = "渠道标识")
    private String channelIdentification;

    /** 业务代码（项目编号） */
    @Excel(name = "业务代码", readConverterExp = "项=目编号")
    private String businessCode;

    /** 密钥 */
    @Excel(name = "密钥")
    private String secretKey;

    /** 基础链接 */
    @Excel(name = "基础链接")
    private String basicLinks;

    /** 小区id */
    @Excel(name = "小区id")
    private Long residentialQuartersId;
    
    /** 小区表 */
    @Excel(name = "小区表")
    private HyResidentialQuarters hyResidentialQuarters;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setChannelIdentification(String channelIdentification) 
    {
        this.channelIdentification = channelIdentification;
    }

    public String getChannelIdentification() 
    {
        return channelIdentification;
    }
    public void setBusinessCode(String businessCode) 
    {
        this.businessCode = businessCode;
    }

    public String getBusinessCode() 
    {
        return businessCode;
    }
    public void setSecretKey(String secretKey) 
    {
        this.secretKey = secretKey;
    }

    public String getSecretKey() 
    {
        return secretKey;
    }
    public void setBasicLinks(String basicLinks) 
    {
        this.basicLinks = basicLinks;
    }

    public String getBasicLinks() 
    {
        return basicLinks;
    }
    public void setResidentialQuartersId(Long residentialQuartersId) 
    {
        this.residentialQuartersId = residentialQuartersId;
    }

    public Long getResidentialQuartersId() 
    {
        return residentialQuartersId;
    }
    
    

    public HyResidentialQuarters getHyResidentialQuarters() {
		return hyResidentialQuarters;
	}

	public void setHyResidentialQuarters(HyResidentialQuarters hyResidentialQuarters) {
		this.hyResidentialQuarters = hyResidentialQuarters;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("channelIdentification", getChannelIdentification())
            .append("businessCode", getBusinessCode())
            .append("secretKey", getSecretKey())
            .append("basicLinks", getBasicLinks())
            .append("residentialQuartersId", getResidentialQuartersId())
            .toString();
    }
}
