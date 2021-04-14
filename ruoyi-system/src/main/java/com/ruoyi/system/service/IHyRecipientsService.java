package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyRecipients;

/**
 * 接收员Service接口
 * 
 * @author Administrator
 * @date 2021-04-13
 */
public interface IHyRecipientsService 
{
    /**
     * 查询接收员
     * 
     * @param id 接收员ID
     * @return 接收员
     */
    public HyRecipients selectHyRecipientsById(Long id);

    /**
     * 查询接收员列表
     * 
     * @param hyRecipients 接收员
     * @return 接收员集合
     */
    public List<HyRecipients> selectHyRecipientsList(HyRecipients hyRecipients);

    /**
     * 新增接收员
     * 
     * @param hyRecipients 接收员
     * @return 结果
     */
    public int insertHyRecipients(HyRecipients hyRecipients);

    /**
     * 修改接收员
     * 
     * @param hyRecipients 接收员
     * @return 结果
     */
    public int updateHyRecipients(HyRecipients hyRecipients);

    /**
     * 批量删除接收员
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyRecipientsByIds(String ids);

    /**
     * 删除接收员信息
     * 
     * @param id 接收员ID
     * @return 结果
     */
    public int deleteHyRecipientsById(Long id);
}
