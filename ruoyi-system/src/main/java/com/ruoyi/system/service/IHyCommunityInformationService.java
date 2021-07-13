package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyCommunityInformation;

/**
 * 社区资询Service接口
 * 
 * @author Administrator
 * @date 2021-07-13
 */
public interface IHyCommunityInformationService 
{
    /**
     * 查询社区资询
     * 
     * @param id 社区资询ID
     * @return 社区资询
     */
    public HyCommunityInformation selectHyCommunityInformationById(Long id);

    /**
     * 查询社区资询列表
     * 
     * @param hyCommunityInformation 社区资询
     * @return 社区资询集合
     */
    public List<HyCommunityInformation> selectHyCommunityInformationList(HyCommunityInformation hyCommunityInformation);

    /**
     * 新增社区资询
     * 
     * @param hyCommunityInformation 社区资询
     * @return 结果
     */
    public int insertHyCommunityInformation(HyCommunityInformation hyCommunityInformation);

    /**
     * 修改社区资询
     * 
     * @param hyCommunityInformation 社区资询
     * @return 结果
     */
    public int updateHyCommunityInformation(HyCommunityInformation hyCommunityInformation);

    /**
     * 批量删除社区资询
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyCommunityInformationByIds(String ids);

    /**
     * 删除社区资询信息
     * 
     * @param id 社区资询ID
     * @return 结果
     */
    public int deleteHyCommunityInformationById(Long id);
}