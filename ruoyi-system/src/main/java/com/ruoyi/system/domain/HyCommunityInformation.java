package com.ruoyi.system.domain;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @author Administrator
 *
 */
public class HyCommunityInformation extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String informationType;
	
	private String source;
	
	private String title;
	
	private Date startTime;
	
	private Date effectiveTime;
	
	private String importantAnnouncement;
	
	private String state;
	
	private String historyOperator;
	
	private Date historyOperationTime;
	
	private String announcementScopeItems;
	
	private String noticeScopeBuilding;
	
	private String informationContent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInformationType() {
		return informationType;
	}

	public void setInformationType(String informationType) {
		this.informationType = informationType;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public String getImportantAnnouncement() {
		return importantAnnouncement;
	}

	public void setImportantAnnouncement(String importantAnnouncement) {
		this.importantAnnouncement = importantAnnouncement;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getHistoryOperator() {
		return historyOperator;
	}

	public void setHistoryOperator(String historyOperator) {
		this.historyOperator = historyOperator;
	}



	public String getAnnouncementScopeItems() {
		return announcementScopeItems;
	}

	public void setAnnouncementScopeItems(String announcementScopeItems) {
		this.announcementScopeItems = announcementScopeItems;
	}

	public String getNoticeScopeBuilding() {
		return noticeScopeBuilding;
	}

	public void setNoticeScopeBuilding(String noticeScopeBuilding) {
		this.noticeScopeBuilding = noticeScopeBuilding;
	}

	public String getInformationContent() {
		return informationContent;
	}

	public void setInformationContent(String informationContent) {
		this.informationContent = informationContent;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEffectiveTime() {
		return effectiveTime;
	}

	public void setEffectiveTime(Date effectiveTime) {
		this.effectiveTime = effectiveTime;
	}

	public Date getHistoryOperationTime() {
		return historyOperationTime;
	}

	public void setHistoryOperationTime(Date historyOperationTime) {
		this.historyOperationTime = historyOperationTime;
	}

	@Override
	public String toString() {
		return "HyCommunityInformation [id=" + id + ", informationType=" + informationType + ", source=" + source
				+ ", title=" + title + ", startTime=" + startTime + ", effectiveTime=" + effectiveTime
				+ ", importantAnnouncement=" + importantAnnouncement + ", state=" + state + ", historyOperator="
				+ historyOperator + ", historyOperationTime=" + historyOperationTime + ", announcementScopeItems="
				+ announcementScopeItems + ", noticeScopeBuilding=" + noticeScopeBuilding + ", informationContent="
				+ informationContent + ", getId()=" + getId() + ", getInformationType()=" + getInformationType()
				+ ", getSource()=" + getSource() + ", getTitle()=" + getTitle() + ", getImportantAnnouncement()="
				+ getImportantAnnouncement() + ", getState()=" + getState() + ", getHistoryOperator()="
				+ getHistoryOperator() + ", getAnnouncementScopeItems()=" + getAnnouncementScopeItems()
				+ ", getNoticeScopeBuilding()=" + getNoticeScopeBuilding() + ", getInformationContent()="
				+ getInformationContent() + ", getStartTime()=" + getStartTime() + ", getEffectiveTime()="
				+ getEffectiveTime() + ", getHistoryOperationTime()=" + getHistoryOperationTime()
				+ ", getSearchValue()=" + getSearchValue() + ", getCreateBy()=" + getCreateBy() + ", getCreateTime()="
				+ getCreateTime() + ", getUpdateBy()=" + getUpdateBy() + ", getUpdateTime()=" + getUpdateTime()
				+ ", getRemark()=" + getRemark() + ", getParams()=" + getParams() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	







	
	
	
	
}
