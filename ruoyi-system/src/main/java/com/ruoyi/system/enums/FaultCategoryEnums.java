package com.ruoyi.system.enums;

public enum FaultCategoryEnums {
	MECHANICAL_FAILURE("1", "机械故障"), EMERGENCY("2", "突发事件"), CIRCUIT_FAULT("3", "电路故障"), SIGN_REPORT("4", "签报"),
	INTERNAL_MAINTENANCE("5", "内部维修"), ROITINE_MAINTENANCE("6", "日常维修"), CONTRACT("7", "合同");

	private String key;
	private String value;

	FaultCategoryEnums(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public static String getValue(String key) {
		for (FaultCategoryEnums fce : FaultCategoryEnums.values()) {
			if (fce.key.equals(key)) {
				return fce.value;
			}
		}
		return key;
	}
}
