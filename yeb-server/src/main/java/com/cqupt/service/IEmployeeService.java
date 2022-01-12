package com.cqupt.service;

import com.cqupt.pojo.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.pojo.RespBean;
import com.cqupt.pojo.RespPageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jingdong
 * @since 2021-11-30
 */
public interface IEmployeeService extends IService<Employee> {

    /**
     * 获取所有员工（分页）
     * @param currentPage
     * @param pageSize
     * @param employee
     * @param beginDateScope
     * @return
     */
    RespPageBean getEmployees(Integer currentPage, Integer pageSize, Employee employee, LocalDate[] beginDateScope);

    /**
     * 获取最大工号
     * @return
     */
    RespBean maxWorkID();

    /**
     * 添加员工
     * @param employee
     * @return
     */
    RespBean addEmployee(Employee employee);

    /**
     * 查询员工数据
     */
    List<Employee> getEmployee(Integer id);
}
