package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyCheckTypeMapper;
import com.ruoyi.system.domain.HyCheckType;
import com.ruoyi.system.service.IHyCheckTypeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 巡检类型Service业务层处理
 * 
 * @author Administrator
 * @date 2021-07-20
 */
@Service
public class HyCheckTypeServiceImpl implements IHyCheckTypeService 
{
    @Autowired
    private HyCheckTypeMapper hyCheckTypeMapper;

    /**
     * 查询巡检类型
     * 
     * @param id 巡检类型ID
     * @return 巡检类型
     */
    @Override
    public HyCheckType selectHyCheckTypeById(Long id)
    {
        return hyCheckTypeMapper.selectHyCheckTypeById(id);
    }

    /**
     * 查询巡检类型列表
     * 
     * @param hyCheckType 巡检类型
     * @return 巡检类型
     */
    @Override
    public List<HyCheckType> selectHyCheckTypeList(HyCheckType hyCheckType)
    {
        return hyCheckTypeMapper.selectHyCheckTypeList(hyCheckType);
    }

    /**
     * 新增巡检类型
     * 
     * @param hyCheckType 巡检类型
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyCheckType(HyCheckType hyCheckType)
    {
        return hyCheckTypeMapper.insertHyCheckType(hyCheckType);
    }

    /**
     * 修改巡检类型
     * 
     * @param hyCheckType 巡检类型
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyCheckType(HyCheckType hyCheckType)
    {
        return hyCheckTypeMapper.updateHyCheckType(hyCheckType);
    }

    /**
     * 删除巡检类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCheckTypeByIds(String ids)
    {
        return hyCheckTypeMapper.deleteHyCheckTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除巡检类型信息
     * 
     * @param id 巡检类型ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCheckTypeById(Long id)
    {
        return hyCheckTypeMapper.deleteHyCheckTypeById(id);
    }
}
