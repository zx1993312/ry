package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 服务商商户号对象 hy_service_provider_account_number
 * 
 * @author Administrator
 * @date 2021-03-18
 */
public class HyServiceProviderAccountNumber extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 服务商商户号id */
    private Long id;

    /** 服务商商户号 */
    @Excel(name = "服务商商户号")
    private String serviceProviderAccounNumber;

    /** 商户支付密钥 */
    @Excel(name = "商户支付密钥")
    private String merchantPaymentKey;

    /** 公众号appid */
    @Excel(name = "公众号appid")
    private String appid;

    /** 公众号appsecret */
    @Excel(name = "公众号appsecret")
    private String appsecret;

    /** 子商户号 */
    @Excel(name = "子商户号")
    private String subMerchantNumber;

    /** 小区id */
    @Excel(name = "小区id")
    private Long residentialQuartersId;
    /**小区表*/
    @Excel(name="小区表")
    private HyResidentialQuarters hyResidentialQuarters;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setServiceProviderAccounNumber(String serviceProviderAccounNumber) 
    {
        this.serviceProviderAccounNumber = serviceProviderAccounNumber;
    }

    public String getServiceProviderAccounNumber() 
    {
        return serviceProviderAccounNumber;
    }
    public void setMerchantPaymentKey(String merchantPaymentKey) 
    {
        this.merchantPaymentKey = merchantPaymentKey;
    }

    public String getMerchantPaymentKey() 
    {
        return merchantPaymentKey;
    }
    public void setAppid(String appid) 
    {
        this.appid = appid;
    }

    public String getAppid() 
    {
        return appid;
    }
    public void setAppsecret(String appsecret) 
    {
        this.appsecret = appsecret;
    }

    public String getAppsecret() 
    {
        return appsecret;
    }
    public void setSubMerchantNumber(String subMerchantNumber) 
    {
        this.subMerchantNumber = subMerchantNumber;
    }

    public String getSubMerchantNumber() 
    {
        return subMerchantNumber;
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
            .append("serviceProviderAccounNumber", getServiceProviderAccounNumber())
            .append("merchantPaymentKey", getMerchantPaymentKey())
            .append("appid", getAppid())
            .append("appsecret", getAppsecret())
            .append("subMerchantNumber", getSubMerchantNumber())
            .append("residentialQuartersId", getResidentialQuartersId())
            .toString();
    }
}
