package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HyParkingInfMapper;
import com.ruoyi.system.domain.HyParkingInf;
import com.ruoyi.system.service.IHyParkingInfService;
import com.ruoyi.common.core.text.Convert;

/**
 * 车位资料
Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Service
public class HyParkingInfServiceImpl implements IHyParkingInfService 
{
    @Autowired
    private HyParkingInfMapper hyParkingInfMapper;

    /**
     * 查询车位资料

     * 
     * @param id 车位资料
ID
     * @return 车位资料

     */
    @Override
    public HyParkingInf selectHyParkingInfById(Long id)
    {
        return hyParkingInfMapper.selectHyParkingInfById(id);
    }

    /**
     * 查询车位资料
列表
     * 
     * @param hyParkingInf 车位资料

     * @return 车位资料

     */
    @Override
    public List<HyParkingInf> selectHyParkingInfList(HyParkingInf hyParkingInf)
    {
        return hyParkingInfMapper.selectHyParkingInfList(hyParkingInf);
    }

    /**
     * 新增车位资料

     * 
     * @param hyParkingInf 车位资料

     * @return 结果
     */
    @Override
    public int insertHyParkingInf(HyParkingInf hyParkingInf)
    {
        return hyParkingInfMapper.insertHyParkingInf(hyParkingInf);
    }

    /**
     * 修改车位资料

     * 
     * @param hyParkingInf 车位资料

     * @return 结果
     */
    @Override
    public int updateHyParkingInf(HyParkingInf hyParkingInf)
    {
        return hyParkingInfMapper.updateHyParkingInf(hyParkingInf);
    }

    /**
     * 删除车位资料
对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHyParkingInfByIds(String ids)
    {
        return hyParkingInfMapper.deleteHyParkingInfByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除车位资料
信息
     * 
     * @param id 车位资料
ID
     * @return 结果
     */
    @Override
    public int deleteHyParkingInfById(Long id)
    {
        return hyParkingInfMapper.deleteHyParkingInfById(id);
    }
}
