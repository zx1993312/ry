package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyStockRecordMapper;
import com.ruoyi.system.domain.HyStockRecord;
import com.ruoyi.system.service.IHyStockRecordService;
import com.ruoyi.common.core.text.Convert;

/**
 * 出入库记录Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-20
 */
@Service
public class HyStockRecordServiceImpl implements IHyStockRecordService 
{
    @Autowired
    private HyStockRecordMapper hyStockRecordMapper;

    /**
     * 查询出入库记录
     * 
     * @param id 出入库记录ID
     * @return 出入库记录
     */
    @Override
    public HyStockRecord selectHyStockRecordById(Long id)
    {
        return hyStockRecordMapper.selectHyStockRecordById(id);
    }

    /**
     * 查询出入库记录列表
     * 
     * @param hyStockRecord 出入库记录
     * @return 出入库记录
     */
    @Override
    public List<HyStockRecord> selectHyStockRecordList(HyStockRecord hyStockRecord)
    {
        return hyStockRecordMapper.selectHyStockRecordList(hyStockRecord);
    }

    /**
     * 新增出入库记录
     * 
     * @param hyStockRecord 出入库记录
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyStockRecord(HyStockRecord hyStockRecord)
    {
        return hyStockRecordMapper.insertHyStockRecord(hyStockRecord);
    }

    /**
     * 修改出入库记录
     * 
     * @param hyStockRecord 出入库记录
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyStockRecord(HyStockRecord hyStockRecord)
    {
        return hyStockRecordMapper.updateHyStockRecord(hyStockRecord);
    }

    /**
     * 删除出入库记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyStockRecordByIds(String ids)
    {
        return hyStockRecordMapper.deleteHyStockRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除出入库记录信息
     * 
     * @param id 出入库记录ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyStockRecordById(Long id)
    {
        return hyStockRecordMapper.deleteHyStockRecordById(id);
    }
}
