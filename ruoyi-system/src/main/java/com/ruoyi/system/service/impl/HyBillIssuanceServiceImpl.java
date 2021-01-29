package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyBillIssuanceMapper;
import com.ruoyi.system.domain.HyBillIssuance;
import com.ruoyi.system.service.IHyBillIssuanceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 票据发放Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Service
public class HyBillIssuanceServiceImpl implements IHyBillIssuanceService 
{
    @Autowired
    private HyBillIssuanceMapper hyBillIssuanceMapper;

    /**
     * 查询票据发放
     * 
     * @param id 票据发放ID
     * @return 票据发放
     */
    @Override
    public HyBillIssuance selectHyBillIssuanceById(Long id)
    {
        return hyBillIssuanceMapper.selectHyBillIssuanceById(id);
    }

    /**
     * 查询票据发放列表
     * 
     * @param hyBillIssuance 票据发放
     * @return 票据发放
     */
    @Override
    public List<HyBillIssuance> selectHyBillIssuanceList(HyBillIssuance hyBillIssuance)
    {
        return hyBillIssuanceMapper.selectHyBillIssuanceList(hyBillIssuance);
    }

    /**
     * 新增票据发放
     * 
     * @param hyBillIssuance 票据发放
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertHyBillIssuance(HyBillIssuance hyBillIssuance)
    {
        return hyBillIssuanceMapper.insertHyBillIssuance(hyBillIssuance);
    }

    /**
     * 修改票据发放
     * 
     * @param hyBillIssuance 票据发放
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateHyBillIssuance(HyBillIssuance hyBillIssuance)
    {
        return hyBillIssuanceMapper.updateHyBillIssuance(hyBillIssuance);
    }

    /**
     * 删除票据发放对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteHyBillIssuanceByIds(String ids)
    {
        return hyBillIssuanceMapper.deleteHyBillIssuanceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除票据发放信息
     * 
     * @param id 票据发放ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteHyBillIssuanceById(Long id)
    {
        return hyBillIssuanceMapper.deleteHyBillIssuanceById(id);
    }
}
