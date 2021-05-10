package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyEquipmentArchivesMapper;
import com.ruoyi.system.domain.HyEquipmentArchives;
import com.ruoyi.system.service.IHyEquipmentArchivesService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备档案Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-08
 */
@Service
public class HyEquipmentArchivesServiceImpl implements IHyEquipmentArchivesService 
{
    @Autowired
    private HyEquipmentArchivesMapper hyEquipmentArchivesMapper;

    /**
     * 查询设备档案
     * 
     * @param id 设备档案ID
     * @return 设备档案
     */
    @Override
    public HyEquipmentArchives selectHyEquipmentArchivesById(Long id)
    {
        return hyEquipmentArchivesMapper.selectHyEquipmentArchivesById(id);
    }

    /**
     * 查询设备档案列表
     * 
     * @param hyEquipmentArchives 设备档案
     * @return 设备档案
     */
    @Override
    public List<HyEquipmentArchives> selectHyEquipmentArchivesList(HyEquipmentArchives hyEquipmentArchives)
    {
        return hyEquipmentArchivesMapper.selectHyEquipmentArchivesList(hyEquipmentArchives);
    }

    /**
     * 新增设备档案
     * 
     * @param hyEquipmentArchives 设备档案
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyEquipmentArchives(HyEquipmentArchives hyEquipmentArchives)
    {
        return hyEquipmentArchivesMapper.insertHyEquipmentArchives(hyEquipmentArchives);
    }

    /**
     * 修改设备档案
     * 
     * @param hyEquipmentArchives 设备档案
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyEquipmentArchives(HyEquipmentArchives hyEquipmentArchives)
    {
        return hyEquipmentArchivesMapper.updateHyEquipmentArchives(hyEquipmentArchives);
    }

    /**
     * 删除设备档案对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyEquipmentArchivesByIds(String ids)
    {
        return hyEquipmentArchivesMapper.deleteHyEquipmentArchivesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备档案信息
     * 
     * @param id 设备档案ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyEquipmentArchivesById(Long id)
    {
        return hyEquipmentArchivesMapper.deleteHyEquipmentArchivesById(id);
    }
}
