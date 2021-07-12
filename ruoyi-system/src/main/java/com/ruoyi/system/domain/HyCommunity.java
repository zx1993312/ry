package com.ruoyi.system.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 社区对象 hy_community
 * 
 * @author Administrator
 * @date 2021-03-12
 */
public class HyCommunity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 社区id */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date releaseTime;

    /** 简介内容 */
    @Excel(name = "简介内容")
    private String introductionContent;
    
    /** 社区名称 */
    @Excel(name = "社区名称")
    private String communityName;
    
    /** 省/直辖市 */
    @Excel(name = "省/市辖区")
    private String communityProvince;
    
    /** 市/市辖区 */
    @Excel(name = "市/市辖区")
    private String communityCity;
    
    /** 区/县 */
    @Excel(name = "区/县")
    private String communityArea;
    
    /** 详细地址 */
    @Excel(name = "详细地址")
    private String communityAddress;
    
    /**社区配套表*/
    @Excel(name="社区配套表")
    private HyCommunitySupport hyCommunitySupport;
    
    /**社区简介表*/
    @Excel(name="社区简介表")
    private HyCommunityIntroduction hyCommunityIntroduction;

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
    public void setReleaseTime(Date releaseTime) 
    {
        this.releaseTime = releaseTime;
    }

    public Date getReleaseTime() 
    {
        return releaseTime;
    }
    public void setIntroductionContent(String introductionContent) 
    {
        this.introductionContent = introductionContent;
    }

    public String getIntroductionContent() 
    {
        return introductionContent;
    }

    public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public String getCommunityProvince() {
		return communityProvince;
	}

	public void setCommunityProvince(String communityProvince) {
		this.communityProvince = communityProvince;
	}

	public String getCommunityCity() {
		return communityCity;
	}

	public void setCommunityCity(String communityCity) {
		this.communityCity = communityCity;
	}

	public String getCommunityArea() {
		return communityArea;
	}

	public void setCommunityArea(String communityArea) {
		this.communityArea = communityArea;
	}

	public String getCommunityAddress() {
		return communityAddress;
	}

	public void setCommunityAddress(String communityAddress) {
		this.communityAddress = communityAddress;
	}

	public HyCommunitySupport getHyCommunitySupport() {
		return hyCommunitySupport;
	}

	public void setHyCommunitySupport(HyCommunitySupport hyCommunitySupport) {
		this.hyCommunitySupport = hyCommunitySupport;
	}

	public HyCommunityIntroduction getHyCommunityIntroduction() {
		return hyCommunityIntroduction;
	}

	public void setHyCommunityIntroduction(HyCommunityIntroduction hyCommunityIntroduction) {
		this.hyCommunityIntroduction = hyCommunityIntroduction;
	}

	@Override
	public String toString() {
		return "HyCommunity [id=" + id + ", title=" + title + ", releaseTime=" + releaseTime + ", introductionContent="
				+ introductionContent + ", communityName=" + communityName + ", communityProvince=" + communityProvince
				+ ", communityCity=" + communityCity + ", communityArea=" + communityArea + ", communityAddress="
				+ communityAddress + ", hyCommunitySupport=" + hyCommunitySupport + ", hyCommunityIntroduction="
				+ hyCommunityIntroduction + "]";
	}

	
}
