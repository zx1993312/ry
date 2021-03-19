package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 支付宝对象 hy_alipay
 * 
 * @author Administrator
 * @date 2021-03-18
 */
public class HyAlipay extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 支付宝账号id */
    private Long id;

    /** 支付宝账号 */
    @Excel(name = "支付宝账号")
    private String alipayAccount;

    /** 合作者身份 */
    @Excel(name = "合作者身份")
    private String partnerIdentity;

    /** 校验密钥 */
    @Excel(name = "校验密钥")
    private String verificationKey;

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
    public void setAlipayAccount(String alipayAccount) 
    {
        this.alipayAccount = alipayAccount;
    }

    public String getAlipayAccount() 
    {
        return alipayAccount;
    }
    public void setPartnerIdentity(String partnerIdentity) 
    {
        this.partnerIdentity = partnerIdentity;
    }

    public String getPartnerIdentity() 
    {
        return partnerIdentity;
    }
    public void setVerificationKey(String verificationKey) 
    {
        this.verificationKey = verificationKey;
    }

    public String getVerificationKey() 
    {
        return verificationKey;
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
            .append("alipayAccount", getAlipayAccount())
            .append("partnerIdentity", getPartnerIdentity())
            .append("verificationKey", getVerificationKey())
            .append("residentialQuartersId", getResidentialQuartersId())
            .toString();
    }
}
