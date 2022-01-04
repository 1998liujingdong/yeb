package com.cqupt.service;

import com.cqupt.pojo.Employee;
import com.cqupt.pojo.EmployeeEc;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.pojo.RespPageBean;

import java.time.LocalDate;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jingdong
 * @since 2021-11-30
 */
public interface IEmployeeEcService extends IService<EmployeeEc> {

    /**
     * 获取所有员工（分页）
     * @param currentPage
     * @param pageSize
     * @param employee
     * @param beginDateScope
     * @return
     */
    RespPageBean getEmployee(Integer currentPage, Integer pageSize, Employee employee, LocalDate[] beginDateScope);

}
