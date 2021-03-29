package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDictData;

public interface ISystemHouseInfStateService {
	
	
	public List<SysDictData> selectDictDataList(SysDictData dictData);

	public List<SysDictData> selectDictDataListOr(SysDictData dictData);

	public String selectDictLabel(String dictType, String dictValue);

	public SysDictData selectDictDataById(Long dictCode);

	public int deleteDictDataByIds(String ids);

	public int insertDictData(SysDictData dictData);

	public int updateDictData(SysDictData dictData);

}
