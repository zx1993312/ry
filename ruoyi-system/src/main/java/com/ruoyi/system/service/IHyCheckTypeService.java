package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyCheckType;

/**
 * 巡检类型Service接口
 * 
 * @author Administrator
 * @date 2021-07-20
 */
public interface IHyCheckTypeService 
{
    /**
     * 查询巡检类型
     * 
     * @param id 巡检类型ID
     * @return 巡检类型
     */
    public HyCheckType selectHyCheckTypeById(Long id);

    /**
     * 查询巡检类型列表
     * 
     * @param hyCheckType 巡检类型
     * @return 巡检类型集合
     */
    public List<HyCheckType> selectHyCheckTypeList(HyCheckType hyCheckType);

    /**
     * 新增巡检类型
     * 
     * @param hyCheckType 巡检类型
     * @return 结果
     */
    public int insertHyCheckType(HyCheckType hyCheckType);

    /**
     * 修改巡检类型
     * 
     * @param hyCheckType 巡检类型
     * @return 结果
     */
    public int updateHyCheckType(HyCheckType hyCheckType);

    /**
     * 批量删除巡检类型
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyCheckTypeByIds(String ids);

    /**
     * 删除巡检类型信息
     * 
     * @param id 巡检类型ID
     * @return 结果
     */
    public int deleteHyCheckTypeById(Long id);
}
