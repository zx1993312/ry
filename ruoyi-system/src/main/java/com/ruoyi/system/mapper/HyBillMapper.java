package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.HyBill;

/**
 * 台账管理物料列Mapper接口
 * 
 * @author Administrator
 * @date 2021-04-20
 */
public interface HyBillMapper 
{
    /**
     * 查询台账管理物料列
     * 
     * @param id 台账管理物料列ID
     * @return 台账管理物料列
     */
    public HyBill selectHyBillById(Long id);

    /**
     * 查询台账管理物料列列表
     * 
     * @param hyBill 台账管理物料列
     * @return 台账管理物料列集合
     */
    public List<HyBill> selectHyBillList(HyBill hyBill);

    /**
     * 新增台账管理物料列
     * 
     * @param hyBill 台账管理物料列
     * @return 结果
     */
    public int insertHyBill(HyBill hyBill);

    /**
     * 修改台账管理物料列
     * 
     * @param hyBill 台账管理物料列
     * @return 结果
     */
    public int updateHyBill(HyBill hyBill);

    /**
     * 删除台账管理物料列
     * 
     * @param id 台账管理物料列ID
     * @return 结果
     */
    public int deleteHyBillById(Long id);

    /**
     * 批量删除台账管理物料列
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyBillByIds(String[] ids);
    
}
