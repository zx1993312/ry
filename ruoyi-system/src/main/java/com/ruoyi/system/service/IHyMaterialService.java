package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyMaterial;

/**
 * 物料Service接口
 * 
 * @author Administrator
 * @date 2021-04-20
 */
public interface IHyMaterialService 
{
    /**
     * 查询物料
     * 
     * @param id 物料ID
     * @return 物料
     */
    public HyMaterial selectHyMaterialById(Long id);

    /**
     * 查询物料列表
     * 
     * @param hyMaterial 物料
     * @return 物料集合
     */
    public List<HyMaterial> selectHyMaterialList(HyMaterial hyMaterial);

    /**
     * 新增物料
     * 
     * @param hyMaterial 物料
     * @return 结果
     */
    public int insertHyMaterial(HyMaterial hyMaterial);

    /**
     * 修改物料
     * 
     * @param hyMaterial 物料
     * @return 结果
     */
    public int updateHyMaterial(HyMaterial hyMaterial);
    
    /**
     * 修改物料
     * 
     * @param hyMaterial 物料
     * @return 结果
     */
    public int updateHyMaterials(HyMaterial hyMaterial);

    /**
     * 批量删除物料
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyMaterialByIds(String ids);

    /**
     * 删除物料信息
     * 
     * @param id 物料ID
     * @return 结果
     */
    public int deleteHyMaterialById(Long id);
}
