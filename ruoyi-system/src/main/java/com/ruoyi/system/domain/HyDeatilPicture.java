package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品详情的图片
对象 hy_deatil_picture
 * 
 * @author Administrator
 * @date 2021-04-08
 */
public class HyDeatilPicture extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String deatilPicture;

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
    public void setDeatilPicture(String deatilPicture) 
    {
        this.deatilPicture = deatilPicture;
    }

    public String getDeatilPicture() 
    {
        return deatilPicture;
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
            .append("deatilPicture", getDeatilPicture())
            .append("productId", getProductId())
            .toString();
    }
}
