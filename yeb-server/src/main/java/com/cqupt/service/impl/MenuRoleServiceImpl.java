package com.cqupt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqupt.pojo.MenuRole;
import com.cqupt.mapper.MenuRoleMapper;
import com.cqupt.pojo.RespBean;
import com.cqupt.service.IMenuRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jingdong
 * @since 2021-11-30
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements IMenuRoleService {

    @Autowired
    private MenuRoleMapper menuRoleMapper;

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    @Override
    @Transactional
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        //先清空当前角色菜单
        menuRoleMapper.delete(new QueryWrapper<MenuRole>().eq("rid",rid));

        //判断要修改的菜单数据是否为空
        if (null == mids || 0 == mids.length){
            return RespBean.success("更新成功");
        }

        Integer result = menuRoleMapper.insertRecord(rid, mids);

        if (result == mids.length){
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }
}
