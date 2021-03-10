package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户对象 hy_user
 * 
 * @author Administrator
 * @date 2021-03-09
 */
public class HyUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  用户id */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 电话 */
    @Excel(name = "电话")
    private Long telphone;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setTelphone(Long telphone) 
    {
        this.telphone = telphone;
    }

    public Long getTelphone() 
    {
        return telphone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("address", getAddress())
            .append("telphone", getTelphone())
            .toString();
    }
}
