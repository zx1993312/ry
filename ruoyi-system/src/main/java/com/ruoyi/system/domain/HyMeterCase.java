package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 箱
对象 hy_meter_case
 * 
 * @author Administrator
 * @date 2021-01-12
 */
public class HyMeterCase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 表箱名称 */
    @Excel(name = "表箱名称")
    private String meterCaseName;

    /** 表箱位置 */
    @Excel(name = "表箱位置")
    private String meterCasePosition;

    /** 表箱序号 */
    @Excel(name = "表箱序号")
    private String meterSerial;
    
    /** 父id */
    @Excel(name = "表箱序号")
    private Integer caseId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMeterCaseName() {
		return meterCaseName;
	}

	public void setMeterCaseName(String meterCaseName) {
		this.meterCaseName = meterCaseName;
	}

	public String getMeterCasePosition() {
		return meterCasePosition;
	}

	public void setMeterCasePosition(String meterCasePosition) {
		this.meterCasePosition = meterCasePosition;
	}

	public String getMeterSerial() {
		return meterSerial;
	}

	public void setMeterSerial(String meterSerial) {
		this.meterSerial = meterSerial;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	@Override
	public String toString() {
		return "HyMeterCase [id=" + id + ", meterCaseName=" + meterCaseName + ", meterCasePosition=" + meterCasePosition
				+ ", meterSerial=" + meterSerial + ", caseId=" + caseId + ", getId()=" + getId()
				+ ", getMeterCaseName()=" + getMeterCaseName() + ", getMeterCasePosition()=" + getMeterCasePosition()
				+ ", getMeterSerial()=" + getMeterSerial() + ", getCaseId()=" + getCaseId() + ", getSearchValue()="
				+ getSearchValue() + ", getCreateBy()=" + getCreateBy() + ", getCreateTime()=" + getCreateTime()
				+ ", getUpdateBy()=" + getUpdateBy() + ", getUpdateTime()=" + getUpdateTime() + ", getRemark()="
				+ getRemark() + ", getParams()=" + getParams() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

 
}
