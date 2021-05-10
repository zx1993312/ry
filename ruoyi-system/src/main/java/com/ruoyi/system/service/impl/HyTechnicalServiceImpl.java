package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyTechnicalMapper;
import com.ruoyi.system.domain.HyTechnical;
import com.ruoyi.system.service.IHyTechnicalService;
import com.ruoyi.common.core.text.Convert;

/**
 * 技术参数Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-10
 */
@Service
public class HyTechnicalServiceImpl implements IHyTechnicalService 
{
    @Autowired
    private HyTechnicalMapper hyTechnicalMapper;

    /**
     * 查询技术参数
     * 
     * @param id 技术参数ID
     * @return 技术参数
     */
    @Override
    public HyTechnical selectHyTechnicalById(Long id)
    {
        return hyTechnicalMapper.selectHyTechnicalById(id);
    }

    /**
     * 查询技术参数列表
     * 
     * @param hyTechnical 技术参数
     * @return 技术参数
     */
    @Override
    public List<HyTechnical> selectHyTechnicalList(HyTechnical hyTechnical)
    {
        return hyTechnicalMapper.selectHyTechnicalList(hyTechnical);
    }

    /**
     * 新增技术参数
     * 
     * @param hyTechnical 技术参数
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyTechnical(HyTechnical hyTechnical)
    {
        return hyTechnicalMapper.insertHyTechnical(hyTechnical);
    }

    /**
     * 修改技术参数
     * 
     * @param hyTechnical 技术参数
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyTechnical(HyTechnical hyTechnical)
    {
        return hyTechnicalMapper.updateHyTechnical(hyTechnical);
    }

    /**
     * 删除技术参数对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyTechnicalByIds(String ids)
    {
        return hyTechnicalMapper.deleteHyTechnicalByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除技术参数信息
     * 
     * @param id 技术参数ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyTechnicalById(Long id)
    {
        return hyTechnicalMapper.deleteHyTechnicalById(id);
    }
}
