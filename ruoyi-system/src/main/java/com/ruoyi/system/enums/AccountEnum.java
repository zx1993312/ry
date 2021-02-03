package com.ruoyi.system.enums;

import lombok.Getter;

@Getter
public enum AccountEnum {
	
	WHALE(0,"景誉府1期"),FISHERMAN(1,"景誉府2期");
	
	private int manageProjects;
	private String value;
	
	AccountEnum(int manageProjects,String value){
		this.manageProjects=manageProjects;
		this.value=value;
	}
	
	
	public static String getValue(int manageProjects) {
		for(AccountEnum ae :AccountEnum.values()) {
			if(ae.manageProjects==manageProjects) {
				return ae.value;
			}
		}
		return String.valueOf(manageProjects);
	}
}
