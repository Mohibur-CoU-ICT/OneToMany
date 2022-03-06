package com.mohibur.OneToMany.Service;

import com.mohibur.OneToMany.Entity.Department;

import java.util.List;

public interface DepartmentService {
    Department createDepartment(Department department);
    List<Department> createDepartments(List<Department> departmentList);
    List<Department> getAllDepartment();
    Department getDepartmentById(long id);
    void deleteDepartment(long id);
    void deleteAllDepartments();
}
