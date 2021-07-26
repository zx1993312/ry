package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 社区简介对象 hy_community_introduction
 * 
 * @author Administrator
 * @date 2021-03-12
 */
public class HyCommunityIntroduction extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  社区简介id */
    private Long id;

    /** 简介图片地址 */
    @Excel(name = "简介图片地址")
    private String introductionPhotoAddress;

    /** 简介内容 */
    @Excel(name = "简介内容")
    private String introduction;
    
    /** 物业简介图片表 */
    private HyIntroductionpictures hyIntroductionpictures;
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setIntroductionPhotoAddress(String introductionPhotoAddress) 
    {
        this.introductionPhotoAddress = introductionPhotoAddress;
    }

    public String getIntroductionPhotoAddress() 
    {
        return introductionPhotoAddress;
    }

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public HyIntroductionpictures getHyIntroductionpictures() {
		return hyIntroductionpictures;
	}

	public void setHyIntroductionpictures(HyIntroductionpictures hyIntroductionpictures) {
		this.hyIntroductionpictures = hyIntroductionpictures;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("introductionPhotoAddress", getIntroductionPhotoAddress())
            .append("introduction", getIntroduction())
            .append("hyIntroductionpictures", getHyIntroductionpictures())
            .toString();
    }
}
