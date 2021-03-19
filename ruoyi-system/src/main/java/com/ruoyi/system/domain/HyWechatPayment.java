package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 微信支付对象 hy_wechat_payment
 * 
 * @author Administrator
 * @date 2021-03-18
 */
public class HyWechatPayment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 微信支付id */
    private Long id;

    /** 公众号 */
    @Excel(name = "公众号")
    private String officialAccount;

    /** 微信支付商户号 */
    @Excel(name = "微信支付商户号")
    private String wechatPaymentMerchantNumber;

    /** 微信支付密钥 */
    @Excel(name = "微信支付密钥")
    private String wechatPaymentKey;

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
    public void setOfficialAccount(String officialAccount) 
    {
        this.officialAccount = officialAccount;
    }

    public String getOfficialAccount() 
    {
        return officialAccount;
    }
    public void setWechatPaymentMerchantNumber(String wechatPaymentMerchantNumber) 
    {
        this.wechatPaymentMerchantNumber = wechatPaymentMerchantNumber;
    }

    public String getWechatPaymentMerchantNumber() 
    {
        return wechatPaymentMerchantNumber;
    }
    public void setWechatPaymentKey(String wechatPaymentKey) 
    {
        this.wechatPaymentKey = wechatPaymentKey;
    }

    public String getWechatPaymentKey() 
    {
        return wechatPaymentKey;
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
            .append("officialAccount", getOfficialAccount())
            .append("wechatPaymentMerchantNumber", getWechatPaymentMerchantNumber())
            .append("wechatPaymentKey", getWechatPaymentKey())
            .append("residentialQuartersId", getResidentialQuartersId())
            .toString();
    }
}
