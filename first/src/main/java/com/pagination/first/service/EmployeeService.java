package com.pagination.first.service;

import java.util.List;

import com.pagination.first.entity.Employee;
import com.pagination.first.pagination.GetEmployeePageRequest;
import org.springframework.data.domain.Page;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Page<Employee> getEmployeesWithPagination(GetEmployeePageRequest employeePageRequest);

    public Employee getEmployeeById(String id);

    public Employee getEmployeeByName(String name);

    public Employee createEmployee(Employee employee);

    public Employee updateEmployee(String id, Employee employee);

    public void deleteEmployee(String id);

    public List<Employee> createGroupEmployee(List<Employee> employeeList);
}
