package com.cqupt.mapper;

import com.cqupt.pojo.MenuRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqupt.pojo.RespBean;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jingdong
 * @since 2021-11-30
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    Integer insertRecord(Integer rid, Integer[] mids);


}
