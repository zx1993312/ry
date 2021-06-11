package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HySupplier;

/**
 * 供应商Mapper接口
 * 
 * @author Administrator
 * @date 2021-06-11
 */
public interface HySupplierMapper 
{
    /**
     * 查询供应商
     * 
     * @param id 供应商ID
     * @return 供应商
     */
    public HySupplier selectHySupplierById(Long id);

    /**
     * 查询供应商列表
     * 
     * @param hySupplier 供应商
     * @return 供应商集合
     */
    public List<HySupplier> selectHySupplierList(HySupplier hySupplier);

    /**
     * 新增供应商
     * 
     * @param hySupplier 供应商
     * @return 结果
     */
    public int insertHySupplier(HySupplier hySupplier);

    /**
     * 修改供应商
     * 
     * @param hySupplier 供应商
     * @return 结果
     */
    public int updateHySupplier(HySupplier hySupplier);

    /**
     * 删除供应商
     * 
     * @param id 供应商ID
     * @return 结果
     */
    public int deleteHySupplierById(Long id);

    /**
     * 批量删除供应商
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHySupplierByIds(String[] ids);
}
