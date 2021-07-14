package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyReminderNotice;

/**
 * 催缴通知Service接口
 * 
 * @author Administrator
 * @date 2021-07-14
 */
public interface IHyReminderNoticeService 
{
    /**
     * 查询催缴通知
     * 
     * @param id 催缴通知ID
     * @return 催缴通知
     */
    public HyReminderNotice selectHyReminderNoticeById(Long id);

    /**
     * 查询催缴通知列表
     * 
     * @param hyReminderNotice 催缴通知
     * @return 催缴通知集合
     */
    public List<HyReminderNotice> selectHyReminderNoticeList(HyReminderNotice hyReminderNotice);

    /**
     * 新增催缴通知
     * 
     * @param hyReminderNotice 催缴通知
     * @return 结果
     */
    public int insertHyReminderNotice(HyReminderNotice hyReminderNotice);

    /**
     * 修改催缴通知
     * 
     * @param hyReminderNotice 催缴通知
     * @return 结果
     */
    public int updateHyReminderNotice(HyReminderNotice hyReminderNotice);

    /**
     * 批量删除催缴通知
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyReminderNoticeByIds(String ids);

    /**
     * 删除催缴通知信息
     * 
     * @param id 催缴通知ID
     * @return 结果
     */
    public int deleteHyReminderNoticeById(Long id);
}
