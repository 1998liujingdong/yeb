package com.cqupt.mapper;

import com.cqupt.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqupt.pojo.Role;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jingdong
 * @since 2021-11-30
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 通过用户ID查询菜单列表
     * @param id
     * @return
     */
    List<Menu> getMenusByAdminID(Integer id);

    /**
     * 根据角色获取菜单列表
     * @return
     */
    List<Menu> getMenusWithRole();

    /**
     * 查询所有菜单
     * @return
     */
    List<Menu> getAllMenus();
}
