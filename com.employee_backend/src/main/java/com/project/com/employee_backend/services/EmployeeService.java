package com.project.com.employee_backend.services;

import java.util.List;

import com.project.com.employee_backend.entity.Employee;
import com.project.com.employee_backend.model.EmployeeModel;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<EmployeeModel> getAllEmployees();

    boolean deleteEmployee(int id);

}
