package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyHouseInfMapper;
import com.ruoyi.system.domain.HyHouseInf;
import com.ruoyi.system.service.IHyHouseInfService;
import com.ruoyi.common.core.text.Convert;

/**
 * 房屋登记Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Service
public class HyHouseInfServiceImpl implements IHyHouseInfService 
{
    @Autowired
    private HyHouseInfMapper hyHouseInfMapper;

    /**
     * 查询房屋登记
     * 
     * @param id 房屋登记ID
     * @return 房屋登记
     */
    @Override
    public HyHouseInf selectHyHouseInfById(Long id)
    {
        return hyHouseInfMapper.selectHyHouseInfById(id);
    }

    /**
     * 查询房屋登记列表
     * 
     * @param hyHouseInf 房屋登记
     * @return 房屋登记
     */
    @Override
    public List<HyHouseInf> selectHyHouseInfList(HyHouseInf hyHouseInf)
    {
        return hyHouseInfMapper.selectHyHouseInfList(hyHouseInf);
    }

    /**
     * 新增房屋登记
     * 
     * @param hyHouseInf 房屋登记
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertHyHouseInf(HyHouseInf hyHouseInf)
    {
        return hyHouseInfMapper.insertHyHouseInf(hyHouseInf);
    }

    /**
     * 修改房屋登记
     * 
     * @param hyHouseInf 房屋登记
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateHyHouseInf(HyHouseInf hyHouseInf)
    {
        return hyHouseInfMapper.updateHyHouseInf(hyHouseInf);
    }

    /**
     * 删除房屋登记对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteHyHouseInfByIds(String ids)
    {
        return hyHouseInfMapper.deleteHyHouseInfByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除房屋登记信息
     * 
     * @param id 房屋登记ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteHyHouseInfById(Long id)
    {
        return hyHouseInfMapper.deleteHyHouseInfById(id);
    }
}
