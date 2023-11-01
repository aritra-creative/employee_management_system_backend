package com.project.com.employee_backend.services;

import java.util.List;

import com.project.com.employee_backend.entity.Employee;
import com.project.com.employee_backend.model.EmployeeModel;

public interface EmployeeService {

    EmployeeModel createEmployee(EmployeeModel employee);

    List<EmployeeModel> getAllEmployees();

    boolean deleteEmployee(int id);

}
