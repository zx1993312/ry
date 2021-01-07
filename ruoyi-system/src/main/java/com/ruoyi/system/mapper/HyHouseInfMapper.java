package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyHouseInf;

/**
 * 房屋登记Mapper接口
 * 
 * @author Administrator
 * @date 2021-01-06
 */
public interface HyHouseInfMapper 
{
    /**
     * 查询房屋登记
     * 
     * @param id 房屋登记ID
     * @return 房屋登记
     */
    public HyHouseInf selectHyHouseInfById(Long id);

    /**
     * 查询房屋登记列表
     * 
     * @param hyHouseInf 房屋登记
     * @return 房屋登记集合
     */
    public List<HyHouseInf> selectHyHouseInfList(HyHouseInf hyHouseInf);

    /**
     * 新增房屋登记
     * 
     * @param hyHouseInf 房屋登记
     * @return 结果
     */
    public int insertHyHouseInf(HyHouseInf hyHouseInf);

    /**
     * 修改房屋登记
     * 
     * @param hyHouseInf 房屋登记
     * @return 结果
     */
    public int updateHyHouseInf(HyHouseInf hyHouseInf);

    /**
     * 删除房屋登记
     * 
     * @param id 房屋登记ID
     * @return 结果
     */
    public int deleteHyHouseInfById(Long id);

    /**
     * 批量删除房屋登记
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyHouseInfByIds(String[] ids);
}
