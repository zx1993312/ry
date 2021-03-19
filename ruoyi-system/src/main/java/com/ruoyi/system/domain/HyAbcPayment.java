package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 农行支付对象 hy_abc_payment
 * 
 * @author Administrator
 * @date 2021-03-19
 */
public class HyAbcPayment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 缴费项目id */
    private Long id;

    /** 缴费项目编号 */
    @Excel(name = "缴费项目编号")
    private String paymentItemsNumber;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 私钥 */
    @Excel(name = "私钥")
    private String privateKey;

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
    public void setPaymentItemsNumber(String paymentItemsNumber) 
    {
        this.paymentItemsNumber = paymentItemsNumber;
    }

    public String getPaymentItemsNumber() 
    {
        return paymentItemsNumber;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setPrivateKey(String privateKey) 
    {
        this.privateKey = privateKey;
    }

    public String getPrivateKey() 
    {
        return privateKey;
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
            .append("paymentItemsNumber", getPaymentItemsNumber())
            .append("password", getPassword())
            .append("privateKey", getPrivateKey())
            .append("residentialQuartersId", getResidentialQuartersId())
            .toString();
    }
}
