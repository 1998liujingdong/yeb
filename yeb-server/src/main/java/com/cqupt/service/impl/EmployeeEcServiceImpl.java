package com.cqupt.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.mapper.EmployeeMapper;
import com.cqupt.pojo.Employee;
import com.cqupt.pojo.EmployeeEc;
import com.cqupt.mapper.EmployeeEcMapper;
import com.cqupt.pojo.RespPageBean;
import com.cqupt.service.IEmployeeEcService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jingdong
 * @since 2021-11-30
 */
@Service
public class EmployeeEcServiceImpl extends ServiceImpl<EmployeeEcMapper, EmployeeEc> implements IEmployeeEcService {


    @Autowired
    private EmployeeMapper employeeMapper;
    /**
     * 获取所有员工（分页）
     * @param currentPage
     * @param pageSize
     * @param employee
     * @param beginDateScope
     * @return
     */
    @Override
    public RespPageBean getEmployee(Integer currentPage, Integer pageSize, Employee employee, LocalDate[] beginDateScope) {
        //开启分页
        Page<Employee> page = new Page<>(currentPage,pageSize);
        employeeMapper.getEmployee(page,employee,beginDateScope);
        return null;
    }
}
