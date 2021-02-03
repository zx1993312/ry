package com.ruoyi.system.enums;

import lombok.Getter;

@Getter
public enum AuditEnum {
	Reviewed(0, "已审核"), Not_reviewed(1, "未审核"), TAXPAYPER(2, "一般纳税人"), SMALL_TAXPAYPER(3, "小规模纳税人");
	private int examine;
	private String value;

	AuditEnum(int examine, String value) {
		this.examine = examine;
		this.value = value;
	}

	public static String getValue(int examine) {
		for (AuditEnum ae : AuditEnum.values()) {
			if (ae.examine == examine) {
				return ae.value;
			}
		}

		return String.valueOf(examine);
	}

}
