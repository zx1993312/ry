package com.ruoyi.system.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 违约金对象 hy_damages
 * 
 * @author Administrator
 * @date 2021-01-28
 */
public class HyDamages extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 合同违约金延期 */
    @Excel(name = "合同违约金延期")
    private String contractDamagesDelay;

    /** 合同违约金比例 */
    @Excel(name = "合同违约金比例")
    private String contractDamagesProportion;

    /** 应缴日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "应缴日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date paymentDeadlinStrTime;
    /**
     * 房屋id
     */
    @Excel(name = "房屋id")
    private Long houseId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setContractDamagesDelay(String contractDamagesDelay) 
    {
        this.contractDamagesDelay = contractDamagesDelay;
    }

    public String getContractDamagesDelay() 
    {
        return contractDamagesDelay;
    }
    public void setContractDamagesProportion(String contractDamagesProportion) 
    {
        this.contractDamagesProportion = contractDamagesProportion;
    }

    public String getContractDamagesProportion() 
    {
        return contractDamagesProportion;
    }
    public void setPaymentDeadlinStrTime(Date paymentDeadlinStrTime) 
    {
        this.paymentDeadlinStrTime = paymentDeadlinStrTime;
    }

    public Date getPaymentDeadlinStrTime() 
    {
        return paymentDeadlinStrTime;
    }


	public Long getHouseId() {
		return houseId;
	}

	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}

	@Override
	public String toString() {
		return "HyDamages [id=" + id + ", contractDamagesDelay=" + contractDamagesDelay + ", contractDamagesProportion="
				+ contractDamagesProportion + ", paymentDeadlinStrTime=" + paymentDeadlinStrTime + ", houseId="
				+ houseId + "]";
	}



}
