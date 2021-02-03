package com.ruoyi.system.enums;

import lombok.Getter;

@Getter
public enum EntryEnum {
	ISENTRY(0, "已入账"), DISENTRY(1, "未入账");

	private int entry;
	private String value;

	EntryEnum(int entry, String value) {
		this.entry = entry;
		this.value = value;
	}

	public static String getValue(int entry) {
		for (EntryEnum ee : EntryEnum.values()) {
			if (ee.entry == entry) {
				return ee.value;
			}
		}

		return String.valueOf(entry);
	}

}
