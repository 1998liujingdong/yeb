package com.cqupt.service.impl;

import com.cqupt.pojo.Admin;
import com.cqupt.pojo.Menu;
import com.cqupt.mapper.MenuMapper;
import com.cqupt.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.utils.AdminUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jingdong
 * @since 2021-11-30
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 通过用户ID查询菜单列表
     * @return
     */
    @Override
    public List<Menu> getMenusByAdminID() {

        Integer adminId = AdminUtils.getCurrentAdmin().getId();

        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        //查询缓存中是否存在数据
        List<Menu> menus = (List<Menu>) valueOperations.get("menu_" + adminId);

        if (CollectionUtils.isEmpty(menus)){
            menus = menuMapper.getMenusByAdminID(adminId);
            valueOperations.set("menu_"+adminId,menus);
        }
        return menus;


    }

    /**
     * 根据角色获取菜单列表
     * @return
     */
    @Override
    public List<Menu> getMenusWithRole() {
        return menuMapper.getMenusWithRole();
    }

    /**
     * 查询所有菜单
     * @return
     */
    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

}
