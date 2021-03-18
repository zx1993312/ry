package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 支付接口设置对象 hy_payment_interface
 * 
 * @author Administrator
 * @date 2021-03-18
 */
public class HyPaymentInterface extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 支付设置id */
    private Long id;

    /** 支付设置 */
    @Excel(name = "支付设置")
    private String paymentSettings;

    /** 说明 */
    @Excel(name = "说明")
    private String ecplain;

    /** 是否启用 */
    @Excel(name = "是否启用")
    private String ecable;

    /** 小区id */
    @Excel(name = "小区id")
    private Long residentialQuartersId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPaymentSettings(String paymentSettings) 
    {
        this.paymentSettings = paymentSettings;
    }

    public String getPaymentSettings() 
    {
        return paymentSettings;
    }

    public void setResidentialQuartersId(Long residentialQuartersId) 
    {
        this.residentialQuartersId = residentialQuartersId;
    }

    public Long getResidentialQuartersId() 
    {
        return residentialQuartersId;
    }

    public String getEcplain() {
		return ecplain;
	}

	public void setEcplain(String ecplain) {
		this.ecplain = ecplain;
	}

	public String getEcable() {
		return ecable;
	}

	public void setEcable(String ecable) {
		this.ecable = ecable;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("paymentSettings", getPaymentSettings())
            .append("explain", getEcplain())
            .append("enable", getEcable())
            .append("residentialQuartersId", getResidentialQuartersId())
            .toString();
    }
}
