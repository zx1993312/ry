package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 打印机配置对象 hy_printer
 * 
 * @author Administrator
 * @date 2021-03-18
 */
public class HyPrinter extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 打印机配置id */
    private Long id;

    /** 报修打印 */
    @Excel(name = "报修打印")
    private String repairReportPrinting;

    /** 意见打印 */
    @Excel(name = "意见打印")
    private String opinionPrinting;

    /** 缴费打印 */
    @Excel(name = "缴费打印")
    private String paymentPrinting;

    /** API密钥 */
    @Excel(name = "API密钥")
    private String apiSecretKey;

    /** 终端编号 */
    @Excel(name = "终端编号")
    private Long terminalNumber;

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
    public void setRepairReportPrinting(String repairReportPrinting) 
    {
        this.repairReportPrinting = repairReportPrinting;
    }

    public String getRepairReportPrinting() 
    {
        return repairReportPrinting;
    }
    public void setOpinionPrinting(String opinionPrinting) 
    {
        this.opinionPrinting = opinionPrinting;
    }

    public String getOpinionPrinting() 
    {
        return opinionPrinting;
    }
    public void setPaymentPrinting(String paymentPrinting) 
    {
        this.paymentPrinting = paymentPrinting;
    }

    public String getPaymentPrinting() 
    {
        return paymentPrinting;
    }
    public void setApiSecretKey(String apiSecretKey) 
    {
        this.apiSecretKey = apiSecretKey;
    }

    public String getApiSecretKey() 
    {
        return apiSecretKey;
    }
    public void setTerminalNumber(Long terminalNumber) 
    {
        this.terminalNumber = terminalNumber;
    }

    public Long getTerminalNumber() 
    {
        return terminalNumber;
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
            .append("repairReportPrinting", getRepairReportPrinting())
            .append("opinionPrinting", getOpinionPrinting())
            .append("paymentPrinting", getPaymentPrinting())
            .append("apiSecretKey", getApiSecretKey())
            .append("terminalNumber", getTerminalNumber())
            .append("residentialQuartersId", getResidentialQuartersId())
            .toString();
    }
}
