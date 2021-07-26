package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物业简介图片对象 hy_introductionpictures
 * 
 * @author Administrator
 * @date 2021-07-26
 */
public class HyIntroductionpictures extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物业简介图片id */
    private Long id;

    /** 物业简介图片 */
    @Excel(name = "物业简介图片")
    private String introductionPicture;

    /** 物业简介id */
    @Excel(name = "物业简介id")
    private Long introductionId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setIntroductionPicture(String introductionPicture) 
    {
        this.introductionPicture = introductionPicture;
    }

    public String getIntroductionPicture() 
    {
        return introductionPicture;
    }
    public void setIntroductionId(Long introductionId) 
    {
        this.introductionId = introductionId;
    }

    public Long getIntroductionId() 
    {
        return introductionId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("introductionPicture", getIntroductionPicture())
            .append("introductionId", getIntroductionId())
            .toString();
    }
}
