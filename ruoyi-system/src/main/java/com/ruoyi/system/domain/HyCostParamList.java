package com.ruoyi.system.domain;

import java.util.List;

import com.ruoyi.common.core.domain.BaseEntity;

public class HyCostParamList extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8449459863931058246L;

	public List<HyCashierDesk> list;

	public List<HyCashierDesk> getList() {
		return list;
	}

	public void setList(List<HyCashierDesk> list) {
		this.list = list;
	}

}
