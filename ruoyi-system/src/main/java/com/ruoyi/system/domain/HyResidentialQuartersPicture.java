package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 小区图片对象 hy_residential_quarters_picture
 * 
 * @author Administrator
 * @date 2021-03-18
 */
public class HyResidentialQuartersPicture extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 小区图片id */
    private Long id;

    /** 小区图片地址 */
    @Excel(name = "小区图片地址")
    private String pictureAddress;

    /** 图文图片地址 */
    @Excel(name = "图文图片地址")
    private String textPictureAddress;

    /** 收费专用章地址 */
    @Excel(name = "收费专用章地址")
    private String chargeChapterAddress;

    /** 二维码背景地址 */
    @Excel(name = "二维码背景地址")
    private String codeBackgroundAddress;

    /** 访客二维码背景地址 */
    @Excel(name = "访客二维码背景地址")
    private String visitorCodeBackgroundAddress;

    /** 小区id */
    @Excel(name = "小区id")
    private Long residentialQuartersId;
    /**小区表*/
    @Excel(name="小区表")
    private HyResidentialQuartersPicture hyResidentialQuartersPicture;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPictureAddress(String pictureAddress) 
    {
        this.pictureAddress = pictureAddress;
    }

    public String getPictureAddress() 
    {
        return pictureAddress;
    }
    public void setTextPictureAddress(String textPictureAddress) 
    {
        this.textPictureAddress = textPictureAddress;
    }

    public String getTextPictureAddress() 
    {
        return textPictureAddress;
    }
    public void setChargeChapterAddress(String chargeChapterAddress) 
    {
        this.chargeChapterAddress = chargeChapterAddress;
    }

    public String getChargeChapterAddress() 
    {
        return chargeChapterAddress;
    }
    public void setCodeBackgroundAddress(String codeBackgroundAddress) 
    {
        this.codeBackgroundAddress = codeBackgroundAddress;
    }

    public String getCodeBackgroundAddress() 
    {
        return codeBackgroundAddress;
    }
    public void setVisitorCodeBackgroundAddress(String visitorCodeBackgroundAddress) 
    {
        this.visitorCodeBackgroundAddress = visitorCodeBackgroundAddress;
    }

    public String getVisitorCodeBackgroundAddress() 
    {
        return visitorCodeBackgroundAddress;
    }
    public void setResidentialQuartersId(Long residentialQuartersId) 
    {
        this.residentialQuartersId = residentialQuartersId;
    }

    public Long getResidentialQuartersId() 
    {
        return residentialQuartersId;
    }

    public HyResidentialQuartersPicture getHyResidentialQuartersPicture() {
		return hyResidentialQuartersPicture;
	}

	public void setHyResidentialQuartersPicture(HyResidentialQuartersPicture hyResidentialQuartersPicture) {
		this.hyResidentialQuartersPicture = hyResidentialQuartersPicture;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pictureAddress", getPictureAddress())
            .append("textPictureAddress", getTextPictureAddress())
            .append("chargeChapterAddress", getChargeChapterAddress())
            .append("codeBackgroundAddress", getCodeBackgroundAddress())
            .append("visitorCodeBackgroundAddress", getVisitorCodeBackgroundAddress())
            .append("residentialQuartersId", getResidentialQuartersId())
            .toString();
    }
}
