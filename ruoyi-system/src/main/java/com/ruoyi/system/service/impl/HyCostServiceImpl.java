package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HyCostMapper;
import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.service.IHyCostService;
import com.ruoyi.common.core.text.Convert;

/**
 * 费用项目Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Service
public class HyCostServiceImpl implements IHyCostService 
{
    @Autowired
    private HyCostMapper hyCostMapper;

    /**
     * 查询费用项目
     * 
     * @param id 费用项目ID
     * @return 费用项目
     */
    @Override
    public HyCost selectHyCostById(Long id)
    {
        return hyCostMapper.selectHyCostById(id);
    }

    /**
     * 查询费用项目列表
     * 
     * @param hyCost 费用项目
     * @return 费用项目
     */
    @Override
    public List<HyCost> selectHyCostList(HyCost hyCost)
    {
        return hyCostMapper.selectHyCostList(hyCost);
    }

    /**
     * 新增费用项目
     * 
     * @param hyCost 费用项目
     * @return 结果
     */
    @Override
    public int insertHyCost(HyCost hyCost)
    {
        return hyCostMapper.insertHyCost(hyCost);
    }

    /**
     * 修改费用项目
     * 
     * @param hyCost 费用项目
     * @return 结果
     */
    @Override
    public int updateHyCost(HyCost hyCost)
    {
        return hyCostMapper.updateHyCost(hyCost);
    }

    /**
     * 删除费用项目对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHyCostByIds(String ids)
    {
        return hyCostMapper.deleteHyCostByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除费用项目信息
     * 
     * @param id 费用项目ID
     * @return 结果
     */
    @Override
    public int deleteHyCostById(Long id)
    {
        return hyCostMapper.deleteHyCostById(id);
    }
}
