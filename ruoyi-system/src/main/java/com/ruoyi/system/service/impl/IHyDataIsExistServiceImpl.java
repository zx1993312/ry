package com.ruoyi.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.mapper.HyDataIsExistMapper;
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
	private HyDataIsExistMapper hyDataIsExistMapper;

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
		return hyDataIsExistMapper.selectHyDataIsExist(HyDataUtil.setData(tableName, fieldName, param));
	}

}
