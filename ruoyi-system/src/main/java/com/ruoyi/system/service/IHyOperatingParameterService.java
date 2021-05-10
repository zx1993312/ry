package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyOperatingParameter;

/**
 * 运行参数Service接口
 * 
 * @author Administrator
 * @date 2021-05-10
 */
public interface IHyOperatingParameterService 
{
    /**
     * 查询运行参数
     * 
     * @param id 运行参数ID
     * @return 运行参数
     */
    public HyOperatingParameter selectHyOperatingParameterById(Long id);

    /**
     * 查询运行参数列表
     * 
     * @param hyOperatingParameter 运行参数
     * @return 运行参数集合
     */
    public List<HyOperatingParameter> selectHyOperatingParameterList(HyOperatingParameter hyOperatingParameter);

    /**
     * 新增运行参数
     * 
     * @param hyOperatingParameter 运行参数
     * @return 结果
     */
    public int insertHyOperatingParameter(HyOperatingParameter hyOperatingParameter);

    /**
     * 修改运行参数
     * 
     * @param hyOperatingParameter 运行参数
     * @return 结果
     */
    public int updateHyOperatingParameter(HyOperatingParameter hyOperatingParameter);

    /**
     * 批量删除运行参数
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyOperatingParameterByIds(String ids);

    /**
     * 删除运行参数信息
     * 
     * @param id 运行参数ID
     * @return 结果
     */
    public int deleteHyOperatingParameterById(Long id);
}
