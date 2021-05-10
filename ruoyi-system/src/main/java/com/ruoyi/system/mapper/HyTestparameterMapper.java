package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyTestparameter;

/**
 * 检测参数Mapper接口
 * 
 * @author Administrator
 * @date 2021-05-10
 */
public interface HyTestparameterMapper 
{
    /**
     * 查询检测参数
     * 
     * @param id 检测参数ID
     * @return 检测参数
     */
    public HyTestparameter selectHyTestparameterById(Long id);

    /**
     * 查询检测参数列表
     * 
     * @param hyTestparameter 检测参数
     * @return 检测参数集合
     */
    public List<HyTestparameter> selectHyTestparameterList(HyTestparameter hyTestparameter);

    /**
     * 新增检测参数
     * 
     * @param hyTestparameter 检测参数
     * @return 结果
     */
    public int insertHyTestparameter(HyTestparameter hyTestparameter);

    /**
     * 修改检测参数
     * 
     * @param hyTestparameter 检测参数
     * @return 结果
     */
    public int updateHyTestparameter(HyTestparameter hyTestparameter);

    /**
     * 删除检测参数
     * 
     * @param id 检测参数ID
     * @return 结果
     */
    public int deleteHyTestparameterById(Long id);

    /**
     * 批量删除检测参数
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyTestparameterByIds(String[] ids);
}
