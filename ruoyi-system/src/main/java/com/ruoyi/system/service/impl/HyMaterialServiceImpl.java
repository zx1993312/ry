package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyMaterialMapper;
import com.ruoyi.system.domain.HyMaterial;
import com.ruoyi.system.service.IHyMaterialService;
import com.ruoyi.common.core.text.Convert;

/**
 * 物料Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-20
 */
@Service
public class HyMaterialServiceImpl implements IHyMaterialService 
{
    @Autowired
    private HyMaterialMapper hyMaterialMapper;

    /**
     * 查询物料
     * 
     * @param id 物料ID
     * @return 物料
     */
    @Override
    public HyMaterial selectHyMaterialById(Long id)
    {
        return hyMaterialMapper.selectHyMaterialById(id);
    }

    /**
     * 查询物料列表
     * 
     * @param hyMaterial 物料
     * @return 物料
     */
    @Override
    public List<HyMaterial> selectHyMaterialList(HyMaterial hyMaterial)
    {
        return hyMaterialMapper.selectHyMaterialList(hyMaterial);
    }

    /**
     * 新增物料
     * 
     * @param hyMaterial 物料
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyMaterial(HyMaterial hyMaterial)
    {
        hyMaterial.setCreateTime(DateUtils.getNowDate());
        return hyMaterialMapper.insertHyMaterial(hyMaterial);
    }

    /**
     * 修改物料
     * 
     * @param hyMaterial 物料
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyMaterial(HyMaterial hyMaterial)
    {
        return hyMaterialMapper.updateHyMaterial(hyMaterial);
    }

    /**
     * 删除物料对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyMaterialByIds(String ids)
    {
        return hyMaterialMapper.deleteHyMaterialByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物料信息
     * 
     * @param id 物料ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyMaterialById(Long id)
    {
        return hyMaterialMapper.deleteHyMaterialById(id);
    }
}
