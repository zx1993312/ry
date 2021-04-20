package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyCheck;

/**
 * 盘点员Service接口
 * 
 * @author Administrator
 * @date 2021-04-20
 */
public interface IHyCheckService 
{
    /**
     * 查询盘点员
     * 
     * @param id 盘点员ID
     * @return 盘点员
     */
    public HyCheck selectHyCheckById(Long id);

    /**
     * 查询盘点员列表
     * 
     * @param hyCheck 盘点员
     * @return 盘点员集合
     */
    public List<HyCheck> selectHyCheckList(HyCheck hyCheck);

    /**
     * 新增盘点员
     * 
     * @param hyCheck 盘点员
     * @return 结果
     */
    public int insertHyCheck(HyCheck hyCheck);

    /**
     * 修改盘点员
     * 
     * @param hyCheck 盘点员
     * @return 结果
     */
    public int updateHyCheck(HyCheck hyCheck);

    /**
     * 批量删除盘点员
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyCheckByIds(String ids);

    /**
     * 删除盘点员信息
     * 
     * @param id 盘点员ID
     * @return 结果
     */
    public int deleteHyCheckById(Long id);
}
