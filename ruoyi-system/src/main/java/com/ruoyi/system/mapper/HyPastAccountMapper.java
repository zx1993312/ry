package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyPastAccount;

/**
 * 往期应收调账Mapper接口
 * 
 * @author Administrator
 * @date 2021-01-07
 */
public interface HyPastAccountMapper 
{
    /**
     * 查询往期应收调账
     * 
     * @param id 往期应收调账ID
     * @return 往期应收调账
     */
    public HyPastAccount selectHyPastAccountById(Long id);

    /**
     * 查询往期应收调账列表
     * 
     * @param hyPastAccount 往期应收调账
     * @return 往期应收调账集合
     */
    public List<HyPastAccount> selectHyPastAccountList(HyPastAccount hyPastAccount);

    /**
     * 新增往期应收调账
     * 
     * @param hyPastAccount 往期应收调账
     * @return 结果
     */
    public int insertHyPastAccount(HyPastAccount hyPastAccount);

    /**
     * 修改往期应收调账
     * 
     * @param hyPastAccount 往期应收调账
     * @return 结果
     */
    public int updateHyPastAccount(HyPastAccount hyPastAccount);

    /**
     * 删除往期应收调账
     * 
     * @param id 往期应收调账ID
     * @return 结果
     */
    public int deleteHyPastAccountById(Long id);

    /**
     * 批量删除往期应收调账
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyPastAccountByIds(String[] ids);
}
