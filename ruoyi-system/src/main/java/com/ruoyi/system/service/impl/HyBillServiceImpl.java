package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyBillMapper;
import com.ruoyi.system.domain.HyBill;
import com.ruoyi.system.service.IHyBillService;
import com.ruoyi.common.core.text.Convert;

/**
 * 台账管理物料列Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-20
 */
@Service
public class HyBillServiceImpl implements IHyBillService 
{
    @Autowired
    private HyBillMapper hyBillMapper;

    /**
     * 查询台账管理物料列
     * 
     * @param id 台账管理物料列ID
     * @return 台账管理物料列
     */
    @Override
    public HyBill selectHyBillById(Long id)
    {
        return hyBillMapper.selectHyBillById(id);
    }

    /**
     * 查询台账管理物料列列表
     * 
     * @param hyBill 台账管理物料列
     * @return 台账管理物料列
     */
    @Override
    public List<HyBill> selectHyBillList(HyBill hyBill)
    {
        return hyBillMapper.selectHyBillList(hyBill);
    }

    /**
     * 新增台账管理物料列
     * 
     * @param hyBill 台账管理物料列
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyBill(HyBill hyBill)
    {
        return hyBillMapper.insertHyBill(hyBill);
    }

    /**
     * 修改台账管理物料列
     * 
     * @param hyBill 台账管理物料列
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyBill(HyBill hyBill)
    {
        return hyBillMapper.updateHyBill(hyBill);
    }

    /**
     * 删除台账管理物料列对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyBillByIds(String ids)
    {
        return hyBillMapper.deleteHyBillByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除台账管理物料列信息
     * 
     * @param id 台账管理物料列ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyBillById(Long id)
    {
        return hyBillMapper.deleteHyBillById(id);
    }
}
