package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 标签对象 hy_lable
 * 
 * @author Administrator
 * @date 2021-03-16
 */
public class HyLable extends BaseEntity
{
    private static final long serialVersionUID = 1L ;

    /** 标签id */
    private Long id;

    /** 标签名称 */
    @Excel(name = "标签名称")
    private String lableName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLableName(String lableName) 
    {
        this.lableName = lableName;
    }

    public String getLableName() 
    {
        return lableName;
    }

	@Override
	public String toString() {
		return "HyLable [id=" + id + ", lableName=" + lableName + "]";
	}

	
    



	
}
