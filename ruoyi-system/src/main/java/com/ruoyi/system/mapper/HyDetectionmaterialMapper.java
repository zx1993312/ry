package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyDetectionmaterial;

/**
 * 设备检测物料Mapper接口
 * 
 * @author Administrator
 * @date 2021-05-14
 */
public interface HyDetectionmaterialMapper 
{
    /**
     * 查询设备检测物料
     * 
     * @param id 设备检测物料ID
     * @return 设备检测物料
     */
    public HyDetectionmaterial selectHyDetectionmaterialById(Long id);

    /**
     * 查询设备检测物料列表
     * 
     * @param hyDetectionmaterial 设备检测物料
     * @return 设备检测物料集合
     */
    public List<HyDetectionmaterial> selectHyDetectionmaterialList(HyDetectionmaterial hyDetectionmaterial);

    /**
     * 新增设备检测物料
     * 
     * @param hyDetectionmaterial 设备检测物料
     * @return 结果
     */
    public int insertHyDetectionmaterial(HyDetectionmaterial hyDetectionmaterial);

    /**
     * 修改设备检测物料
     * 
     * @param hyDetectionmaterial 设备检测物料
     * @return 结果
     */
    public int updateHyDetectionmaterial(HyDetectionmaterial hyDetectionmaterial);

    /**
     * 删除设备检测物料
     * 
     * @param id 设备检测物料ID
     * @return 结果
     */
    public int deleteHyDetectionmaterialById(Long id);

    /**
     * 批量删除设备检测物料
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyDetectionmaterialByIds(String[] ids);
}
