package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HyFeeRemissionMapper;
import com.ruoyi.system.domain.HyFeeRemission;
import com.ruoyi.system.service.IHyFeeRemissionService;
import com.ruoyi.common.core.text.Convert;

/**
 * 费用减免Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-13
 */
@Service
public class HyFeeRemissionServiceImpl implements IHyFeeRemissionService 
{
    @Autowired
    private HyFeeRemissionMapper hyFeeRemissionMapper;

    /**
     * 查询费用减免
     * 
     * @param id 费用减免ID
     * @return 费用减免
     */
    @Override
    public HyFeeRemission selectHyFeeRemissionById(Long id)
    {
        return hyFeeRemissionMapper.selectHyFeeRemissionById(id);
    }

    /**
     * 查询费用减免列表
     * 
     * @param hyFeeRemission 费用减免
     * @return 费用减免
     */
    @Override
    public List<HyFeeRemission> selectHyFeeRemissionList(HyFeeRemission hyFeeRemission)
    {
        return hyFeeRemissionMapper.selectHyFeeRemissionList(hyFeeRemission);
    }

    /**
     * 新增费用减免
     * 
     * @param hyFeeRemission 费用减免
     * @return 结果
     */
    @Override
    public int insertHyFeeRemission(HyFeeRemission hyFeeRemission)
    {
        return hyFeeRemissionMapper.insertHyFeeRemission(hyFeeRemission);
    }

    /**
     * 修改费用减免
     * 
     * @param hyFeeRemission 费用减免
     * @return 结果
     */
    @Override
    public int updateHyFeeRemission(HyFeeRemission hyFeeRemission)
    {
        return hyFeeRemissionMapper.updateHyFeeRemission(hyFeeRemission);
    }

    /**
     * 删除费用减免对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHyFeeRemissionByIds(String ids)
    {
        return hyFeeRemissionMapper.deleteHyFeeRemissionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除费用减免信息
     * 
     * @param id 费用减免ID
     * @return 结果
     */
    @Override
    public int deleteHyFeeRemissionById(Long id)
    {
        return hyFeeRemissionMapper.deleteHyFeeRemissionById(id);
    }
}
