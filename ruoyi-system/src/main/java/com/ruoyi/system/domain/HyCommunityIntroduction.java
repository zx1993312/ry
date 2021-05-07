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

    /** 社区id */
    @Excel(name = "社区id")
    private Long communityId;
    
    /** 社区表 */
    @Excel(name = "社区表")
    private HyCommunity hyCommunity;

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
    public void setCommunityId(Long communityId) 
    {
        this.communityId = communityId;
    }

    public Long getCommunityId() 
    {
        return communityId;
    }

    public HyCommunity getHyCommunity() {
		return hyCommunity;
	}

	public void setHyCommunity(HyCommunity hyCommunity) {
		this.hyCommunity = hyCommunity;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("introductionPhotoAddress", getIntroductionPhotoAddress())
            .append("communityId", getCommunityId())
            .append("hyCommunity", getHyCommunity())
            .toString();
    }
}
