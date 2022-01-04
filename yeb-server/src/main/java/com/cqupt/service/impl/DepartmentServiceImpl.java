package com.cqupt.service.impl;

import com.cqupt.pojo.Department;
import com.cqupt.mapper.DepartmentMapper;
import com.cqupt.pojo.RespBean;
import com.cqupt.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jingdong
 * @since 2021-11-30
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 获取所有部门
     * @return
     */
    @Override
    public List<Department> getAllDepartment() {
        return departmentMapper.getAllDepartments(-1);
    }

    /**
     * 添加部门
     * @param department
     * @return
     */
    @Override
    public RespBean addDepartment(Department department) {
        department.setEnabled(true);
        departmentMapper.addDepartment(department);
        if (1 == department.getResult()){
            return RespBean.success("添加成功",department);
        }else{
            return RespBean.error("添加失败");
        }

    }

    /**
     * 删除部门
     * @param id
     * @return
     */
    @Override
    public RespBean deleteDepartment(Integer id) {
        Department department = new Department();
        department.setId(id);
        departmentMapper.deleteDepartment(department);
        if (-2 == department.getResult()){
            return RespBean.error("该部门下还有子部门，不能删除！！");
        }
        if (-1 == department.getResult()){
            return RespBean.error("该部门下还有员工，不能删除!!!");
        }
        if (1 == department.getResult()){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败!!!");
    }
}
