package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HySpecimen;

/**
 * 接收员Mapper接口
 * 
 * @author Administrator
 * @date 2021-04-20
 */
public interface HySpecimenMapper 
{
    /**
     * 查询接收员
     * 
     * @param id 接收员ID
     * @return 接收员
     */
    public HySpecimen selectHySpecimenById(Long id);

    /**
     * 查询接收员列表
     * 
     * @param hySpecimen 接收员
     * @return 接收员集合
     */
    public List<HySpecimen> selectHySpecimenList(HySpecimen hySpecimen);

    /**
     * 新增接收员
     * 
     * @param hySpecimen 接收员
     * @return 结果
     */
    public int insertHySpecimen(HySpecimen hySpecimen);

    /**
     * 修改接收员
     * 
     * @param hySpecimen 接收员
     * @return 结果
     */
    public int updateHySpecimen(HySpecimen hySpecimen);

    /**
     * 删除接收员
     * 
     * @param id 接收员ID
     * @return 结果
     */
    public int deleteHySpecimenById(Long id);

    /**
     * 批量删除接收员
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHySpecimenByIds(String[] ids);
}
