package com.ruoyi.system.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 装修管理对象 hy_fitment_manage
 * 
 * @author Administrator
 * @date 2021-04-13
 */
public class HyFitmentManage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 装修管理id */
    private Long id;

    /** 装修状态 */
    @Excel(name = "装修状态")
    private String fitmentManageState;

    /** 装修描述 */
    @Excel(name = "装修描述")
    private String fitmentManageContent;

    /** 预期工期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预期工期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fitmentManageExpect;
    
    /** 装修开始日期 */
    private Date fitmentStartTime;
    
    /** 装修结束日期 */
    private Date fitmentEndTime;
    
    /** 手持图片地址 */
    private String processImg;

    /** 业主id */
    @Excel(name = "业主id")
    private Long ownerRegistrationId;
    
    /** 业主表 */
    @Excel(name = "业主表")
    private HyOwnerRegistration hyOwnerRegistration;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFitmentManageState() {
		return fitmentManageState;
	}

	public void setFitmentManageState(String fitmentManageState) {
		this.fitmentManageState = fitmentManageState;
	}

	public String getFitmentManageContent() {
		return fitmentManageContent;
	}

	public void setFitmentManageContent(String fitmentManageContent) {
		this.fitmentManageContent = fitmentManageContent;
	}

	public Date getFitmentManageExpect() {
		return fitmentManageExpect;
	}

	public void setFitmentManageExpect(Date fitmentManageExpect) {
		this.fitmentManageExpect = fitmentManageExpect;
	}

	public Date getFitmentStartTime() {
		return fitmentStartTime;
	}

	public void setFitmentStartTime(Date fitmentStartTime) {
		this.fitmentStartTime = fitmentStartTime;
	}

	public Date getFitmentEndTime() {
		return fitmentEndTime;
	}

	public void setFitmentEndTime(Date fitmentEndTime) {
		this.fitmentEndTime = fitmentEndTime;
	}

	public String getProcessImg() {
		return processImg;
	}

	public void setProcessImg(String processImg) {
		this.processImg = processImg;
	}

	public Long getOwnerRegistrationId() {
		return ownerRegistrationId;
	}

	public void setOwnerRegistrationId(Long ownerRegistrationId) {
		this.ownerRegistrationId = ownerRegistrationId;
	}

	public HyOwnerRegistration getHyOwnerRegistration() {
		return hyOwnerRegistration;
	}

	public void setHyOwnerRegistration(HyOwnerRegistration hyOwnerRegistration) {
		this.hyOwnerRegistration = hyOwnerRegistration;
	}


	
}
