package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 保养项目对象 hy_maintenanceproject
 * 
 * @author Administrator
 * @date 2021-05-10
 */
public class HyMaintenanceproject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 保养项目id */
    private Long id;

    /** 保养项目编号 */
    @Excel(name = "保养项目编号")
    private Long maintenanceItem;

    /** 保养内容 */
    @Excel(name = "保养内容")
    private String maintenanceContent;

    /** 保养标准 */
    @Excel(name = "保养标准")
    private String maintenanceStandards;

    /** 设备保养周期 */
    @Excel(name = "设备保养周期")
    private String maintenanceCycle;

    /** 设备档案id */
    @Excel(name = "设备档案id")
    private Long archivesId;

    /** 设备类别id */
    @Excel(name = "设备类别id")
    private Long equipmentId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMaintenanceItem(Long maintenanceItem) 
    {
        this.maintenanceItem = maintenanceItem;
    }

    public Long getMaintenanceItem() 
    {
        return maintenanceItem;
    }
    public void setMaintenanceContent(String maintenanceContent) 
    {
        this.maintenanceContent = maintenanceContent;
    }

    public String getMaintenanceContent() 
    {
        return maintenanceContent;
    }
    public void setMaintenanceStandards(String maintenanceStandards) 
    {
        this.maintenanceStandards = maintenanceStandards;
    }

    public String getMaintenanceStandards() 
    {
        return maintenanceStandards;
    }
    public void setMaintenanceCycle(String maintenanceCycle) 
    {
        this.maintenanceCycle = maintenanceCycle;
    }

    public String getMaintenanceCycle() 
    {
        return maintenanceCycle;
    }
    public void setArchivesId(Long archivesId) 
    {
        this.archivesId = archivesId;
    }

    public Long getArchivesId() 
    {
        return archivesId;
    }
    public void setEquipmentId(Long equipmentId) 
    {
        this.equipmentId = equipmentId;
    }

    public Long getEquipmentId() 
    {
        return equipmentId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("maintenanceItem", getMaintenanceItem())
            .append("maintenanceContent", getMaintenanceContent())
            .append("maintenanceStandards", getMaintenanceStandards())
            .append("maintenanceCycle", getMaintenanceCycle())
            .append("archivesId", getArchivesId())
            .append("equipmentId", getEquipmentId())
            .toString();
    }
}
