package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 费用项目对象 hy_cost
 * 
 * @author Administrator
 * @date 2021-01-06
 */
public class HyCost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 费用项目 */
    @Excel(name = "费用项目")
    private String costItems;

    /** 费用类型 */
    @Excel(name = "费用类型")
    private String expenseType;
    
    @Excel(name = "父类id")
    private Integer parentId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCostItems(String costItems) 
    {
        this.costItems = costItems;
    }

    public String getCostItems() 
    {
        return costItems;
    }
    public void setExpenseType(String expenseType) 
    {
        this.expenseType = expenseType;
    }

    public String getExpenseType() 
    {
        return expenseType;
    }

    
    public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("costItems", getCostItems())
            .append("expenseType", getExpenseType())
            .toString();
    }
}
