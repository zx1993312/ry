package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyDamagesMapper;
import com.ruoyi.system.domain.HyDamages;
import com.ruoyi.system.service.IHyDamagesService;
import com.ruoyi.common.core.text.Convert;

/**
 * 违约金Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-28
 */
@Service
public class HyDamagesServiceImpl implements IHyDamagesService 
{
    @Autowired
    private HyDamagesMapper hyDamagesMapper;

    /**
     * 查询违约金
     * 
     * @param id 违约金ID
     * @return 违约金
     */
    @Override
    public HyDamages selectHyDamagesById(Long id)
    {
        return hyDamagesMapper.selectHyDamagesById(id);
    }

    /**
     * 查询违约金列表
     * 
     * @param hyDamages 违约金
     * @return 违约金
     */
    @Override
    public List<HyDamages> selectHyDamagesList(HyDamages hyDamages)
    {
        return hyDamagesMapper.selectHyDamagesList(hyDamages);
    }

    /**
     * 新增违约金
     * 
     * @param hyDamages 违约金
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertHyDamages(HyDamages hyDamages)
    {
        return hyDamagesMapper.insertHyDamages(hyDamages);
    }

    /**
     * 修改违约金
     * 
     * @param hyDamages 违约金
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateHyDamages(HyDamages hyDamages)
    {
        return hyDamagesMapper.updateHyDamages(hyDamages);
    }

    /**
     * 删除违约金对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteHyDamagesByIds(String ids)
    {
        return hyDamagesMapper.deleteHyDamagesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除违约金信息
     * 
     * @param id 违约金ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteHyDamagesById(Long id)
    {
        return hyDamagesMapper.deleteHyDamagesById(id);
    }
}
