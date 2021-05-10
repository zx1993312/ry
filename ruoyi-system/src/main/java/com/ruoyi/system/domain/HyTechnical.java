package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 技术参数对象 hy_technical
 * 
 * @author Administrator
 * @date 2021-05-10
 */
public class HyTechnical extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 技术参数id */
    private Long id;

    /** 参数名称 */
    @Excel(name = "参数名称")
    private String technicalName;

    /** 技术参数（机械） */
    @Excel(name = "技术参数", readConverterExp = "机=械")
    private String technicalMachine;

    /** 技术参数（电气） */
    @Excel(name = "技术参数", readConverterExp = "电=气")
    private String technicalElectric;

    /** 补充说明 */
    @Excel(name = "补充说明")
    private String technicalInstruction;

    /** 设备档案id */
    @Excel(name = "设备档案id")
    private Long archivesId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTechnicalName(String technicalName) 
    {
        this.technicalName = technicalName;
    }

    public String getTechnicalName() 
    {
        return technicalName;
    }
    public void setTechnicalMachine(String technicalMachine) 
    {
        this.technicalMachine = technicalMachine;
    }

    public String getTechnicalMachine() 
    {
        return technicalMachine;
    }
    public void setTechnicalElectric(String technicalElectric) 
    {
        this.technicalElectric = technicalElectric;
    }

    public String getTechnicalElectric() 
    {
        return technicalElectric;
    }
    public void setTechnicalInstruction(String technicalInstruction) 
    {
        this.technicalInstruction = technicalInstruction;
    }

    public String getTechnicalInstruction() 
    {
        return technicalInstruction;
    }
    public void setArchivesId(Long archivesId) 
    {
        this.archivesId = archivesId;
    }

    public Long getArchivesId() 
    {
        return archivesId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("technicalName", getTechnicalName())
            .append("technicalMachine", getTechnicalMachine())
            .append("technicalElectric", getTechnicalElectric())
            .append("technicalInstruction", getTechnicalInstruction())
            .append("archivesId", getArchivesId())
            .toString();
    }
}
