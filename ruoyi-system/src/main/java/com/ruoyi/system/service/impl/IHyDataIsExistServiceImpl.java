package com.ruoyi.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.mapper.HyCommonMapper;
import com.ruoyi.system.service.IHyDataIsExistService;
import com.ruoyi.system.utils.HyDataUtil;

/**
 * IHyDataIsExistService实现类
 * 
 * @author Administrator
 *
 */
@Service
public class IHyDataIsExistServiceImpl implements IHyDataIsExistService {

	@Autowired
	private HyCommonMapper hyCommonMapper;

	/**
	 * 校验数据是否重复
	 * 
	 * @param tableName 表名
	 * @param fieldName 字段名
	 * @param data      数据
	 * @return
	 */
	@Override
	public Object selectHyDataIsExist(String tableName, String fieldName, Object param) {
		return hyCommonMapper.selectHyDataIsExist(HyDataUtil.setData(tableName, fieldName, param));
	}

}
