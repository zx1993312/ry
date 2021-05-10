package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyTechnical;

/**
 * 技术参数Service接口
 * 
 * @author Administrator
 * @date 2021-05-10
 */
public interface IHyTechnicalService 
{
    /**
     * 查询技术参数
     * 
     * @param id 技术参数ID
     * @return 技术参数
     */
    public HyTechnical selectHyTechnicalById(Long id);

    /**
     * 查询技术参数列表
     * 
     * @param hyTechnical 技术参数
     * @return 技术参数集合
     */
    public List<HyTechnical> selectHyTechnicalList(HyTechnical hyTechnical);

    /**
     * 新增技术参数
     * 
     * @param hyTechnical 技术参数
     * @return 结果
     */
    public int insertHyTechnical(HyTechnical hyTechnical);

    /**
     * 修改技术参数
     * 
     * @param hyTechnical 技术参数
     * @return 结果
     */
    public int updateHyTechnical(HyTechnical hyTechnical);

    /**
     * 批量删除技术参数
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyTechnicalByIds(String ids);

    /**
     * 删除技术参数信息
     * 
     * @param id 技术参数ID
     * @return 结果
     */
    public int deleteHyTechnicalById(Long id);
}
