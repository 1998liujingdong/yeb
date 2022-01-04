package com.cqupt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jingdong
 * @description:
 * @menu
 * @date 2021/12/1 15:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespBean {

    private long code ;
    private String message;
    private Object object;

    /**
     * 成功返回没有返回值的情况
     * @param message
     * @return
     */
    public static RespBean success(String message){
        return new RespBean(200,message,null);
    }

    /**
     * 成功返回，具有返回值
     * @param message
     * @param object
     * @return
     */
    public static RespBean success(String message,Object object){
        return new RespBean(200,message,object);
    }

    /**
     * 自定义返回
     * @param code
     * @param message
     * @param object
     * @return
     */
    public static RespBean returnMessage(long code,String message,Object object){
        return new RespBean(code,message,object);
    }

    /**
     *  失败返回500
     * @param message
     * @return
     */
    public static RespBean error(String message){
        return new RespBean(500,message,null);
    }


}
