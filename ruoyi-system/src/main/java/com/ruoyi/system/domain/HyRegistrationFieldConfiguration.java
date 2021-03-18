package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 注册字段配置对象 hy_registration_field_configuration
 * 
 * @author Administrator
 * @date 2021-03-18
 */
public class HyRegistrationFieldConfiguration extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 注册字段配置id */
    private Long id;

    /** 字段 */
    @Excel(name = "字段")
    private String field;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 是否启用 */
    @Excel(name = "是否启用")
    private String enable;

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
    public void setField(String field) 
    {
        this.field = field;
    }

    public String getField() 
    {
        return field;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setEnable(String enable) 
    {
        this.enable = enable;
    }

    public String getEnable() 
    {
        return enable;
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
            .append("field", getField())
            .append("title", getTitle())
            .append("enable", getEnable())
            .append("residentialQuartersId", getResidentialQuartersId())
            .toString();
    }
}
