package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HySpecimenMapper;
import com.ruoyi.system.domain.HySpecimen;
import com.ruoyi.system.service.IHySpecimenService;
import com.ruoyi.common.core.text.Convert;

/**
 * 接收员Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-20
 */
@Service
public class HySpecimenServiceImpl implements IHySpecimenService 
{
    @Autowired
    private HySpecimenMapper hySpecimenMapper;

    /**
     * 查询接收员
     * 
     * @param id 接收员ID
     * @return 接收员
     */
    @Override
    public HySpecimen selectHySpecimenById(Long id)
    {
        return hySpecimenMapper.selectHySpecimenById(id);
    }

    /**
     * 查询接收员列表
     * 
     * @param hySpecimen 接收员
     * @return 接收员
     */
    @Override
    public List<HySpecimen> selectHySpecimenList(HySpecimen hySpecimen)
    {
        return hySpecimenMapper.selectHySpecimenList(hySpecimen);
    }

    /**
     * 新增接收员
     * 
     * @param hySpecimen 接收员
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHySpecimen(HySpecimen hySpecimen)
    {
        return hySpecimenMapper.insertHySpecimen(hySpecimen);
    }

    /**
     * 修改接收员
     * 
     * @param hySpecimen 接收员
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHySpecimen(HySpecimen hySpecimen)
    {
        return hySpecimenMapper.updateHySpecimen(hySpecimen);
    }

    /**
     * 删除接收员对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHySpecimenByIds(String ids)
    {
        return hySpecimenMapper.deleteHySpecimenByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除接收员信息
     * 
     * @param id 接收员ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHySpecimenById(Long id)
    {
        return hySpecimenMapper.deleteHySpecimenById(id);
    }
}
