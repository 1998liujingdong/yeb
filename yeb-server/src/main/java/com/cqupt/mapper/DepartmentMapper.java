package com.cqupt.mapper;

import com.cqupt.pojo.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jingdong
 * @since 2021-11-30
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    /**
     * 获取所有部门
     * @return
     */
    List<Department> getAllDepartments(Integer parentId);

    /**
     * 添加部门
     * @param department
     * @return
     */
    void addDepartment(Department department);

    /**
     * 删除部门
     * @param id
     * @return
     */
    void deleteDepartment(Department department);
}
