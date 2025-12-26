package com.pagination.first.controller;

import java.util.List;

import com.pagination.first.api.EmployeeApi;
import com.pagination.first.entity.Employee;
import com.pagination.first.model.CreateEmployeeResponse;
import com.pagination.first.pagination.GetEmployeePageRequest;
import com.pagination.first.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController implements EmployeeApi {

    EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/getEmployeesWithPagination")
    public Page<Employee> getEmployeesWithPagination(GetEmployeePageRequest getEmployeePageRequest) {
        return employeeService.getEmployeesWithPagination(getEmployeePageRequest);
    }

    @Override
    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @Override
    @GetMapping("/getEmployeeByName/{name}")
    public ResponseEntity<Employee> getEmployeeByName(@PathVariable String name) {
        return ResponseEntity.ok(employeeService.getEmployeeByName(name));
    }

    @Override
    @PostMapping("/createEmployee")
    public ResponseEntity<CreateEmployeeResponse> createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);

        CreateEmployeeResponse response=CreateEmployeeResponse.builder()
                .message("Employee created successfully")
                .Name(employee.getName())
                .Dept(employee.getDepartment()).build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);


    }

    @Override
    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }

    @Override
    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String id) {
        String name=employeeService.getEmployeeById(id).getName();
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Deleted "+name);
    }

}
