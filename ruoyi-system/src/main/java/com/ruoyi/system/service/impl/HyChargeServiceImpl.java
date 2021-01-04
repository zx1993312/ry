package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HyChargeMapper;
import com.ruoyi.system.domain.HyCharge;
import com.ruoyi.system.service.IHyChargeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 收费比例设置Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
@Service
public class HyChargeServiceImpl implements IHyChargeService 
{
    @Autowired
    private HyChargeMapper hyChargeMapper;

    /**
     * 查询收费比例设置
     * 
     * @param id 收费比例设置ID
     * @return 收费比例设置
     */
    @Override
    public HyCharge selectHyChargeById(Long id)
    {
        return hyChargeMapper.selectHyChargeById(id);
    }

    /**
     * 查询收费比例设置列表
     * 
     * @param hyCharge 收费比例设置
     * @return 收费比例设置
     */
    @Override
    public List<HyCharge> selectHyChargeList(HyCharge hyCharge)
    {
        return hyChargeMapper.selectHyChargeList(hyCharge);
    }

    /**
     * 新增收费比例设置
     * 
     * @param hyCharge 收费比例设置
     * @return 结果
     */
    @Override
    public int insertHyCharge(HyCharge hyCharge)
    {
        return hyChargeMapper.insertHyCharge(hyCharge);
    }

    /**
     * 修改收费比例设置
     * 
     * @param hyCharge 收费比例设置
     * @return 结果
     */
    @Override
    public int updateHyCharge(HyCharge hyCharge)
    {
        return hyChargeMapper.updateHyCharge(hyCharge);
    }

    /**
     * 删除收费比例设置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHyChargeByIds(String ids)
    {
        return hyChargeMapper.deleteHyChargeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除收费比例设置信息
     * 
     * @param id 收费比例设置ID
     * @return 结果
     */
    @Override
    public int deleteHyChargeById(Long id)
    {
        return hyChargeMapper.deleteHyChargeById(id);
    }
}
