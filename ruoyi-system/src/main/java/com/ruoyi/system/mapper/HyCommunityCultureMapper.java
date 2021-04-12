package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyCommunityCulture;

/**
 * 社区文化Mapper接口
 * 
 * @author Administrator
 * @date 2021-04-12
 */
public interface HyCommunityCultureMapper 
{
    /**
     * 查询社区文化
     * 
     * @param id 社区文化ID
     * @return 社区文化
     */
    public HyCommunityCulture selectHyCommunityCultureById(Long id);

    /**
     * 查询社区文化列表
     * 
     * @param hyCommunityCulture 社区文化
     * @return 社区文化集合
     */
    public List<HyCommunityCulture> selectHyCommunityCultureList(HyCommunityCulture hyCommunityCulture);

    /**
     * 新增社区文化
     * 
     * @param hyCommunityCulture 社区文化
     * @return 结果
     */
    public int insertHyCommunityCulture(HyCommunityCulture hyCommunityCulture);

    /**
     * 修改社区文化
     * 
     * @param hyCommunityCulture 社区文化
     * @return 结果
     */
    public int updateHyCommunityCulture(HyCommunityCulture hyCommunityCulture);

    /**
     * 删除社区文化
     * 
     * @param id 社区文化ID
     * @return 结果
     */
    public int deleteHyCommunityCultureById(Long id);

    /**
     * 批量删除社区文化
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyCommunityCultureByIds(String[] ids);
}
