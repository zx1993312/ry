package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 小区设置对象 hy_community_settings
 * 
 * @author Administrator
 * @date 2021-03-18
 */
public class HyCommunitySettings extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 小区设置id */
    private Long id;

    /** 小区设置 */
    @Excel(name = "小区设置")
    private String communitySettings;

    /** 说明 */
    @Excel(name = "说明")
    private String explains;

    /** 是否启用 */
    @Excel(name = "是否启用")
    private String enables;

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
    public void setCommunitySettings(String communitySettings) 
    {
        this.communitySettings = communitySettings;
    }

    public String getCommunitySettings() 
    {
        return communitySettings;
    }
    public void setExplains(String explains) 
    {
        this.explains = explains;
    }

    public String getExplains() 
    {
        return explains;
    }
    public void setEnables(String enables) 
    {
        this.enables = enables;
    }

    public String getEnables() 
    {
        return enables;
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
            .append("communitySettings", getCommunitySettings())
            .append("explains", getExplains())
            .append("enables", getEnables())
            .append("residentialQuartersId", getResidentialQuartersId())
            .toString();
    }
}
