package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 微信支付第三方对象 hy_third_payment
 * 
 * @author Administrator
 * @date 2021-03-18
 */
public class HyThirdPayment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 第三方id */
    private Long id;

    /** 银行通道 */
    @Excel(name = "银行通道")
    private String bankChannel;

    /** 商户号 */
    @Excel(name = "商户号")
    private Long merchantNumber;

    /** 密钥 */
    @Excel(name = "密钥")
    private String secretKey;

    /** 公众号appid */
    @Excel(name = "公众号appid")
    private String appid;

    /** 公众号appseret */
    @Excel(name = "公众号appseret")
    private String appsecret;

    /** 应用私钥 */
    @Excel(name = "应用私钥")
    private String applicationPrivateKey;

    /** 小区id */
    @Excel(name = "小区id")
    private Long residentialQuartersId;
    
    /** 小区表*/
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
    public void setBankChannel(String bankChannel) 
    {
        this.bankChannel = bankChannel;
    }

    public String getBankChannel() 
    {
        return bankChannel;
    }
    public void setMerchantNumber(Long merchantNumber) 
    {
        this.merchantNumber = merchantNumber;
    }

    public Long getMerchantNumber() 
    {
        return merchantNumber;
    }
    public void setSecretKey(String secretKey) 
    {
        this.secretKey = secretKey;
    }

    public String getSecretKey() 
    {
        return secretKey;
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
    public void setApplicationPrivateKey(String applicationPrivateKey) 
    {
        this.applicationPrivateKey = applicationPrivateKey;
    }

    public String getApplicationPrivateKey() 
    {
        return applicationPrivateKey;
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
            .append("bankChannel", getBankChannel())
            .append("merchantNumber", getMerchantNumber())
            .append("secretKey", getSecretKey())
            .append("appid", getAppid())
            .append("appsecret", getAppsecret())
            .append("applicationPrivateKey", getApplicationPrivateKey())
            .append("residentialQuartersId", getResidentialQuartersId())
            .toString();
    }
}
