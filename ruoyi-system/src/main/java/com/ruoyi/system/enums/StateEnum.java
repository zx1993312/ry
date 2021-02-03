package com.ruoyi.system.enums;

import lombok.Getter;

@Getter
public enum StateEnum {
	SOLD_NOT_RECEIVED(0, "已售未接房"), 
	UNSOLD(1,"未售"),
	RECEIVED_ROOM(2,"已接房"),
	RENOVATION(3,"装修"),
	CHECK_IN(4,"入住"),
	SOLD_VACANT(5,"已售空置"),
	UNSOLD_VACANCY(6,"未售空置");
	private int state;// 状态
	private String value;// 值

	StateEnum(int state,  String value) {
		this.state = state;
		this.value = value;
	}

	public static String getValue(int state) {
		for (StateEnum sta : StateEnum.values()) {
			if (sta.state == state) {
				return sta.value;
			}
		}
		return String.valueOf(state);
	}
	
}
