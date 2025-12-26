package com.pagination.first.service.impl;

import java.util.List;

import com.pagination.first.pagination.GetEmployeePageRequest;
import com.pagination.first.pagination.PageableUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.pagination.first.entity.Employee;
import com.pagination.first.repos.EmployeeRepo;
import com.pagination.first.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepo employeeRepo;

    EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Page<Employee> getEmployeesWithPagination(GetEmployeePageRequest getEmployeePageRequest) {
        Pageable pageable= PageableUtil.getPageableObject(getEmployeePageRequest,Employee.NAME);
       // Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return employeeRepo.findAll(pageable);
    }

    @Override
    public Employee getEmployeeById(String id) {
       return employeeRepo.findById(id).get();
    }

    @Override
    public Employee getEmployeeByName(String name) {
       return employeeRepo.findByName(name);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee updateEmployee(String id, Employee employee) {
        Employee emp=getEmployeeById(id);
        if(employee.getName()!=null)
        {
            emp.setName(employee.getName());
        }
        if(employee.getEmail()!=null)
        {
            emp.setEmail(employee.getEmail());
        }
        if(employee.getDepartment()!=null)
        {
            emp.setDepartment(employee.getDepartment());
        }
        if(employee.getSalary()!=null)
        {
            emp.setSalary(employee.getSalary());
        }
       return employeeRepo.save(emp);
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public List<Employee> createGroupEmployee(List<Employee> employeeList) {
        return employeeRepo.saveAll(employeeList);
    }

}
