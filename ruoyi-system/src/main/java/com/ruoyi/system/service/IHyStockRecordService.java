package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyStockRecord;

/**
 * 出入库记录Service接口
 * 
 * @author Administrator
 * @date 2021-04-20
 */
public interface IHyStockRecordService 
{
    /**
     * 查询出入库记录
     * 
     * @param id 出入库记录ID
     * @return 出入库记录
     */
    public HyStockRecord selectHyStockRecordById(Long id);

    /**
     * 查询出入库记录列表
     * 
     * @param hyStockRecord 出入库记录
     * @return 出入库记录集合
     */
    public List<HyStockRecord> selectHyStockRecordList(HyStockRecord hyStockRecord);

    /**
     * 新增出入库记录
     * 
     * @param hyStockRecord 出入库记录
     * @return 结果
     */
    public int insertHyStockRecord(HyStockRecord hyStockRecord);

    /**
     * 修改出入库记录
     * 
     * @param hyStockRecord 出入库记录
     * @return 结果
     */
    public int updateHyStockRecord(HyStockRecord hyStockRecord);

    /**
     * 批量删除出入库记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyStockRecordByIds(String ids);

    /**
     * 删除出入库记录信息
     * 
     * @param id 出入库记录ID
     * @return 结果
     */
    public int deleteHyStockRecordById(Long id);
}
