package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 退款申请对象 hy_refund
 * 
 * @author Administrator
 * @date 2021-05-29
 */
public class HyRefund extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** $column.columnComment */
	private Long id;

	/** 申请编号 */
	@Excel(name = "申请编号")
	private String applyNumber;

	/** 退款总金额 */
	@Excel(name = "退款总金额")
	private Long refundAmount;

	/** 违约金 */
	@Excel(name = "违约金")
	private Long damages;

	/** 退款金额 */
	@Excel(name = "退款金额")
	private Long refundMoney;

	/** 违约金退款 */
	@Excel(name = "违约金退款")
	private Long refundDamages;

	/** 退款原因 */
	@Excel(name = "退款原因")
	private String refundReasons;

	/** CollectionId */
	@Excel(name = "CollectionId")
	private Long collectionId;

	/** 是否审核 */
	private Integer isExamine;
	
	/** 费用退款备注*/
	private String refundRemark;
	
	/** 退款凭据类别*/
	private String refundVoucher;
	
	/** 领款人*/
	private String payee;
	
	/** 退款人*/
	private String refunder;
	
	/** 退款方式*/
	private String refundMethod;
	
	/** 退款凭据票号*/
	private String refundVoucherNo;
	
	/** 身份证号*/
	private String idCard;

	/** 验收人*/
	private String acceptancePerson;
	
	/** 收款管理表 */
	private HyCollection hyCollection;

	/** 业主登记表 */
	private HyOwnerRegistration hyOwnerRegistration;

	/** 房屋登记表 */
	private HyHouseInf hyHouseInf;

	/** 中间表(房屋和费用) */
	private HouseAndCost houseAndCost;

	/** 费用表 */
	private HyCost hyCost;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApplyNumber() {
		return applyNumber;
	}

	public void setApplyNumber(String applyNumber) {
		this.applyNumber = applyNumber;
	}

	public Long getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(Long refundAmount) {
		this.refundAmount = refundAmount;
	}

	public Long getDamages() {
		return damages;
	}

	public void setDamages(Long damages) {
		this.damages = damages;
	}

	public Long getRefundMoney() {
		return refundMoney;
	}

	public void setRefundMoney(Long refundMoney) {
		this.refundMoney = refundMoney;
	}

	public Long getRefundDamages() {
		return refundDamages;
	}

	public void setRefundDamages(Long refundDamages) {
		this.refundDamages = refundDamages;
	}

	public String getRefundReasons() {
		return refundReasons;
	}

	public void setRefundReasons(String refundReasons) {
		this.refundReasons = refundReasons;
	}

	public Long getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(Long collectionId) {
		this.collectionId = collectionId;
	}

	public Integer getIsExamine() {
		return isExamine;
	}

	public void setIsExamine(Integer isExamine) {
		this.isExamine = isExamine;
	}

	public String getRefundRemark() {
		return refundRemark;
	}

	public void setRefundRemark(String refundRemark) {
		this.refundRemark = refundRemark;
	}

	public String getRefundVoucher() {
		return refundVoucher;
	}

	public void setRefundVoucher(String refundVoucher) {
		this.refundVoucher = refundVoucher;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getRefunder() {
		return refunder;
	}

	public void setRefunder(String refunder) {
		this.refunder = refunder;
	}

	public String getRefundMethod() {
		return refundMethod;
	}

	public void setRefundMethod(String refundMethod) {
		this.refundMethod = refundMethod;
	}

	public String getRefundVoucherNo() {
		return refundVoucherNo;
	}

	public void setRefundVoucherNo(String refundVoucherNo) {
		this.refundVoucherNo = refundVoucherNo;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getAcceptancePerson() {
		return acceptancePerson;
	}

	public void setAcceptancePerson(String acceptancePerson) {
		this.acceptancePerson = acceptancePerson;
	}

	public HyCollection getHyCollection() {
		return hyCollection;
	}

	public void setHyCollection(HyCollection hyCollection) {
		this.hyCollection = hyCollection;
	}

	public HyOwnerRegistration getHyOwnerRegistration() {
		return hyOwnerRegistration;
	}

	public void setHyOwnerRegistration(HyOwnerRegistration hyOwnerRegistration) {
		this.hyOwnerRegistration = hyOwnerRegistration;
	}

	public HyHouseInf getHyHouseInf() {
		return hyHouseInf;
	}

	public void setHyHouseInf(HyHouseInf hyHouseInf) {
		this.hyHouseInf = hyHouseInf;
	}

	public HouseAndCost getHouseAndCost() {
		return houseAndCost;
	}

	public void setHouseAndCost(HouseAndCost houseAndCost) {
		this.houseAndCost = houseAndCost;
	}

	public HyCost getHyCost() {
		return hyCost;
	}

	public void setHyCost(HyCost hyCost) {
		this.hyCost = hyCost;
	}

	@Override
	public String toString() {
		return "HyRefund [id=" + id + ", applyNumber=" + applyNumber + ", refundAmount=" + refundAmount + ", damages="
				+ damages + ", refundMoney=" + refundMoney + ", refundDamages=" + refundDamages + ", refundReasons="
				+ refundReasons + ", collectionId=" + collectionId + ", isExamine=" + isExamine + ", refundRemark="
				+ refundRemark + ", refundVoucher=" + refundVoucher + ", payee=" + payee + ", refunder=" + refunder
				+ ", refundMethod=" + refundMethod + ", refundVoucherNo=" + refundVoucherNo + ", idCard=" + idCard
				+ ", acceptancePerson=" + acceptancePerson + ", hyCollection=" + hyCollection + ", hyOwnerRegistration="
				+ hyOwnerRegistration + ", hyHouseInf=" + hyHouseInf + ", houseAndCost=" + houseAndCost + ", hyCost="
				+ hyCost + "]";
	}
}