package com.cqupt.controller;


import com.cqupt.pojo.Employee;
import com.cqupt.pojo.RespPageBean;
import com.cqupt.service.IEmployeeEcService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jingdong
 * @since 2021-11-30
 */
@RestController
@RequestMapping("/employee/basic")
public class EmployeeController {


    @Autowired
    private IEmployeeEcService employeeEcService;

    @ApiOperation(value = "获取所有员工（分页）")
    @GetMapping("/")
    public RespPageBean getEmployee(@RequestParam(defaultValue = "1") Integer currentPage,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                    Employee employee,
                                    LocalDate[] beginDateScope){
        return employeeEcService.getEmployee(currentPage,pageSize,employee,beginDateScope);

    }

}
