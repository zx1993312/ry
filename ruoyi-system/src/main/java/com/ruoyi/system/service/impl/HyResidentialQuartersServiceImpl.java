package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyResidentialQuartersMapper;
import com.ruoyi.system.domain.HyResidentialQuarters;
import com.ruoyi.system.service.IHyResidentialQuartersService;
import com.ruoyi.common.core.text.Convert;

/**
 * 小区Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-17
 */
@Service
public class HyResidentialQuartersServiceImpl implements IHyResidentialQuartersService 
{
    @Autowired
    private HyResidentialQuartersMapper hyResidentialQuartersMapper;

    /**
     * 查询小区
     * 
     * @param id 小区ID
     * @return 小区
     */
    @Override
    public HyResidentialQuarters selectHyResidentialQuartersById(Long id)
    {
        return hyResidentialQuartersMapper.selectHyResidentialQuartersById(id);
    }

    /**
     * 查询小区列表
     * 
     * @param hyResidentialQuarters 小区
     * @return 小区
     */
    @Override
    public List<HyResidentialQuarters> selectHyResidentialQuartersList(HyResidentialQuarters hyResidentialQuarters)
    {
        return hyResidentialQuartersMapper.selectHyResidentialQuartersList(hyResidentialQuarters);
    }

    /**
     * 新增小区
     * 
     * @param hyResidentialQuarters 小区
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyResidentialQuarters(HyResidentialQuarters hyResidentialQuarters)
    {
        return hyResidentialQuartersMapper.insertHyResidentialQuarters(hyResidentialQuarters);
    }

    /**
     * 修改小区
     * 
     * @param hyResidentialQuarters 小区
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyResidentialQuarters(HyResidentialQuarters hyResidentialQuarters)
    {
        return hyResidentialQuartersMapper.updateHyResidentialQuarters(hyResidentialQuarters);
    }

    /**
     * 删除小区对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyResidentialQuartersByIds(String ids)
    {
        return hyResidentialQuartersMapper.deleteHyResidentialQuartersByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除小区信息
     * 
     * @param id 小区ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyResidentialQuartersById(Long id)
    {
        return hyResidentialQuartersMapper.deleteHyResidentialQuartersById(id);
    }
}
