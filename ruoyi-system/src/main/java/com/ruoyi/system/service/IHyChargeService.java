package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyCharge;

/**
 * 收费比例设置Service接口
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
public interface IHyChargeService 
{
    /**
     * 查询收费比例设置
     * 
     * @param id 收费比例设置ID
     * @return 收费比例设置
     */
    public HyCharge selectHyChargeById(Long id);

    /**
     * 查询收费比例设置列表
     * 
     * @param hyCharge 收费比例设置
     * @return 收费比例设置集合
     */
    public List<HyCharge> selectHyChargeList(HyCharge hyCharge);

    /**
     * 新增收费比例设置
     * 
     * @param hyCharge 收费比例设置
     * @return 结果
     */
    public int insertHyCharge(HyCharge hyCharge);

    /**
     * 修改收费比例设置
     * 
     * @param hyCharge 收费比例设置
     * @return 结果
     */
    public int updateHyCharge(HyCharge hyCharge);

    /**
     * 批量删除收费比例设置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyChargeByIds(String ids);

    /**
     * 删除收费比例设置信息
     * 
     * @param id 收费比例设置ID
     * @return 结果
     */
    public int deleteHyChargeById(Long id);
}
