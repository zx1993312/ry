package com.ruoyi.system.enums;

import lombok.Getter;

@Getter
public enum StateEnum {
	UNSOLD(0, "未售"), RECEIVED_ROOM(1, "已接房"), RENOVATION(2, "装修"), SOLD_BUT_NOT_RECEIVED(3, "已售未接房"), CHECK_IN(4, "已住");
	private int state;// 状态
	private String value;// 值

	StateEnum(int state, String value) {
		this.state = state;
		this.value = value;
	}

	public static String getValue(int state) {
		for (StateEnum sta : StateEnum.values()) {
			if (sta.state == state) {
				return sta.value;
			}
		}
		return null;
	}
}
