package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyServiceregistration;

/**
 * 设备维修登记Service接口
 * 
 * @author Administrator
 * @date 2021-05-13
 */
public interface IHyServiceregistrationService 
{
    /**
     * 查询设备维修登记
     * 
     * @param id 设备维修登记ID
     * @return 设备维修登记
     */
    public HyServiceregistration selectHyServiceregistrationById(Long id);

    /**
     * 查询设备维修登记列表
     * 
     * @param hyServiceregistration 设备维修登记
     * @return 设备维修登记集合
     */
    public List<HyServiceregistration> selectHyServiceregistrationList(HyServiceregistration hyServiceregistration);

    /**
     * 新增设备维修登记
     * 
     * @param hyServiceregistration 设备维修登记
     * @return 结果
     */
    public int insertHyServiceregistration(HyServiceregistration hyServiceregistration);

    /**
     * 修改设备维修登记
     * 
     * @param hyServiceregistration 设备维修登记
     * @return 结果
     */
    public int updateHyServiceregistration(HyServiceregistration hyServiceregistration);

    /**
     * 批量删除设备维修登记
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyServiceregistrationByIds(String ids);

    /**
     * 删除设备维修登记信息
     * 
     * @param id 设备维修登记ID
     * @return 结果
     */
    public int deleteHyServiceregistrationById(Long id);
}
