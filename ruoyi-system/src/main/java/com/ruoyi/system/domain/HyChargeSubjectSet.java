package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.system.annotation.EnumAnn;
import com.ruoyi.system.enums.CalculationMethodEnum;

/**
 * 收费科目设置对象 hy_charge_subject_set
 * 
 * @author Administrator
 * @date 2021-01-06
 */
public class HyChargeSubjectSet extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 费用名称 */
    @Excel(name = "费用名称")
    private String feeName;

    /** 标准编号 */
    @Excel(name = "标准编号")
    private String standardNum;

    /** 标准名称 */
    @Excel(name = "标准名称")
    private String standardName;

    /** 计算方式 */
    @Excel(name = "计算方式")
    @EnumAnn(enumClass=CalculationMethodEnum.class,enumType="String")
    private String calculationMethod;

    /** 通用收费标准 */
    @Excel(name = "通用收费标准")
    private String chargingStanard;

    /** 标准说明 */
    @Excel(name = "标准说明")
    private String descriptionStandard;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFeeName(String feeName) 
    {
        this.feeName = feeName;
    }

    public String getFeeName() 
    {
        return feeName;
    }
    public void setStandardNum(String standardNum) 
    {
        this.standardNum = standardNum;
    }

    public String getStandardNum() 
    {
        return standardNum;
    }
    public void setStandardName(String standardName) 
    {
        this.standardName = standardName;
    }

    public String getStandardName() 
    {
        return standardName;
    }
    public void setCalculationMethod(String calculationMethod) 
    {
        this.calculationMethod = calculationMethod;
    }

    public String getCalculationMethod() 
    {
        return calculationMethod;
    }
    public void setChargingStanard(String chargingStanard) 
    {
        this.chargingStanard = chargingStanard;
    }

    public String getChargingStanard() 
    {
        return chargingStanard;
    }
    public void setDescriptionStandard(String descriptionStandard) 
    {
        this.descriptionStandard = descriptionStandard;
    }

    public String getDescriptionStandard() 
    {
        return descriptionStandard;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("feeName", getFeeName())
            .append("standardNum", getStandardNum())
            .append("standardName", getStandardName())
            .append("calculationMethod", getCalculationMethod())
            .append("chargingStanard", getChargingStanard())
            .append("descriptionStandard", getDescriptionStandard())
            .toString();
    }
}
