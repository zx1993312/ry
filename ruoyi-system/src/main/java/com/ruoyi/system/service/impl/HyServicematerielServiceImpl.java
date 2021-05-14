package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyServicematerielMapper;
import com.ruoyi.system.domain.HyServicemateriel;
import com.ruoyi.system.service.IHyServicematerielService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备维修物料Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-13
 */
@Service
public class HyServicematerielServiceImpl implements IHyServicematerielService 
{
    @Autowired
    private HyServicematerielMapper hyServicematerielMapper;

    /**
     * 查询设备维修物料
     * 
     * @param id 设备维修物料ID
     * @return 设备维修物料
     */
    @Override
    public HyServicemateriel selectHyServicematerielById(Long id)
    {
        return hyServicematerielMapper.selectHyServicematerielById(id);
    }

    /**
     * 查询设备维修物料列表
     * 
     * @param hyServicemateriel 设备维修物料
     * @return 设备维修物料
     */
    @Override
    public List<HyServicemateriel> selectHyServicematerielList(HyServicemateriel hyServicemateriel)
    {
        return hyServicematerielMapper.selectHyServicematerielList(hyServicemateriel);
    }

    /**
     * 新增设备维修物料
     * 
     * @param hyServicemateriel 设备维修物料
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyServicemateriel(HyServicemateriel hyServicemateriel)
    {
        return hyServicematerielMapper.insertHyServicemateriel(hyServicemateriel);
    }

    /**
     * 修改设备维修物料
     * 
     * @param hyServicemateriel 设备维修物料
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyServicemateriel(HyServicemateriel hyServicemateriel)
    {
        return hyServicematerielMapper.updateHyServicemateriel(hyServicemateriel);
    }

    /**
     * 删除设备维修物料对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyServicematerielByIds(String ids)
    {
        return hyServicematerielMapper.deleteHyServicematerielByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备维修物料信息
     * 
     * @param id 设备维修物料ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyServicematerielById(Long id)
    {
        return hyServicematerielMapper.deleteHyServicematerielById(id);
    }
}
