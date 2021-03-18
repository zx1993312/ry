package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyResidentialQuartersPicture;

/**
 * 小区图片Service接口
 * 
 * @author Administrator
 * @date 2021-03-18
 */
public interface IHyResidentialQuartersPictureService 
{
    /**
     * 查询小区图片
     * 
     * @param id 小区图片ID
     * @return 小区图片
     */
    public HyResidentialQuartersPicture selectHyResidentialQuartersPictureById(Long id);

    /**
     * 查询小区图片列表
     * 
     * @param hyResidentialQuartersPicture 小区图片
     * @return 小区图片集合
     */
    public List<HyResidentialQuartersPicture> selectHyResidentialQuartersPictureList(HyResidentialQuartersPicture hyResidentialQuartersPicture);

    /**
     * 新增小区图片
     * 
     * @param hyResidentialQuartersPicture 小区图片
     * @return 结果
     */
    public int insertHyResidentialQuartersPicture(HyResidentialQuartersPicture hyResidentialQuartersPicture);

    /**
     * 修改小区图片
     * 
     * @param hyResidentialQuartersPicture 小区图片
     * @return 结果
     */
    public int updateHyResidentialQuartersPicture(HyResidentialQuartersPicture hyResidentialQuartersPicture);

    /**
     * 批量删除小区图片
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyResidentialQuartersPictureByIds(String ids);

    /**
     * 删除小区图片信息
     * 
     * @param id 小区图片ID
     * @return 结果
     */
    public int deleteHyResidentialQuartersPictureById(Long id);
}
