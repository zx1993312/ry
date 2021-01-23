package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyProportionSet;

/**
 * 收费比例设置Service接口
 * 
 * @author Administrator
 * @date 2021-01-23
 */
public interface IHyProportionSetService 
{
    /**
     * 查询收费比例设置
     * 
     * @param id 收费比例设置ID
     * @return 收费比例设置
     */
    public HyProportionSet selectHyProportionSetById(Long id);

    /**
     * 查询收费比例设置列表
     * 
     * @param hyProportionSet 收费比例设置
     * @return 收费比例设置集合
     */
    public List<HyProportionSet> selectHyProportionSetList(HyProportionSet hyProportionSet);

    /**
     * 新增收费比例设置
     * 
     * @param hyProportionSet 收费比例设置
     * @return 结果
     */
    public int insertHyProportionSet(HyProportionSet hyProportionSet);

    /**
     * 修改收费比例设置
     * 
     * @param hyProportionSet 收费比例设置
     * @return 结果
     */
    public int updateHyProportionSet(HyProportionSet hyProportionSet);

    /**
     * 批量删除收费比例设置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyProportionSetByIds(String ids);

    /**
     * 删除收费比例设置信息
     * 
     * @param id 收费比例设置ID
     * @return 结果
     */
    public int deleteHyProportionSetById(Long id);
}
