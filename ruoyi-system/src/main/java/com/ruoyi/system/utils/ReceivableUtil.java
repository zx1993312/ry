package com.ruoyi.system.utils;

import java.math.BigDecimal;

public class ReceivableUtil {
	
	

	public static BigDecimal getReceivable(BigDecimal calculationStandard,String costItems,BigDecimal bilingArea) {
		BigDecimal AmountReceivable = new BigDecimal("0.0");
		BigDecimal month = new BigDecimal("12.0");
		if("物业费".equals(costItems)) {
			AmountReceivable = calculationStandard.multiply(bilingArea).multiply(month);
		}else if("生活垃圾处理费".equals(costItems)) {
			AmountReceivable = calculationStandard.multiply(month);
		}else if("装修垃圾清运费".equals(costItems)) {
			AmountReceivable = calculationStandard.multiply(bilingArea);
		}else if("预存水费".equals(costItems)) {
			AmountReceivable = calculationStandard;
		}else if("预存电费".equals(costItems)) {
			AmountReceivable = calculationStandard;
		}
		
		return AmountReceivable;
	}	
		
}
