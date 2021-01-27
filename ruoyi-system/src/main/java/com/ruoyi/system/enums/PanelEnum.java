package com.ruoyi.system.enums;

import lombok.Getter;

@Getter
public enum PanelEnum {
	
	INVOICE(0,"收据"),RECEIPT(1,"发票"),CREDENTIAL(2,"凭据");
	
	private int panel;
	private String value;
	
	PanelEnum(int panel,String value){
		this.panel=panel;
		this.value=value;
	}
	
	public static String getValue(int panel) {
		for(PanelEnum pe:PanelEnum.values()) {
			if(pe.panel==panel) {
				return pe.value;
			}
		}
		return null;
	}
}
