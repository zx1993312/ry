package com.ruoyi.system.enums;

public enum TypeEnums {
	EQUIPMENT_INSPECTION("1","设备巡检"),ORDER_INSPECTION("2","秩序巡检"),ENVIRONMENTAL_INSPECTION("3","环境巡检"),
	SECURITY_INSPECTION("4","安防巡检");
	
	private String key;
	private String value;
	
	
	private TypeEnums(String key, String value) {
		this.key = key;
		this.value = value;
	}


	public static String getValue(String key) {
		for (TypeEnums te : TypeEnums.values()) {
			if (te.key.equals(key)) {
				return te.value;
			}
		}
		return key;
	}
}
