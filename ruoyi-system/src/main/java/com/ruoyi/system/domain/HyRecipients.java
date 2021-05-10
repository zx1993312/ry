package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * 接收员对象 hy_recipients
 * 
 * @author Administrator
 * @date 2021-04-13
 */
public class HyRecipients extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 接收员id */
    private Long id;

    /** 人员类型 */
    @Excel(name = "人员类型")
    private String personType;
    
    /** 选择物业 */
    @Excel(name = "选择物业")
    private String recipientsProperty;

    /** 选择项目 */
    @Excel(name = "选择项目")
    private String recipientsParent;
    
    /** 选择部门 */
    @Excel(name = "选择部门")
    private String recipientsDept;

    /** 选择员工 */
    @Excel(name = "选择员工")
    private String recipientsEmployee;

    /** 电话 */
    @Excel(name = "电话")
    private String recipientsPhone;

    /** 通知方式 */
    @Excel(name = "通知方式")
    private String notificationWay;
    
    /** 通知类型*/
    @Excel(name = "通知类型")
    private String notificationType;

    /** 省/直辖市 */
    @Excel(name = "省/直辖市")
    private String recipientsProvince;

    /** 市/直辖区 */
    @Excel(name = "市/直辖区")
    private String recipientsCity;

    /** 区/县 */
    @Excel(name = "区/县")
    private String recipientsArea;
    
    /** 员工表 */
    @Excel(name = "员工表")
    private SysUser sysUser;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPersonType(String personType) 
    {
        this.personType = personType;
    }

    public String getPersonType() 
    {
        return personType;
    }
    public String getRecipientsProperty() {
		return recipientsProperty;
	}

	public void setRecipientsProperty(String recipientsProperty) {
		this.recipientsProperty = recipientsProperty;
	}

	public String getRecipientsParent() {
		return recipientsParent;
	}

	public void setRecipientsParent(String recipientsParent) {
		this.recipientsParent = recipientsParent;
	}

	public void setRecipientsDept(String recipientsDept) 
    {
        this.recipientsDept = recipientsDept;
    }

    public String getRecipientsDept() 
    {
        return recipientsDept;
    }
    public void setRecipientsEmployee(String recipientsEmployee) 
    {
        this.recipientsEmployee = recipientsEmployee;
    }

    public String getRecipientsEmployee() 
    {
        return recipientsEmployee;
    }
    public String getRecipientsPhone() {
		return recipientsPhone;
	}

	public void setRecipientsPhone(String recipientsPhone) {
		this.recipientsPhone = recipientsPhone;
	}

	public void setNotificationWay(String notificationWay) 
    {
        this.notificationWay = notificationWay;
    }

    public String getNotificationWay() 
    {
        return notificationWay;
    }
    
    public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public void setRecipientsProvince(String recipientsProvince) 
    {
        this.recipientsProvince = recipientsProvince;
    }

    public String getRecipientsProvince() 
    {
        return recipientsProvince;
    }
    public void setRecipientsCity(String recipientsCity) 
    {
        this.recipientsCity = recipientsCity;
    }

    public String getRecipientsCity() 
    {
        return recipientsCity;
    }
    public void setRecipientsArea(String recipientsArea) 
    {
        this.recipientsArea = recipientsArea;
    }

    public String getRecipientsArea() 
    {
        return recipientsArea;
    }

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	@Override
	public String toString() {
		return "HyRecipients [id=" + id + ", personType=" + personType + ", recipientsProperty=" + recipientsProperty
				+ ", recipientsParent=" + recipientsParent + ", recipientsDept=" + recipientsDept
				+ ", recipientsEmployee=" + recipientsEmployee + ", recipientsPhone=" + recipientsPhone
				+ ", notificationWay=" + notificationWay + ", notificationType=" + notificationType
				+ ", recipientsProvince=" + recipientsProvince + ", recipientsCity=" + recipientsCity
				+ ", recipientsArea=" + recipientsArea + ", sysUser=" + sysUser + "]";
	}

	

}
