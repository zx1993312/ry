package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyIntroductionpictures;

/**
 * 物业简介图片Mapper接口
 * 
 * @author Administrator
 * @date 2021-07-26
 */
public interface HyIntroductionpicturesMapper 
{
    /**
     * 查询物业简介图片
     * 
     * @param id 物业简介图片ID
     * @return 物业简介图片
     */
    public HyIntroductionpictures selectHyIntroductionpicturesById(Long id);

    /**
     * 查询物业简介图片列表
     * 
     * @param hyIntroductionpictures 物业简介图片
     * @return 物业简介图片集合
     */
    public List<HyIntroductionpictures> selectHyIntroductionpicturesList(HyIntroductionpictures hyIntroductionpictures);

    /**
     * 新增物业简介图片
     * 
     * @param hyIntroductionpictures 物业简介图片
     * @return 结果
     */
    public int insertHyIntroductionpictures(HyIntroductionpictures hyIntroductionpictures);

    /**
     * 修改物业简介图片
     * 
     * @param hyIntroductionpictures 物业简介图片
     * @return 结果
     */
    public int updateHyIntroductionpictures(HyIntroductionpictures hyIntroductionpictures);

    /**
     * 删除物业简介图片
     * 
     * @param id 物业简介图片ID
     * @return 结果
     */
    public int deleteHyIntroductionpicturesById(Long id);

    /**
     * 批量删除物业简介图片
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyIntroductionpicturesByIds(String[] ids);
}
