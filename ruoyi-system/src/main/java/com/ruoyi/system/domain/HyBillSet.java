package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 票据设置对象 hy_bill_set
 * 
 * @author Administrator
 * @date 2021-01-06 
 */
public class HyBillSet extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 票据种类 */
    @Excel(name = "票据种类")
    private String billTypes;

    /** 票据类别 */
    @Excel(name = "票据类别")
    private String billCategory;

    /** 前缀 */
    @Excel(name = "前缀")
    private String prefix;

    /** 后缀 */
    @Excel(name = "后缀")
    private String suffix;

    /** 位数 */
    @Excel(name = "位数")
    private String digit;

    /** 票据样例 */
    @Excel(name = "票据样例")
    private String billSample;

    /** 定额票据面板 */
    @Excel(name = "定额票据面板")
    private String billPanel;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBillTypes(String billTypes) 
    {
        this.billTypes = billTypes;
    }

    public String getBillTypes() 
    {
        return billTypes;
    }
    public void setBillCategory(String billCategory) 
    {
        this.billCategory = billCategory;
    }

    public String getBillCategory() 
    {
        return billCategory;
    }
    public void setPrefix(String prefix) 
    {
        this.prefix = prefix;
    }

    public String getPrefix() 
    {
        return prefix;
    }
    public void setSuffix(String suffix) 
    {
        this.suffix = suffix;
    }

    public String getSuffix() 
    {
        return suffix;
    }
    public void setDigit(String digit) 
    {
        this.digit = digit;
    }

    public String getDigit() 
    {
        return digit;
    }
    public void setBillSample(String billSample) 
    {
        this.billSample = billSample;
    }

    public String getBillSample() 
    {
        return billSample;
    }
    public void setBillPanel(String billPanel) 
    {
        this.billPanel = billPanel;
    }

    public String getBillPanel() 
    {
        return billPanel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("billTypes", getBillTypes())
            .append("billCategory", getBillCategory())
            .append("prefix", getPrefix())
            .append("suffix", getSuffix())
            .append("digit", getDigit())
            .append("billSample", getBillSample())
            .append("billPanel", getBillPanel())
            .toString();
    }
}
