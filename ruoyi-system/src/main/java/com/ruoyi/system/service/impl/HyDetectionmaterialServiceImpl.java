package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyDetectionmaterialMapper;
import com.ruoyi.system.domain.HyDetectionmaterial;
import com.ruoyi.system.service.IHyDetectionmaterialService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备检测物料Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-14
 */
@Service
public class HyDetectionmaterialServiceImpl implements IHyDetectionmaterialService 
{
    @Autowired
    private HyDetectionmaterialMapper hyDetectionmaterialMapper;

    /**
     * 查询设备检测物料
     * 
     * @param id 设备检测物料ID
     * @return 设备检测物料
     */
    @Override
    public HyDetectionmaterial selectHyDetectionmaterialById(Long id)
    {
        return hyDetectionmaterialMapper.selectHyDetectionmaterialById(id);
    }

    /**
     * 查询设备检测物料列表
     * 
     * @param hyDetectionmaterial 设备检测物料
     * @return 设备检测物料
     */
    @Override
    public List<HyDetectionmaterial> selectHyDetectionmaterialList(HyDetectionmaterial hyDetectionmaterial)
    {
        return hyDetectionmaterialMapper.selectHyDetectionmaterialList(hyDetectionmaterial);
    }

    /**
     * 新增设备检测物料
     * 
     * @param hyDetectionmaterial 设备检测物料
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyDetectionmaterial(HyDetectionmaterial hyDetectionmaterial)
    {
        return hyDetectionmaterialMapper.insertHyDetectionmaterial(hyDetectionmaterial);
    }

    /**
     * 修改设备检测物料
     * 
     * @param hyDetectionmaterial 设备检测物料
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyDetectionmaterial(HyDetectionmaterial hyDetectionmaterial)
    {
        return hyDetectionmaterialMapper.updateHyDetectionmaterial(hyDetectionmaterial);
    }

    /**
     * 删除设备检测物料对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyDetectionmaterialByIds(String ids)
    {
        return hyDetectionmaterialMapper.deleteHyDetectionmaterialByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备检测物料信息
     * 
     * @param id 设备检测物料ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyDetectionmaterialById(Long id)
    {
        return hyDetectionmaterialMapper.deleteHyDetectionmaterialById(id);
    }
}
