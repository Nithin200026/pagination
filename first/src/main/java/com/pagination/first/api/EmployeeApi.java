package com.pagination.first.api;

import java.util.List;
import com.pagination.first.entity.Employee;
import com.pagination.first.model.CreateEmployeeResponse;
import com.pagination.first.pagination.GetEmployeePageRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface EmployeeApi {

    public ResponseEntity<List<Employee>> getAllEmployees();

    public ResponseEntity<Employee> getEmployeeById(String id);

    public ResponseEntity<Employee> getEmployeeByName(String name);

    public ResponseEntity<CreateEmployeeResponse> createEmployee(Employee employee);

    public ResponseEntity<List<CreateEmployeeResponse>> createGroupEmployee(List<Employee> employeeList);

    public ResponseEntity<Employee> updateEmployee(String id, Employee employee);

    public ResponseEntity<String> deleteEmployee(String id);

    public Page<Employee> getEmployeesWithPagination(GetEmployeePageRequest getEmployeePageRequest);
}
