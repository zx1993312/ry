package com.ruoyi.system.enums;

import lombok.Getter;

@Getter
public enum CalculationMethodEnum {
	
	BILLING_AREA_AND_UNIT_PRICE(0,"计费面积*单价");
	
	
	private int calculationMethod;
	private String value;
	
	CalculationMethodEnum(int calculationMethod,String value){
		this.calculationMethod=calculationMethod;
		this.value=value;
	}
	public static String getValue(int calculationMethod) {
		for(CalculationMethodEnum cm: CalculationMethodEnum.values()) {
			if(cm.calculationMethod==calculationMethod) {
				return cm.value;
			}
		}
		return null;
	}
}
