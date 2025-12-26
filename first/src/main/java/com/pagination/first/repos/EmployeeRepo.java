package com.pagination.first.repos;

import java.util.List;

import com.pagination.first.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends CustomRepo<Employee, String> {

    List<Employee> findAll();

    Employee findByName(String name);


}
