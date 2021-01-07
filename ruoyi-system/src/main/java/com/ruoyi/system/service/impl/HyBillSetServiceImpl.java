package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HyBillSetMapper;
import com.ruoyi.system.domain.HyBillSet;
import com.ruoyi.system.service.IHyBillSetService;
import com.ruoyi.common.core.text.Convert;

/**
 * 票据设置Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Service
public class HyBillSetServiceImpl implements IHyBillSetService 
{
    @Autowired
    private HyBillSetMapper hyBillSetMapper;

    /**
     * 查询票据设置
     * 
     * @param id 票据设置ID
     * @return 票据设置
     */
    @Override
    public HyBillSet selectHyBillSetById(Long id)
    {
        return hyBillSetMapper.selectHyBillSetById(id);
    }

    /**
     * 查询票据设置列表
     * 
     * @param hyBillSet 票据设置
     * @return 票据设置
     */
    @Override
    public List<HyBillSet> selectHyBillSetList(HyBillSet hyBillSet)
    {
        return hyBillSetMapper.selectHyBillSetList(hyBillSet);
    }

    /**
     * 新增票据设置
     * 
     * @param hyBillSet 票据设置
     * @return 结果
     */
    @Override
    public int insertHyBillSet(HyBillSet hyBillSet)
    {
        return hyBillSetMapper.insertHyBillSet(hyBillSet);
    }

    /**
     * 修改票据设置
     * 
     * @param hyBillSet 票据设置
     * @return 结果
     */
    @Override
    public int updateHyBillSet(HyBillSet hyBillSet)
    {
        return hyBillSetMapper.updateHyBillSet(hyBillSet);
    }

    /**
     * 删除票据设置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHyBillSetByIds(String ids)
    {
        return hyBillSetMapper.deleteHyBillSetByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除票据设置信息
     * 
     * @param id 票据设置ID
     * @return 结果
     */
    @Override
    public int deleteHyBillSetById(Long id)
    {
        return hyBillSetMapper.deleteHyBillSetById(id);
    }
}
