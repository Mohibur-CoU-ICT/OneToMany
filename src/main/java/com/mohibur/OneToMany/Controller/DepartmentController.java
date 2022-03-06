package com.mohibur.OneToMany.Controller;

import com.mohibur.OneToMany.Entity.Department;
import com.mohibur.OneToMany.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping(value = "/create")
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @PostMapping(value = "/create/many")
    public List<Department> createDepartments(@RequestBody List<Department> departmentList) {
        return departmentService.createDepartments(departmentList);
    }

    @GetMapping(value = "/{id}")
    public Department getDepartmentById(@PathVariable("id") long id) {
        return departmentService.getDepartmentById(id);
    }

    @GetMapping(value = "")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartment();
    }

    @PutMapping(value = "/update/{id}")
    public Department updateDepartment(@PathVariable("id") long id, @RequestBody Department department) {
        Department department1 = departmentService.getDepartmentById(id);

        if(department.getDepartmentName() != null) department1.setDepartmentName(department.getDepartmentName());
        if(department.getChairmanName() != null) department1.setChairmanName(department.getChairmanName());

        return departmentService.createDepartment(department1);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteDepartment(@PathVariable("id") long id) {
        departmentService.deleteDepartment(id);
    }

    @DeleteMapping(value = "/delete/all")
    public void deleteAllDepartments() {
        departmentService.deleteAllDepartments();
    }
}
