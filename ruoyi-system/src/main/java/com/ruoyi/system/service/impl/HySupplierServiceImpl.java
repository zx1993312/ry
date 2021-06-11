package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HySupplierMapper;
import com.ruoyi.system.domain.HySupplier;
import com.ruoyi.system.service.IHySupplierService;
import com.ruoyi.common.core.text.Convert;

/**
 * 供应商Service业务层处理
 * 
 * @author Administrator
 * @date 2021-06-11
 */
@Service
public class HySupplierServiceImpl implements IHySupplierService 
{
    @Autowired
    private HySupplierMapper hySupplierMapper;

    /**
     * 查询供应商
     * 
     * @param id 供应商ID
     * @return 供应商
     */
    @Override
    public HySupplier selectHySupplierById(Long id)
    {
        return hySupplierMapper.selectHySupplierById(id);
    }

    /**
     * 查询供应商列表
     * 
     * @param hySupplier 供应商
     * @return 供应商
     */
    @Override
    public List<HySupplier> selectHySupplierList(HySupplier hySupplier)
    {
        return hySupplierMapper.selectHySupplierList(hySupplier);
    }

    /**
     * 新增供应商
     * 
     * @param hySupplier 供应商
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHySupplier(HySupplier hySupplier)
    {
        return hySupplierMapper.insertHySupplier(hySupplier);
    }

    /**
     * 修改供应商
     * 
     * @param hySupplier 供应商
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHySupplier(HySupplier hySupplier)
    {
        return hySupplierMapper.updateHySupplier(hySupplier);
    }

    /**
     * 删除供应商对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHySupplierByIds(String ids)
    {
        return hySupplierMapper.deleteHySupplierByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除供应商信息
     * 
     * @param id 供应商ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHySupplierById(Long id)
    {
        return hySupplierMapper.deleteHySupplierById(id);
    }
}
