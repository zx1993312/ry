package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 社区文化对象 hy_community_culture
 * 
 * @author Administrator
 * @date 2021-04-12
 */
public class HyCommunityCulture extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 社区文化id */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 信息内容 */
    @Excel(name = "信息内容")
    private String informationContent;

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
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setInformationContent(String informationContent) 
    {
        this.informationContent = informationContent;
    }

    public String getInformationContent() 
    {
        return informationContent;
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
		return "HyCommunityCulture [id=" + id + ", title=" + title + ", informationContent=" + informationContent
				+ ", communityId=" + communityId + ", hyCommunity=" + hyCommunity + "]";
	}

	
}
