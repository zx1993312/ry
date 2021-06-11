package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyWarehouseMapper;
import com.ruoyi.system.domain.HyWarehouse;
import com.ruoyi.system.service.IHyWarehouseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 仓库Service业务层处理
 * 
 * @author Administrator
 * @date 2021-06-11
 */
@Service
public class HyWarehouseServiceImpl implements IHyWarehouseService 
{
    @Autowired
    private HyWarehouseMapper hyWarehouseMapper;

    /**
     * 查询仓库
     * 
     * @param id 仓库ID
     * @return 仓库
     */
    @Override
    public HyWarehouse selectHyWarehouseById(Long id)
    {
        return hyWarehouseMapper.selectHyWarehouseById(id);
    }

    /**
     * 查询仓库列表
     * 
     * @param hyWarehouse 仓库
     * @return 仓库
     */
    @Override
    public List<HyWarehouse> selectHyWarehouseList(HyWarehouse hyWarehouse)
    {
        return hyWarehouseMapper.selectHyWarehouseList(hyWarehouse);
    }

    /**
     * 新增仓库
     * 
     * @param hyWarehouse 仓库
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyWarehouse(HyWarehouse hyWarehouse)
    {
        return hyWarehouseMapper.insertHyWarehouse(hyWarehouse);
    }

    /**
     * 修改仓库
     * 
     * @param hyWarehouse 仓库
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyWarehouse(HyWarehouse hyWarehouse)
    {
        return hyWarehouseMapper.updateHyWarehouse(hyWarehouse);
    }

    /**
     * 删除仓库对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyWarehouseByIds(String ids)
    {
        return hyWarehouseMapper.deleteHyWarehouseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除仓库信息
     * 
     * @param id 仓库ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyWarehouseById(Long id)
    {
        return hyWarehouseMapper.deleteHyWarehouseById(id);
    }
}
