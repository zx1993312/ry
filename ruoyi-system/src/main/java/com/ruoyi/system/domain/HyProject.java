package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目列对象 hy_project
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
public class HyProject extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 主键 */
	private Long id;

	/** 项目名称 */
	@Excel(name = "项目名称")
	private String projectName;

	/** 组团区域id */
	@Excel(name = "组团区域id")
	private Long villageId;
	
	/** 组团区域表 */
	@Excel(name = "组团区域表")
	private HyGroupRegistration hyGroupRegistration;

	@Excel(name = "父id")
	private Integer parentId;

	@Excel(name = "")
	private String ancestors;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setVillageId(Long villageId) {
		this.villageId = villageId;
	}

	public Long getVillageId() {
		return villageId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getAncestors() {
		return ancestors;
	}

	public void setAncestors(String ancestors) {
		this.ancestors = ancestors;
	}
	public HyGroupRegistration getHyGroupRegistration() {
		return hyGroupRegistration;
	}

	public void setHyGroupRegistration(HyGroupRegistration hyGroupRegistration) {
		this.hyGroupRegistration = hyGroupRegistration;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId())
				.append("projectName", getProjectName()).append("villageId", getVillageId()).append("hyGroupRegistration", getHyGroupRegistration()).toString();
	}
}
