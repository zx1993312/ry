package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyDetectionregister;

/**
 * 设备检测登记Service接口
 * 
 * @author Administrator
 * @date 2021-05-14
 */
public interface IHyDetectionregisterService 
{
    /**
     * 查询设备检测登记
     * 
     * @param id 设备检测登记ID
     * @return 设备检测登记
     */
    public HyDetectionregister selectHyDetectionregisterById(Long id);

    /**
     * 查询设备检测登记列表
     * 
     * @param hyDetectionregister 设备检测登记
     * @return 设备检测登记集合
     */
    public List<HyDetectionregister> selectHyDetectionregisterList(HyDetectionregister hyDetectionregister);

    /**
     * 新增设备检测登记
     * 
     * @param hyDetectionregister 设备检测登记
     * @return 结果
     */
    public int insertHyDetectionregister(HyDetectionregister hyDetectionregister);

    /**
     * 修改设备检测登记
     * 
     * @param hyDetectionregister 设备检测登记
     * @return 结果
     */
    public int updateHyDetectionregister(HyDetectionregister hyDetectionregister);

    /**
     * 批量删除设备检测登记
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyDetectionregisterByIds(String ids);

    /**
     * 删除设备检测登记信息
     * 
     * @param id 设备检测登记ID
     * @return 结果
     */
    public int deleteHyDetectionregisterById(Long id);
}
