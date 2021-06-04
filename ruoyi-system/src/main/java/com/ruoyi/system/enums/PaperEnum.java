package com.ruoyi.system.enums;

import lombok.Getter;

@Getter
public enum PaperEnum {
	A4(598, 842), RECEIPT(708, 269);

	private double width;// 纸张宽

	private double height;// 纸张高

	PaperEnum(double width, double height) {
		this.width = width;
		this.height = height;
	}

}
