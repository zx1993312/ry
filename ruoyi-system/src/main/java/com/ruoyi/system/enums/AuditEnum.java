package com.ruoyi.system.enums;

import lombok.Getter;

@Getter
public enum AuditEnum {
	Reviewed(0,"已审核"),Not_reviewed(1,"未审核");
	private int examine;
	private String value;
	
	AuditEnum(int examine, String value){
		this.examine=examine;
		this.value=value;
	} 
	
	public static String getValue(int examine) {
		for(AuditEnum ae:AuditEnum.values()) {
			if(ae.examine==examine) {
				return ae.value;
			}
		}
		
		
		return null;
	}

}
