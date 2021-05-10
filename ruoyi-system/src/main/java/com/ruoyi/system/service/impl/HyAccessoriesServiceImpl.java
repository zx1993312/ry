package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyAccessoriesMapper;
import com.ruoyi.system.domain.HyAccessories;
import com.ruoyi.system.service.IHyAccessoriesService;
import com.ruoyi.common.core.text.Convert;

/**
 * 所属设备及配件附件Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-10
 */
@Service
public class HyAccessoriesServiceImpl implements IHyAccessoriesService 
{
    @Autowired
    private HyAccessoriesMapper hyAccessoriesMapper;

    /**
     * 查询所属设备及配件附件
     * 
     * @param id 所属设备及配件附件ID
     * @return 所属设备及配件附件
     */
    @Override
    public HyAccessories selectHyAccessoriesById(Long id)
    {
        return hyAccessoriesMapper.selectHyAccessoriesById(id);
    }

    /**
     * 查询所属设备及配件附件列表
     * 
     * @param hyAccessories 所属设备及配件附件
     * @return 所属设备及配件附件
     */
    @Override
    public List<HyAccessories> selectHyAccessoriesList(HyAccessories hyAccessories)
    {
        return hyAccessoriesMapper.selectHyAccessoriesList(hyAccessories);
    }

    /**
     * 新增所属设备及配件附件
     * 
     * @param hyAccessories 所属设备及配件附件
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyAccessories(HyAccessories hyAccessories)
    {
        return hyAccessoriesMapper.insertHyAccessories(hyAccessories);
    }

    /**
     * 修改所属设备及配件附件
     * 
     * @param hyAccessories 所属设备及配件附件
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyAccessories(HyAccessories hyAccessories)
    {
        return hyAccessoriesMapper.updateHyAccessories(hyAccessories);
    }

    /**
     * 删除所属设备及配件附件对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyAccessoriesByIds(String ids)
    {
        return hyAccessoriesMapper.deleteHyAccessoriesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除所属设备及配件附件信息
     * 
     * @param id 所属设备及配件附件ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyAccessoriesById(Long id)
    {
        return hyAccessoriesMapper.deleteHyAccessoriesById(id);
    }
}
