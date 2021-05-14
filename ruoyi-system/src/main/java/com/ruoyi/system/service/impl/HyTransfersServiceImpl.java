package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyTransfersMapper;
import com.ruoyi.system.domain.HyTransfers;
import com.ruoyi.system.service.IHyTransfersService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备调拨一览Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-14
 */
@Service
public class HyTransfersServiceImpl implements IHyTransfersService 
{
    @Autowired
    private HyTransfersMapper hyTransfersMapper;

    /**
     * 查询设备调拨一览
     * 
     * @param id 设备调拨一览ID
     * @return 设备调拨一览
     */
    @Override
    public HyTransfers selectHyTransfersById(Long id)
    {
        return hyTransfersMapper.selectHyTransfersById(id);
    }

    /**
     * 查询设备调拨一览列表
     * 
     * @param hyTransfers 设备调拨一览
     * @return 设备调拨一览
     */
    @Override
    public List<HyTransfers> selectHyTransfersList(HyTransfers hyTransfers)
    {
        return hyTransfersMapper.selectHyTransfersList(hyTransfers);
    }

    /**
     * 新增设备调拨一览
     * 
     * @param hyTransfers 设备调拨一览
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyTransfers(HyTransfers hyTransfers)
    {
        return hyTransfersMapper.insertHyTransfers(hyTransfers);
    }

    /**
     * 修改设备调拨一览
     * 
     * @param hyTransfers 设备调拨一览
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyTransfers(HyTransfers hyTransfers)
    {
        return hyTransfersMapper.updateHyTransfers(hyTransfers);
    }

    /**
     * 删除设备调拨一览对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyTransfersByIds(String ids)
    {
        return hyTransfersMapper.deleteHyTransfersByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备调拨一览信息
     * 
     * @param id 设备调拨一览ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyTransfersById(Long id)
    {
        return hyTransfersMapper.deleteHyTransfersById(id);
    }
}
