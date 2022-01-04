package com.cqupt.utils;

import com.cqupt.pojo.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author jingdong
 * @description:
 * @menu
 * @date 2021/12/30 20:26
 */
public class AdminUtils {

    public static Admin getCurrentAdmin(){
        return (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
