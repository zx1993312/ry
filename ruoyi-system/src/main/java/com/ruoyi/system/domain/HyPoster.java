package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 海报对象 hy_poster
 * 
 * @author Administrator
 * @date 2021-03-09
 */
public class HyPoster extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 海报id */
    private Long id;

    /** 海报地址 */
    @Excel(name = "海报地址")
    private String posterAddress;

    /** 产品id */
    @Excel(name = "产品id")
    private Long productId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPosterAddress(String posterAddress) 
    {
        this.posterAddress = posterAddress;
    }

    public String getPosterAddress() 
    {
        return posterAddress;
    }
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("posterAddress", getPosterAddress())
            .append("productId", getProductId())
            .toString();
    }
}
