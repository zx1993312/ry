package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 银联商务对象 hy_unionpay_business
 * 
 * @author Administrator
 * @date 2021-03-18
 */
public class HyUnionpayBusiness extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 银联商务id */
    private Long id;

    /** 商户号 */
    @Excel(name = "商户号")
    private String merchantNumber;

    /** 终端盒 */
    @Excel(name = "终端盒")
    private String terminalBox;

    /** 机构商务号 */
    @Excel(name = "机构商务号")
    private String organizationBusinessNumber;

    /** 信息来源 */
    @Excel(name = "信息来源")
    private String informationSources;

    /** 来源编号 */
    @Excel(name = "来源编号")
    private Long sourceNumber;

    /** 测试环境md5密钥 */
    @Excel(name = "测试环境md5密钥")
    private String secretKey;

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
    public void setMerchantNumber(String merchantNumber) 
    {
        this.merchantNumber = merchantNumber;
    }

    public String getMerchantNumber() 
    {
        return merchantNumber;
    }
    public void setTerminalBox(String terminalBox) 
    {
        this.terminalBox = terminalBox;
    }

    public String getTerminalBox() 
    {
        return terminalBox;
    }
    public void setOrganizationBusinessNumber(String organizationBusinessNumber) 
    {
        this.organizationBusinessNumber = organizationBusinessNumber;
    }

    public String getOrganizationBusinessNumber() 
    {
        return organizationBusinessNumber;
    }
    public void setInformationSources(String informationSources) 
    {
        this.informationSources = informationSources;
    }

    public String getInformationSources() 
    {
        return informationSources;
    }
    public void setSourceNumber(Long sourceNumber) 
    {
        this.sourceNumber = sourceNumber;
    }

    public Long getSourceNumber() 
    {
        return sourceNumber;
    }
    public void setSecretKey(String secretKey) 
    {
        this.secretKey = secretKey;
    }

    public String getSecretKey() 
    {
        return secretKey;
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
            .append("merchantNumber", getMerchantNumber())
            .append("terminalBox", getTerminalBox())
            .append("organizationBusinessNumber", getOrganizationBusinessNumber())
            .append("informationSources", getInformationSources())
            .append("sourceNumber", getSourceNumber())
            .append("secretKey", getSecretKey())
            .append("residentialQuartersId", getResidentialQuartersId())
            .toString();
    }
}
