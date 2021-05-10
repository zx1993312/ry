package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 所属设备及配件附件对象 hy_accessories
 * 
 * @author Administrator
 * @date 2021-05-10
 */
public class HyAccessories extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 所属设备id */
    private Long id;

    /** 主要性能参数 */
    @Excel(name = "主要性能参数")
    private String performanceParameters;

    /** 设备档案id */
    @Excel(name = "设备档案id")
    private Long archivesId;
    
    /** 设备档案表 */
    @Excel(name = "设备档案表")
    private HyEquipmentArchives hyEquipmentArchives;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPerformanceParameters(String performanceParameters) 
    {
        this.performanceParameters = performanceParameters;
    }

    public String getPerformanceParameters() 
    {
        return performanceParameters;
    }
    public void setArchivesId(Long archivesId) 
    {
        this.archivesId = archivesId;
    }

    public Long getArchivesId() 
    {
        return archivesId;
    }

    public HyEquipmentArchives getHyEquipmentArchives() {
		return hyEquipmentArchives;
	}

	public void setHyEquipmentArchives(HyEquipmentArchives hyEquipmentArchives) {
		this.hyEquipmentArchives = hyEquipmentArchives;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("performanceParameters", getPerformanceParameters())
            .append("archivesId", getArchivesId())
            .append("hyEquipmentArchives", getHyEquipmentArchives())
            .toString();
    }
}
