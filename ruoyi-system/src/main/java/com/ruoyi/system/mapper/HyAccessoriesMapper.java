package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyAccessories;

/**
 * 所属设备及配件附件Mapper接口
 * 
 * @author Administrator
 * @date 2021-05-10
 */
public interface HyAccessoriesMapper 
{
    /**
     * 查询所属设备及配件附件
     * 
     * @param id 所属设备及配件附件ID
     * @return 所属设备及配件附件
     */
    public HyAccessories selectHyAccessoriesById(Long id);

    /**
     * 查询所属设备及配件附件列表
     * 
     * @param hyAccessories 所属设备及配件附件
     * @return 所属设备及配件附件集合
     */
    public List<HyAccessories> selectHyAccessoriesList(HyAccessories hyAccessories);

    /**
     * 新增所属设备及配件附件
     * 
     * @param hyAccessories 所属设备及配件附件
     * @return 结果
     */
    public int insertHyAccessories(HyAccessories hyAccessories);

    /**
     * 修改所属设备及配件附件
     * 
     * @param hyAccessories 所属设备及配件附件
     * @return 结果
     */
    public int updateHyAccessories(HyAccessories hyAccessories);

    /**
     * 删除所属设备及配件附件
     * 
     * @param id 所属设备及配件附件ID
     * @return 结果
     */
    public int deleteHyAccessoriesById(Long id);

    /**
     * 批量删除所属设备及配件附件
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyAccessoriesByIds(String[] ids);
}
