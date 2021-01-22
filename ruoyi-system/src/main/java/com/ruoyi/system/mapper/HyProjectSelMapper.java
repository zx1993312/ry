package com.ruoyi.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import com.ruoyi.system.domain.HyProjectSel;

/**
 * 项目收费比例Mapper
 * 
 * @author Administrator
 *
 */
@Mapper
public interface HyProjectSelMapper {

	/**
	 * 查询项目收费比例
	 * 
	 * @param hyProjectSel
	 * @return
	 */
	@Select("<script>" + 
				"select dict_label,remark from sys_dict_data where 1=1 and dict_type='hy_delivery_status'" + 
				" <if test=\"dictLabel != null and dictLabel != ''\"> and dict_label = #{dictLabel}</if>" + 
				" <if test=\"remark != null and remark != '' \"> and remark = #{remark}</if>" + 
			"</script>")
	@Result(column = "dict_label", property = "dictLabel") // sql映射关系
	public List<HyProjectSel> selectProjectSelList(HyProjectSel hyProjectSel);

}
