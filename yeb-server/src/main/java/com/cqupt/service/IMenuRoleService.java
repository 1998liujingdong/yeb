package com.cqupt.service;

import com.cqupt.pojo.MenuRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jingdong
 * @since 2021-11-30
 */
public interface IMenuRoleService extends IService<MenuRole> {

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
