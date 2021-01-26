package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyRevoke;

/**
 * 撤销操作Service接口
 * 
 * @author Administrator
 * @date 2021-01-26
 */
public interface IHyRevokeService 
{
    /**
     * 查询撤销操作
     * 
     * @param id 撤销操作ID
     * @return 撤销操作
     */
    public HyRevoke selectHyRevokeById(Long id);

    /**
     * 查询撤销操作列表
     * 
     * @param hyRevoke 撤销操作
     * @return 撤销操作集合
     */
    public List<HyRevoke> selectHyRevokeList(HyRevoke hyRevoke);

    /**
     * 新增撤销操作
     * 
     * @param hyRevoke 撤销操作
     * @return 结果
     */
    public int insertHyRevoke(HyRevoke hyRevoke);

    /**
     * 修改撤销操作
     * 
     * @param hyRevoke 撤销操作
     * @return 结果
     */
    public int updateHyRevoke(HyRevoke hyRevoke);

    /**
     * 批量删除撤销操作
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyRevokeByIds(String ids);

    /**
     * 删除撤销操作信息
     * 
     * @param id 撤销操作ID
     * @return 结果
     */
    public int deleteHyRevokeById(Long id);
}
