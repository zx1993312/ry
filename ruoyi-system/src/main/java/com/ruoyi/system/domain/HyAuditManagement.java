package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 审核管理
对象 hy_audit_management
 * 
 * @author Administrator
 * @date 2021-01-23
 */
public class HyAuditManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 审核流程 */
    @Excel(name = "审核流程")
    private String auditProcess;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private Integer auditStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAuditProcess(String auditProcess) 
    {
        this.auditProcess = auditProcess;
    }

    public String getAuditProcess() 
    {
        return auditProcess;
    }
    public void setAuditStatus(Integer auditStatus) 
    {
        this.auditStatus = auditStatus;
    }

    public Integer getAuditStatus() 
    {
        return auditStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("auditProcess", getAuditProcess())
            .append("auditStatus", getAuditStatus())
            .toString();
    }
}
