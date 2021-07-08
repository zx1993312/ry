package com.ruoyi.system.utils;

import java.math.BigDecimal;

public class ReceivableUtil {

	/**
	 * @param calculationStandard 单价
	 * @param calculationMehod 计算方式
	 * @param bilingArea 计费面积
	 * @return
	 */
	public static BigDecimal getReceivable(BigDecimal calculationStandard,String calculationMehod,BigDecimal bilingArea) {
		BigDecimal AmountReceivable = new BigDecimal("0.00");
		BigDecimal month = new BigDecimal("12.00");
		if("按单价*计算面积每年计算".equals(calculationMehod)) {
			AmountReceivable = calculationStandard.multiply(bilingArea).multiply(month);
		}else if("按单价每年计算".equals(calculationMehod)) {
			AmountReceivable = calculationStandard.multiply(month);
		}else if("按单价*计费面积计算".equals(calculationMehod)) {
			AmountReceivable = calculationStandard.multiply(bilingArea);
		}else if("按定额计算".equals(calculationMehod)) {
			AmountReceivable = calculationStandard;
		}
		
		return AmountReceivable;
	}	
	public static BigDecimal getReceivable(BigDecimal calculationStandard,String calculationMehod,BigDecimal bilingArea,String months) {
		BigDecimal AmountReceivable = new BigDecimal("0.00");
		BigDecimal month = new BigDecimal(months);
		if("按单价*计算面积每年计算".equals(calculationMehod)) {
			AmountReceivable = calculationStandard.multiply(bilingArea).multiply(month);
		}else if("按单价每年计算".equals(calculationMehod)) {
			AmountReceivable = calculationStandard.multiply(month);
		}else if("按单价*计费面积计算".equals(calculationMehod)) {
			AmountReceivable = calculationStandard.multiply(bilingArea);
		}else if("按定额计算".equals(calculationMehod)) {
			AmountReceivable = calculationStandard;
		}
		
		return AmountReceivable;
	}	
		
}
