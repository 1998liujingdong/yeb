package com.cqupt.exception;

import com.cqupt.pojo.RespBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author jingdong
 * @description:
 * @menu
 * @date 2021/12/20 20:36
 */
@ControllerAdvice
public class GlobalExecption {

    @ExceptionHandler(SQLException.class)
    public RespBean mySqlException(Exception e){
        if (e instanceof SQLIntegrityConstraintViolationException){
            return RespBean.error("该数据有关联数据，操作失败");
        }
        return RespBean.error("数据库异常，操作失败");
    }

}
