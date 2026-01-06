package com.example.second.conrtoller;

import com.example.second.model.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Arrays;

@RestController
public class FetchDataController {

    private final RestTemplate restTemplate;

    public FetchDataController() {
        this.restTemplate = new RestTemplate();
    }

    @GetMapping("/fetch-employees")
    public List<Object> fetchEmployees() {
        String url = "http://localhost:8080/api/employee/getAllEmployees";
        ResponseEntity<Object[]> response = restTemplate.exchange(url, HttpMethod.GET,null,Object[].class);
        return Arrays.asList(response.getBody());
    }

    @GetMapping("/fetch/employeeById/{id}")
    public Object fetchEmployeeById(@PathVariable String id) {
        String url = "http://localhost:8080/api/employee/getEmployeeById/"+id;
        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, null, Object.class);
        return response.getBody();

    }

    @PostMapping("/create/employee")
    public Object createEmployee(@RequestBody Employee employee) {
        String url = "http://localhost:8080/api/employee/createEmployee";
        //Employee employee=new Employee("888","Ram","Ram@mail.com","GOD","Infinity");
        HttpEntity<Employee> requestEntity=new HttpEntity<>(employee);
        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Object.class);
        return response.getBody();

    }
}
