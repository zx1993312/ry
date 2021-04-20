package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyDelivery;

/**
 * 出库管理Service接口
 * 
 * @author Administrator
 * @date 2021-04-20
 */
public interface IHyDeliveryService 
{
    /**
     * 查询出库管理
     * 
     * @param id 出库管理ID
     * @return 出库管理
     */
    public HyDelivery selectHyDeliveryById(Long id);

    /**
     * 查询出库管理列表
     * 
     * @param hyDelivery 出库管理
     * @return 出库管理集合
     */
    public List<HyDelivery> selectHyDeliveryList(HyDelivery hyDelivery);

    /**
     * 新增出库管理
     * 
     * @param hyDelivery 出库管理
     * @return 结果
     */
    public int insertHyDelivery(HyDelivery hyDelivery);

    /**
     * 修改出库管理
     * 
     * @param hyDelivery 出库管理
     * @return 结果
     */
    public int updateHyDelivery(HyDelivery hyDelivery);

    /**
     * 批量删除出库管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyDeliveryByIds(String ids);

    /**
     * 删除出库管理信息
     * 
     * @param id 出库管理ID
     * @return 结果
     */
    public int deleteHyDeliveryById(Long id);
}
