package com.project.com.employee_backend.services;

import java.util.List;

import com.project.com.employee_backend.model.EmployeeModel;

public interface EmployeeService {

    EmployeeModel createEmployee(EmployeeModel employee);

    List<EmployeeModel> getAllEmployees();

    boolean deleteEmployee(int id);

    EmployeeModel updateEmployee(int id, EmployeeModel employee);

}
