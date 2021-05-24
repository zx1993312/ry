package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.system.annotation.EnumAnn;
import com.ruoyi.system.enums.ControlEnum;
import com.ruoyi.system.enums.SexEnum;

/**
 * 业主资料登记对象 hy_owner_registration
 * 
 * @author Administrator
 * @date 2021-01-09
 */
public class HyOwnerRegistration extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 业主名称 */
    @Excel(name = "业主名称")
    private String ownerName;

    /** 固定电话 */
    @Excel(name = "固定电话")
    private Long fixedTelephone;

    /** 移动电话 */
    @Excel(name = "移动电话")
    private Long mobilePhone;

    /** 证件号码 */
    @Excel(name = "证件号码")
    private String idCardNum;

    /** 供应商类别 */
    @Excel(name = "供应商类别")
    private Integer suplierCategory;

    /** 是否锁定 */
    @Excel(name = "是否锁定")
    @EnumAnn(enumClass=ControlEnum.class)
    private Integer lockedNot;

    /** 出入卡号 */
    @Excel(name = "出入卡号")
    private Long accessNum;

    /** 证件名称 */
    @Excel(name = "证件名称")
    private String certificateName;

    /** 客户类别 */
    @Excel(name = "客户类别")
    private Integer customerCategoy;

    /** 传真电话 */
    @Excel(name = "传真电话")
    private Long faxPhone;

    /** 联系地址 */
    @Excel(name = "联系地址")
    private String contactAddress;

    /** 邮政编码 */
    @Excel(name = "邮政编码")
    private Long postalCode;

    /** 收件人 */
    @Excel(name = "收件人")
    private String postalPreson;

    /** 电子邮件 */
    @Excel(name = "电子邮件")
    private String eMail;

    /** 绑定手机户名 */
    @Excel(name = "绑定手机户名")
    private String phoneAccount;

    /** 绑定手机号码 */
    @Excel(name = "绑定手机号码")
    private Long bindingPhoneNum;

    /** 共有业主 */
    @Excel(name = "共有业主")
    private String coOwner;

    /** 业主标识（个人/单位） */
    @Excel(name = "业主标识", readConverterExp = "个=人/单位")
    private Integer ownerIdentification;

    /** 姓 */
    @Excel(name = "姓")
    private String firName;

    /** 名 */
    @Excel(name = "名")
    private String secName;

    /** 性别 */
    @Excel(name = "性别")
    @EnumAnn(enumClass=SexEnum.class)
    private Integer gender;

    /** 国籍 */
    @Excel(name = "国籍")
    private String nationality;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthDate;

    /** 工作单位 */
    @Excel(name = "工作单位")
    private String workUnit;

    /** 职业 */
    @Excel(name = "职业")
    private String ownerJob;

    /** 兴趣爱好 */
    @Excel(name = "兴趣爱好")
    private String ownerHobby;

    /** 用户名 */
    @Excel(name = "用户名")
    private String ownerId;

    /** 纳税人识别号 */
    @Excel(name = "纳税人识别号")
    private String taxpayerNum;

    /** 地址、电话 */
    @Excel(name = "地址、电话")
    private String ownerAddPhone;

    /** 开户行及账号 */
    @Excel(name = "开户行及账号")
    private String bankAccount;

    /** 托收类别 */
    @Excel(name = "托收类别")
    private Integer collectionCategory;

    /** 银行行别 */
    @Excel(name = "银行行别")
    private Integer bankType;

    /** 开户行行号 */
    @Excel(name = "开户行行号")
    private Long bankNum;

    /** 银行户名 */
    @Excel(name = "银行户名")
    private String bankAccountName;
    
    /** 项目管理id */
    @Excel(name = "项目管理id")
    private Long projectId;
    
    /** 项目管理表 */
    @Excel(name = "项目管理表")
    private HyProject hyProject;
    
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOwnerName(String ownerName) 
    {
        this.ownerName = ownerName;
    }

    public String getOwnerName() 
    {
        return ownerName;
    }
    public void setFixedTelephone(Long fixedTelephone) 
    {
        this.fixedTelephone = fixedTelephone;
    }

    public Long getFixedTelephone() 
    {
        return fixedTelephone;
    }
    public void setMobilePhone(Long mobilePhone) 
    {
        this.mobilePhone = mobilePhone;
    }

    public Long getMobilePhone() 
    {
        return mobilePhone;
    }
    public void setIdCardNum(String idCardNum) 
    {
        this.idCardNum = idCardNum;
    }

    public String getIdCardNum() 
    {
        return idCardNum;
    }
    public void setSuplierCategory(Integer suplierCategory) 
    {
        this.suplierCategory = suplierCategory;
    }

    public Integer getSuplierCategory() 
    {
        return suplierCategory;
    }
    public void setLockedNot(Integer lockedNot) 
    {
        this.lockedNot = lockedNot;
    }

    public Integer getLockedNot() 
    {
        return lockedNot;
    }
    public void setAccessNum(Long accessNum) 
    {
        this.accessNum = accessNum;
    }

    public Long getAccessNum() 
    {
        return accessNum;
    }
    public void setCertificateName(String certificateName) 
    {
        this.certificateName = certificateName;
    }

    public String getCertificateName() 
    {
        return certificateName;
    }
    public void setCustomerCategoy(Integer customerCategoy) 
    {
        this.customerCategoy = customerCategoy;
    }

    public Integer getCustomerCategoy() 
    {
        return customerCategoy;
    }
    public void setFaxPhone(Long faxPhone) 
    {
        this.faxPhone = faxPhone;
    }

    public Long getFaxPhone() 
    {
        return faxPhone;
    }
    public void setContactAddress(String contactAddress) 
    {
        this.contactAddress = contactAddress;
    }

    public String getContactAddress() 
    {
        return contactAddress;
    }
    public void setPostalCode(Long postalCode) 
    {
        this.postalCode = postalCode;
    }

    public Long getPostalCode() 
    {
        return postalCode;
    }
    public void setPostalPreson(String postalPreson) 
    {
        this.postalPreson = postalPreson;
    }

    public String getPostalPreson() 
    {
        return postalPreson;
    }
    public void seteMail(String eMail) 
    {
        this.eMail = eMail;
    }

    public String geteMail() 
    {
        return eMail;
    }
    public void setPhoneAccount(String phoneAccount) 
    {
        this.phoneAccount = phoneAccount;
    }

    public String getPhoneAccount() 
    {
        return phoneAccount;
    }
    public void setBindingPhoneNum(Long bindingPhoneNum) 
    {
        this.bindingPhoneNum = bindingPhoneNum;
    }

    public Long getBindingPhoneNum() 
    {
        return bindingPhoneNum;
    }
    public void setCoOwner(String coOwner) 
    {
        this.coOwner = coOwner;
    }

    public String getCoOwner() 
    {
        return coOwner;
    }
    public void setOwnerIdentification(Integer ownerIdentification) 
    {
        this.ownerIdentification = ownerIdentification;
    }

    public Integer getOwnerIdentification() 
    {
        return ownerIdentification;
    }
    public void setFirName(String firName) 
    {
        this.firName = firName;
    }

    public String getFirName() 
    {
        return firName;
    }
    public void setSecName(String secName) 
    {
        this.secName = secName;
    }

    public String getSecName() 
    {
        return secName;
    }
    public void setGender(Integer gender) 
    {
        this.gender = gender;
    }

    public Integer getGender() 
    {
        return gender;
    }
    public void setNationality(String nationality) 
    {
        this.nationality = nationality;
    }

    public String getNationality() 
    {
        return nationality;
    }
    public void setBirthDate(Date birthDate) 
    {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() 
    {
        return birthDate;
    }
    public void setWorkUnit(String workUnit) 
    {
        this.workUnit = workUnit;
    }

    public String getWorkUnit() 
    {
        return workUnit;
    }
    public void setOwnerJob(String ownerJob) 
    {
        this.ownerJob = ownerJob;
    }

    public String getOwnerJob() 
    {
        return ownerJob;
    }
    public void setOwnerHobby(String ownerHobby) 
    {
        this.ownerHobby = ownerHobby;
    }

    public String getOwnerHobby() 
    {
        return ownerHobby;
    }
    public void setOwnerId(String ownerId) 
    {
        this.ownerId = ownerId;
    }

    public String getOwnerId() 
    {
        return ownerId;
    }
    public void setTaxpayerNum(String taxpayerNum) 
    {
        this.taxpayerNum = taxpayerNum;
    }

    public String getTaxpayerNum() 
    {
        return taxpayerNum;
    }
    public void setOwnerAddPhone(String ownerAddPhone) 
    {
        this.ownerAddPhone = ownerAddPhone;
    }

    public String getOwnerAddPhone() 
    {
        return ownerAddPhone;
    }
    public void setBankAccount(String bankAccount) 
    {
        this.bankAccount = bankAccount;
    }

    public String getBankAccount() 
    {
        return bankAccount;
    }
    public void setCollectionCategory(Integer collectionCategory) 
    {
        this.collectionCategory = collectionCategory;
    }

    public Integer getCollectionCategory() 
    {
        return collectionCategory;
    }
    public void setBankType(Integer bankType) 
    {
        this.bankType = bankType;
    }

    public Integer getBankType() 
    {
        return bankType;
    }
    public void setBankNum(Long bankNum) 
    {
        this.bankNum = bankNum;
    }

    public Long getBankNum() 
    {
        return bankNum;
    }
    public void setBankAccountName(String bankAccountName) 
    {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccountName() 
    {
        return bankAccountName;
    }

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public HyProject getHyProject() {
		return hyProject;
	}

	public void setHyProject(HyProject hyProject) {
		this.hyProject = hyProject;
	}


	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("ownerName", getOwnerName())
            .append("fixedTelephone", getFixedTelephone())
            .append("mobilePhone", getMobilePhone())
            .append("idCardNum", getIdCardNum())
            .append("suplierCategory", getSuplierCategory())
            .append("lockedNot", getLockedNot())
            .append("accessNum", getAccessNum())
            .append("certificateName", getCertificateName())
            .append("customerCategoy", getCustomerCategoy())
            .append("faxPhone", getFaxPhone())
            .append("contactAddress", getContactAddress())
            .append("postalCode", getPostalCode())
            .append("postalPreson", getPostalPreson())
            .append("eMail", geteMail())
            .append("phoneAccount", getPhoneAccount())
            .append("bindingPhoneNum", getBindingPhoneNum())
            .append("coOwner", getCoOwner())
            .append("ownerIdentification", getOwnerIdentification())
            .append("firName", getFirName())
            .append("secName", getSecName())
            .append("gender", getGender())
            .append("nationality", getNationality())
            .append("birthDate", getBirthDate())
            .append("workUnit", getWorkUnit())
            .append("ownerJob", getOwnerJob())
            .append("ownerHobby", getOwnerHobby())
            .append("ownerId", getOwnerId())
            .append("taxpayerNum", getTaxpayerNum())
            .append("ownerAddPhone", getOwnerAddPhone())
            .append("bankAccount", getBankAccount())
            .append("collectionCategory", getCollectionCategory())
            .append("bankType", getBankType())
            .append("bankNum", getBankNum())
            .append("bankAccountName", getBankAccountName())
            .append("projectId", getProjectId())
            .append("hyProject", getHyProject())
            .toString();
    }
}
