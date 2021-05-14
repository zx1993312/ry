package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyServicemateriel;

/**
 * 设备维修物料Mapper接口
 * 
 * @author Administrator
 * @date 2021-05-13
 */
public interface HyServicematerielMapper 
{
    /**
     * 查询设备维修物料
     * 
     * @param id 设备维修物料ID
     * @return 设备维修物料
     */
    public HyServicemateriel selectHyServicematerielById(Long id);

    /**
     * 查询设备维修物料列表
     * 
     * @param hyServicemateriel 设备维修物料
     * @return 设备维修物料集合
     */
    public List<HyServicemateriel> selectHyServicematerielList(HyServicemateriel hyServicemateriel);

    /**
     * 新增设备维修物料
     * 
     * @param hyServicemateriel 设备维修物料
     * @return 结果
     */
    public int insertHyServicemateriel(HyServicemateriel hyServicemateriel);

    /**
     * 修改设备维修物料
     * 
     * @param hyServicemateriel 设备维修物料
     * @return 结果
     */
    public int updateHyServicemateriel(HyServicemateriel hyServicemateriel);

    /**
     * 删除设备维修物料
     * 
     * @param id 设备维修物料ID
     * @return 结果
     */
    public int deleteHyServicematerielById(Long id);

    /**
     * 批量删除设备维修物料
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyServicematerielByIds(String[] ids);
}
