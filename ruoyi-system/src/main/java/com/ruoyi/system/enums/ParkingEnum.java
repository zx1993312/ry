package com.ruoyi.system.enums;

import lombok.Getter;

@Getter
public enum ParkingEnum {

	STATE(0, "已使用"), DISSTATE(1, "未使用");

	private int type;
	private String value;

	private ParkingEnum(int type, String value) {
		this.type = type;
		this.value = value;
	}

	public static String getValue(int type) {
		for (ParkingEnum pe : ParkingEnum.values()) {
			if (pe.type == type) {
				return pe.value;
			}
		}
		return String.valueOf(type);

	}
}
