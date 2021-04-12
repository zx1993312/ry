package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyCommunityCultureMapper;
import com.ruoyi.system.domain.HyCommunityCulture;
import com.ruoyi.system.service.IHyCommunityCultureService;
import com.ruoyi.common.core.text.Convert;

/**
 * 社区文化Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-12
 */
@Service
public class HyCommunityCultureServiceImpl implements IHyCommunityCultureService 
{
    @Autowired
    private HyCommunityCultureMapper hyCommunityCultureMapper;

    /**
     * 查询社区文化
     * 
     * @param id 社区文化ID
     * @return 社区文化
     */
    @Override
    public HyCommunityCulture selectHyCommunityCultureById(Long id)
    {
        return hyCommunityCultureMapper.selectHyCommunityCultureById(id);
    }

    /**
     * 查询社区文化列表
     * 
     * @param hyCommunityCulture 社区文化
     * @return 社区文化
     */
    @Override
    public List<HyCommunityCulture> selectHyCommunityCultureList(HyCommunityCulture hyCommunityCulture)
    {
        return hyCommunityCultureMapper.selectHyCommunityCultureList(hyCommunityCulture);
    }

    /**
     * 新增社区文化
     * 
     * @param hyCommunityCulture 社区文化
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyCommunityCulture(HyCommunityCulture hyCommunityCulture)
    {
        return hyCommunityCultureMapper.insertHyCommunityCulture(hyCommunityCulture);
    }

    /**
     * 修改社区文化
     * 
     * @param hyCommunityCulture 社区文化
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyCommunityCulture(HyCommunityCulture hyCommunityCulture)
    {
        return hyCommunityCultureMapper.updateHyCommunityCulture(hyCommunityCulture);
    }

    /**
     * 删除社区文化对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCommunityCultureByIds(String ids)
    {
        return hyCommunityCultureMapper.deleteHyCommunityCultureByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除社区文化信息
     * 
     * @param id 社区文化ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCommunityCultureById(Long id)
    {
        return hyCommunityCultureMapper.deleteHyCommunityCultureById(id);
    }
}
