package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 评价对象 hy_score
 * 
 * @author Administrator
 * @date 2021-03-18
 */
public class HyScore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评价id */
    private Long id;

    /** 编号 */
    @Excel(name = "编号")
    private Long number;

    /** 用户 */
    @Excel(name = "用户")
    private String user;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 评价 */
    @Excel(name = "评价")
    private String score;

    /** 总分 */
    @Excel(name = "总分")
    private String comunt;

    /** 评价内容 */
    @Excel(name = "评价内容")
    private String scoreContent;

    /** 评价时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "评价时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date scoreTime;

    /** 小区id */
    @Excel(name = "小区id")
    private Long residentialQuartersId;
    
    /** 小区表 */
    @Excel(name = "小区表")
    private HyResidentialQuarters hyResidentialQuarters;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
    }
    public void setUser(String user) 
    {
        this.user = user;
    }

    public String getUser() 
    {
        return user;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setScore(String score) 
    {
        this.score = score;
    }

    public String getScore() 
    {
        return score;
    }
    public void setComunt(String comunt) 
    {
        this.comunt = comunt;
    }

    public String getComunt() 
    {
        return comunt;
    }
    public void setScoreContent(String scoreContent) 
    {
        this.scoreContent = scoreContent;
    }

    public String getScoreContent() 
    {
        return scoreContent;
    }
    public void setScoreTime(Date scoreTime) 
    {
        this.scoreTime = scoreTime;
    }

    public Date getScoreTime() 
    {
        return scoreTime;
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
            .append("number", getNumber())
            .append("user", getUser())
            .append("address", getAddress())
            .append("score", getScore())
            .append("comunt", getComunt())
            .append("scoreContent", getScoreContent())
            .append("scoreTime", getScoreTime())
            .append("residentialQuartersId", getResidentialQuartersId())
            .toString();
    }
}
