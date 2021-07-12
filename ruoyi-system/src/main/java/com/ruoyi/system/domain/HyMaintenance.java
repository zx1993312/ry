package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 维修费用对象 hy_maintenance
 * 
 * @author Administrator
 * @date 2021-04-13
 */
public class HyMaintenance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 维修费用id */
    private Long id;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderNumber;

    /** 用户姓名 */
    @Excel(name = "用户姓名")
    private String userName;

    /** 电话 */
    @Excel(name = "电话")
    private String maintenancePhone;

    /** 地址 */
    @Excel(name = "地址")
    private String maintenanceAddress;

    /** 总价 */
    @Excel(name = "总价")
    private String maintenanceTotal;

    /** 支付状态 */
    @Excel(name = "支付状态")
    private String payState;

    /** 支付方式 */
    @Excel(name = "支付方式")
    private String payWay;

    /** 处理人 */
    @Excel(name = "处理人")
    private String historyOperator;
    
    /** 报事管理id */
    @Excel(name = "报事管理id")
    private Long reportId;

    /** 小区id */
    @Excel(name = "小区id")
    private Long quartersId;
    
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
    public void setOrderNumber(String orderNumber) 
    {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() 
    {
        return orderNumber;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setMaintenancePhone(String maintenancePhone) 
    {
        this.maintenancePhone = maintenancePhone;
    }

    public String getMaintenancePhone() 
    {
        return maintenancePhone;
    }
    public void setMaintenanceAddress(String maintenanceAddress) 
    {
        this.maintenanceAddress = maintenanceAddress;
    }

    public String getMaintenanceAddress() 
    {
        return maintenanceAddress;
    }
    public void setMaintenanceTotal(String maintenanceTotal) 
    {
        this.maintenanceTotal = maintenanceTotal;
    }

    public String getMaintenanceTotal() 
    {
        return maintenanceTotal;
    }
    public void setPayState(String payState) 
    {
        this.payState = payState;
    }

    public String getPayState() 
    {
        return payState;
    }
    public void setPayWay(String payWay) 
    {
        this.payWay = payWay;
    }

    public String getPayWay() 
    {
        return payWay;
    }
    public void setHistoryOperator(String historyOperator) 
    {
        this.historyOperator = historyOperator;
    }

    public String getHistoryOperator() 
    {
        return historyOperator;
    }
    public Long getReportId() {
		return reportId;
	}
	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}
	public void setQuartersId(Long quartersId) 
    {
        this.quartersId = quartersId;
    }
    public Long getQuartersId() 
    {
        return quartersId;
    }
	public HyResidentialQuarters getHyResidentialQuarters() {
		return hyResidentialQuarters;
	}

	public void setHyResidentialQuarters(HyResidentialQuarters hyResidentialQuarters) {
		this.hyResidentialQuarters = hyResidentialQuarters;
	}

	@Override
	public String toString() {
		return "HyMaintenance [id=" + id + ", orderNumber=" + orderNumber + ", userName=" + userName
				+ ", maintenancePhone=" + maintenancePhone + ", maintenanceAddress=" + maintenanceAddress
				+ ", maintenanceTotal=" + maintenanceTotal + ", payState=" + payState + ", payWay=" + payWay
				+ ", historyOperator=" + historyOperator + ", reportId=" + reportId + ", quartersId=" + quartersId
				+ ", hyResidentialQuarters=" + hyResidentialQuarters + "]";
	}

	

	

	
}
