package com.cqupt.service.impl;

import com.cqupt.pojo.Employee;
import com.cqupt.mapper.EmployeeMapper;
import com.cqupt.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
