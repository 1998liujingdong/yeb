package com.cqupt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.pojo.Employee;
import com.cqupt.mapper.EmployeeMapper;
import com.cqupt.pojo.RespBean;
import com.cqupt.pojo.RespPageBean;
import com.cqupt.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jingdong
 * @since 2021-11-30
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {


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
    public RespPageBean getEmployees(Integer currentPage, Integer pageSize, Employee employee, LocalDate[] beginDateScope) {
        //开启分页
        Page<Employee> page = new Page<>(currentPage,pageSize);
        IPage<Employee> employeeByPage = employeeMapper.getEmployees(page, employee, beginDateScope);
        return new RespPageBean(employeeByPage.getTotal(),employeeByPage.getRecords());
    }

    /**
     * 获取最大工号
     * @return
     */
    @Override
    public RespBean maxWorkID() {
        List<Map<String, Object>> maps = employeeMapper.selectMaps(new QueryWrapper<Employee>().select("max(workID)"));
        String result = String.format("%08d", Integer.parseInt(maps.get(0).get("max(workID)").toString()) + 1);
        return RespBean.success(null,result);
    }

    /**
     * 增加员工
     * @param employee
     * @return
     */
    @Override
    public RespBean addEmployee(Employee employee) {
        LocalDate beginContract = employee.getBeginContract();
        LocalDate endContract = employee.getEndContract();
        long days = beginContract.until(endContract, ChronoUnit.DAYS);
        DecimalFormat decimalFormat = new DecimalFormat("##.00");
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(days/365.00)));
        if (1 == employeeMapper.insert(employee)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    /**
     * 查询员工数据
     */
    @Override
    public List<Employee> getEmployee(Integer id) {
        return employeeMapper.getEmployee(id);
    }
}
