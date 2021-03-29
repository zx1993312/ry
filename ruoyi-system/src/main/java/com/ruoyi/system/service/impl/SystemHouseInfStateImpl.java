package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DictUtils;
import com.ruoyi.system.mapper.SysDictDataMapper;
import com.ruoyi.system.service.ISystemHouseInfStateService;

@Service
public class SystemHouseInfStateImpl implements ISystemHouseInfStateService{
	@Autowired
	private SysDictDataMapper dictDataMapper;

	@Override
	public List<SysDictData> selectDictDataList(SysDictData dictData) {
		return dictDataMapper.selectDictDataList(dictData);
	}

	public List<SysDictData> selectDictDataListOr(SysDictData dictData) {
		dictData.setDictType("hy_delivery_status");
		return dictDataMapper.selectDictDataListOr(dictData);
	}

	@Override
	public String selectDictLabel(String dictType, String dictValue) {
		return dictDataMapper.selectDictLabel(dictType, dictValue);
	}

	@Override
	public SysDictData selectDictDataById(Long dictCode) {
		return dictDataMapper.selectDictDataById(dictCode);
	}

	@Override
	public int deleteDictDataByIds(String ids) {
		 int row = dictDataMapper.deleteDictDataByIds(Convert.toStrArray(ids));
	        if (row > 0)
	        {
	            DictUtils.clearDictCache();
	        }
	        return row;
	}

	@Override
	public int insertDictData(SysDictData dictData) {
	 	dictData.setDictType("hy_delivery_status");
        int row = dictDataMapper.insertDictData(dictData);
        if (row > 0)
        {
            DictUtils.clearDictCache();
        }
        return row;
	}

	@Override
	public int updateDictData(SysDictData dictData) {
		  int row = dictDataMapper.updateDictData(dictData);
	        if (row > 0)
	        {
	            DictUtils.clearDictCache();
	        }
	        return row;	}

}
