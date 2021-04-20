package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyDeliveryMapper;
import com.ruoyi.system.domain.HyDelivery;
import com.ruoyi.system.service.IHyDeliveryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 出库管理Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-20
 */
@Service
public class HyDeliveryServiceImpl implements IHyDeliveryService 
{
    @Autowired
    private HyDeliveryMapper hyDeliveryMapper;

    /**
     * 查询出库管理
     * 
     * @param id 出库管理ID
     * @return 出库管理
     */
    @Override
    public HyDelivery selectHyDeliveryById(Long id)
    {
        return hyDeliveryMapper.selectHyDeliveryById(id);
    }

    /**
     * 查询出库管理列表
     * 
     * @param hyDelivery 出库管理
     * @return 出库管理
     */
    @Override
    public List<HyDelivery> selectHyDeliveryList(HyDelivery hyDelivery)
    {
        return hyDeliveryMapper.selectHyDeliveryList(hyDelivery);
    }

    /**
     * 新增出库管理
     * 
     * @param hyDelivery 出库管理
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyDelivery(HyDelivery hyDelivery)
    {
        hyDelivery.setCreateTime(DateUtils.getNowDate());
        return hyDeliveryMapper.insertHyDelivery(hyDelivery);
    }

    /**
     * 修改出库管理
     * 
     * @param hyDelivery 出库管理
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyDelivery(HyDelivery hyDelivery)
    {
        return hyDeliveryMapper.updateHyDelivery(hyDelivery);
    }

    /**
     * 删除出库管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyDeliveryByIds(String ids)
    {
        return hyDeliveryMapper.deleteHyDeliveryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除出库管理信息
     * 
     * @param id 出库管理ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyDeliveryById(Long id)
    {
        return hyDeliveryMapper.deleteHyDeliveryById(id);
    }
}
