package com.cqupt.config.security;

import com.cqupt.pojo.Menu;
import com.cqupt.pojo.Role;
import com.cqupt.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @author jingdong
 * @description:
 * @menu
 * @date 2021/12/14 19:27
 */
@Component
public class CustomFilter implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private IMenuService iMenuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //获取请求的url
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        //从数据库种查询角色对应的菜单
        List<Menu> menus = iMenuService.getMenusWithRole();
        for (Menu menu : menus) {
            //判断url与菜单角色是否匹配
           if ( antPathMatcher.match(menu.getUrl(),requestUrl)){
               String[] strings = menu.getRoles().stream().map(Role::getName).toArray(String[]::new);
               return SecurityConfig.createList(strings);
           }
        }

        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
