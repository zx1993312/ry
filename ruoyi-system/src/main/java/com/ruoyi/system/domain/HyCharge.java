package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.system.annotation.EnumAnn;
import com.ruoyi.system.constants.Constants;
import com.ruoyi.system.enums.StateEnum;

/**
 * 收费比例设置对象 hy_charge
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
public class HyCharge extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 房屋id */
	private Long id;

	/** 房屋序号 */
	@Excel(name = "房屋序号")
	private Long number;

	/** 交房状态 */
	@Excel(name = "交房状态")
	@EnumAnn(enumClass = StateEnum.class)
	private Integer state;

	/** 收费比例 */
	@Excel(name = "收费比例")
	private String proportion;

	/** 备注 */
	@Excel(name = "备注")
	private String remarks;

	/** 当前交房状态 */
	@Excel(name = "当前交房状态")
	@EnumAnn(enumClass = StateEnum.class, enumType = Constants.STRING)
	private String currentState;

	/** 缴费收费科目 */
	@Excel(name = "缴费收费科目")
	private BigDecimal cost;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Long getNumber() {
		return number;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getState() {
		return state;
	}

	public void setProportion(String proportion) {
		this.proportion = proportion;
	}

	public String getProportion() {
		return proportion;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getCost() {
		return cost;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId())
				.append("number", getNumber()).append("state", getState()).append("proportion", getProportion())
				.append("remarks", getRemarks()).append("currentState", getCurrentState()).append("cost", getCost())
				.toString();
	}
}
