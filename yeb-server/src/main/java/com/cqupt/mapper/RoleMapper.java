package com.cqupt.mapper;

import com.cqupt.pojo.Admin;
import com.cqupt.pojo.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jingdong
 * @since 2021-11-30
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户id获取角色信息
     * @param adminId
     * @return
     */
    List<Role> getRoles(Integer adminId);

}
