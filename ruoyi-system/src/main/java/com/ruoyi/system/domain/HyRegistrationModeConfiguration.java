package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 注册方式配置对象 hy_registration_mode_configuration
 * 
 * @author Administrator
 * @date 2021-03-17
 */
public class HyRegistrationModeConfiguration extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 注册方式配置id */
    private Long id;

    /** 小区设置 */
    @Excel(name = "小区设置")
    private String residentialQuartersSetUp;

    /** 说明 */
    @Excel(name = "说明")
    private String ecplain;

    /** 是否启用 */
    @Excel(name = "是否启用")
    private String ecable;

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
    public void setResidentialQuartersSetUp(String residentialQuartersSetUp) 
    {
        this.residentialQuartersSetUp = residentialQuartersSetUp;
    }

    public String getResidentialQuartersSetUp() 
    {
        return residentialQuartersSetUp;
    }
    public void setEcplain(String ecplain) 
    {
        this.ecplain = ecplain;
    }

    public String getEcplain() 
    {
        return ecplain;
    }
    public void setEcable(String ecable) 
    {
        this.ecable = ecable;
    }

    public String getEcable() 
    {
        return ecable;
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
            .append("residentialQuartersSetUp", getResidentialQuartersSetUp())
            .append("ecplain", getEcplain())
            .append("ecable", getEcable())
            .append("residentialQuartersId", getResidentialQuartersId())
            .toString();
    }
}
