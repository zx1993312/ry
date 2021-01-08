package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.system.annotation.EnumAnn;
import com.ruoyi.system.enums.AccountEnum;

/**
 * 往期应收调账对象 hy_past_account
 * 
 * @author Administrator
 * @date 2021-01-07
 */
public class HyPastAccount extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 管理项目 */
    @Excel(name = "管理项目")
    @EnumAnn(enumClass=AccountEnum.class ,enumType="String")
    private String manageProjects;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String customerName;

    /** 房屋编号 */
    @Excel(name = "房屋编号")
    private String houseNum;

    /** 车位编号 */
    @Excel(name = "车位编号")
    private String parkingNum;

    /** 费用序号 */
    @Excel(name = "费用序号")
    private String feeNum;

    /** 费用名称 */
    @Excel(name = "费用名称")
    private String feeName;

    /** 费用日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "费用日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date feeDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setManageProjects(String manageProjects) 
    {
        this.manageProjects = manageProjects;
    }

    public String getManageProjects() 
    {
        return manageProjects;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }
    public void setHouseNum(String houseNum) 
    {
        this.houseNum = houseNum;
    }

    public String getHouseNum() 
    {
        return houseNum;
    }
    public void setParkingNum(String parkingNum) 
    {
        this.parkingNum = parkingNum;
    }

    public String getParkingNum() 
    {
        return parkingNum;
    }
    public void setFeeNum(String feeNum) 
    {
        this.feeNum = feeNum;
    }

    public String getFeeNum() 
    {
        return feeNum;
    }
    public void setFeeName(String feeName) 
    {
        this.feeName = feeName;
    }

    public String getFeeName() 
    {
        return feeName;
    }
    public void setFeeDate(Date feeDate) 
    {
        this.feeDate = feeDate;
    }

    public Date getFeeDate() 
    {
        return feeDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("manageProjects", getManageProjects())
            .append("customerName", getCustomerName())
            .append("houseNum", getHouseNum())
            .append("parkingNum", getParkingNum())
            .append("feeNum", getFeeNum())
            .append("feeName", getFeeName())
            .append("feeDate", getFeeDate())
            .toString();
    }
}
