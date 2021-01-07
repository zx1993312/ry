package com.ruoyi.system.enums;

import lombok.Getter;

@Getter
public enum ControlEnum {

	YES(0,"是"),NO(1,"否"), SAME_MONTH(2,"当月"),NEXT_MONTH(3,"次月"),WHOLE(4,"整"),HORN(5,"角"),BRANCH(6,"分");
	
	private int control;
	private String value;
	
	ControlEnum(int control,String value){
		this.control=control;
		this.value=value;
	}
	
	public static String getValue(int control) {
		for (ControlEnum ce : ControlEnum.values()) {
			if(ce.control==control) {
				return  ce.value;
			}
		}
		return null;
	}
	
}
