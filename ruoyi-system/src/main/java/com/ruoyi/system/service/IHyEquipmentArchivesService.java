package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyEquipmentArchives;

/**
 * 设备档案Service接口
 * 
 * @author Administrator
 * @date 2021-05-08
 */
public interface IHyEquipmentArchivesService 
{
    /**
     * 查询设备档案
     * 
     * @param id 设备档案ID
     * @return 设备档案
     */
    public HyEquipmentArchives selectHyEquipmentArchivesById(Long id);

    /**
     * 查询设备档案列表
     * 
     * @param hyEquipmentArchives 设备档案
     * @return 设备档案集合
     */
    public List<HyEquipmentArchives> selectHyEquipmentArchivesList(HyEquipmentArchives hyEquipmentArchives);

    /**
     * 新增设备档案
     * 
     * @param hyEquipmentArchives 设备档案
     * @return 结果
     */
    public int insertHyEquipmentArchives(HyEquipmentArchives hyEquipmentArchives);

    /**
     * 修改设备档案
     * 
     * @param hyEquipmentArchives 设备档案
     * @return 结果
     */
    public int updateHyEquipmentArchives(HyEquipmentArchives hyEquipmentArchives);

    /**
     * 批量删除设备档案
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyEquipmentArchivesByIds(String ids);

    /**
     * 删除设备档案信息
     * 
     * @param id 设备档案ID
     * @return 结果
     */
    public int deleteHyEquipmentArchivesById(Long id);
}
