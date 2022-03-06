package com.mohibur.OneToMany.Service;

import com.mohibur.OneToMany.Entity.Department;
import com.mohibur.OneToMany.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> createDepartments(List<Department> departmentList) {
        return (List<Department>) departmentRepository.saveAll(departmentList);
    }

    @Override
    public List<Department> getAllDepartment() {
        return (List<Department>) departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(long id) {
        Optional <Department> departmentOptional = departmentRepository.findById(id);
        Department department;
        if(departmentOptional.isPresent()) {
            department = departmentOptional.get();
        } else {
            throw new RuntimeException("No department found for id = " + id);
        }
        return department;
    }

    @Override
    public void deleteDepartment(long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public void deleteAllDepartments() {
        departmentRepository.deleteAll();
    }
}
