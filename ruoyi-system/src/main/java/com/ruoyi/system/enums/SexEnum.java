package com.ruoyi.system.enums;

import lombok.Getter;

@Getter
public enum SexEnum {

	MAN(0, "男"), WOMAN(1, "女"), NOKONW(2, "未知");

	private int sex;
	private String value;

	SexEnum(int sex, String value) {
		this.sex = sex;
		this.value = value;
	}

	public static String getValue(int sex) {
		for (SexEnum se : SexEnum.values()) {
			if (se.sex == sex) {
				return se.value;
			}

		}
		return String.valueOf(sex);
	}
}
