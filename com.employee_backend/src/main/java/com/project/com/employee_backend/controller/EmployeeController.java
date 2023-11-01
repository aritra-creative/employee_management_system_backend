package com.project.com.employee_backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.com.employee_backend.entity.Employee;
import com.project.com.employee_backend.model.EmployeeModel;
import com.project.com.employee_backend.services.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    public EmployeeModel createEmployee(@RequestBody EmployeeModel employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/employees")
    public List<EmployeeModel> getEmployee() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable int id) {
        boolean deleted = false;
        deleted = employeeService.deleteEmployee(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    // @GetMapping("/employee")
    // public String employeeController(EmployeeService employeeService) {
    // return "This is employeee controller";
    // }
}
