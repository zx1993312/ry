package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyCommercialSpecificationMapper;
import com.ruoyi.system.domain.HyCommercialSpecification;
import com.ruoyi.system.service.IHyCommercialSpecificationService;
import com.ruoyi.common.core.text.Convert;

/**
 * 商品规格Service业务层处理
 * 
 * @author Administrator
 * @date 2021-07-26
 */
@Service
public class HyCommercialSpecificationServiceImpl implements IHyCommercialSpecificationService 
{
    @Autowired
    private HyCommercialSpecificationMapper hyCommercialSpecificationMapper;

    /**
     * 查询商品规格
     * 
     * @param id 商品规格ID
     * @return 商品规格
     */
    @Override
    public HyCommercialSpecification selectHyCommercialSpecificationById(Long id)
    {
        return hyCommercialSpecificationMapper.selectHyCommercialSpecificationById(id);
    }

    /**
     * 查询商品规格列表
     * 
     * @param hyCommercialSpecification 商品规格
     * @return 商品规格
     */
    @Override
    public List<HyCommercialSpecification> selectHyCommercialSpecificationList(HyCommercialSpecification hyCommercialSpecification)
    {
        return hyCommercialSpecificationMapper.selectHyCommercialSpecificationList(hyCommercialSpecification);
    }

    /**
     * 新增商品规格
     * 
     * @param hyCommercialSpecification 商品规格
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyCommercialSpecification(HyCommercialSpecification hyCommercialSpecification)
    {
        return hyCommercialSpecificationMapper.insertHyCommercialSpecification(hyCommercialSpecification);
    }

    /**
     * 修改商品规格
     * 
     * @param hyCommercialSpecification 商品规格
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyCommercialSpecification(HyCommercialSpecification hyCommercialSpecification)
    {
        return hyCommercialSpecificationMapper.updateHyCommercialSpecification(hyCommercialSpecification);
    }

    /**
     * 删除商品规格对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCommercialSpecificationByIds(String ids)
    {
        return hyCommercialSpecificationMapper.deleteHyCommercialSpecificationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品规格信息
     * 
     * @param id 商品规格ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCommercialSpecificationById(Long id)
    {
        return hyCommercialSpecificationMapper.deleteHyCommercialSpecificationById(id);
    }
}
