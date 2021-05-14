package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyTransfers;

/**
 * 设备调拨一览Mapper接口
 * 
 * @author Administrator
 * @date 2021-05-14
 */
public interface HyTransfersMapper 
{
    /**
     * 查询设备调拨一览
     * 
     * @param id 设备调拨一览ID
     * @return 设备调拨一览
     */
    public HyTransfers selectHyTransfersById(Long id);

    /**
     * 查询设备调拨一览列表
     * 
     * @param hyTransfers 设备调拨一览
     * @return 设备调拨一览集合
     */
    public List<HyTransfers> selectHyTransfersList(HyTransfers hyTransfers);

    /**
     * 新增设备调拨一览
     * 
     * @param hyTransfers 设备调拨一览
     * @return 结果
     */
    public int insertHyTransfers(HyTransfers hyTransfers);

    /**
     * 修改设备调拨一览
     * 
     * @param hyTransfers 设备调拨一览
     * @return 结果
     */
    public int updateHyTransfers(HyTransfers hyTransfers);

    /**
     * 删除设备调拨一览
     * 
     * @param id 设备调拨一览ID
     * @return 结果
     */
    public int deleteHyTransfersById(Long id);

    /**
     * 批量删除设备调拨一览
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyTransfersByIds(String[] ids);
}
