package com.ruoyi.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyDataIsExist;
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
public class HyDataIsExistServiceImpl implements IHyDataIsExistService {

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
		Object obj = HyDataUtil.setData(HyDataIsExist.class, tableName, fieldName, String.valueOf(param));
		return hyCommonMapper.selectHyDataIsExist((HyDataIsExist) obj);
	}

}
