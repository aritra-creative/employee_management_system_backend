package com.project.com.employee_backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.project.com.employee_backend.entity.Employee;
import com.project.com.employee_backend.model.EmployeeModel;
import com.project.com.employee_backend.repositary.EmployeeRepositary;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepositary employeeRepositary;

    public EmployeeServiceImpl(EmployeeRepositary employeeRepositary) {
        this.employeeRepositary = employeeRepositary;
    }

    @Override
    public EmployeeModel createEmployee(EmployeeModel employee) {

        Employee emp = new Employee();
        BeanUtils.copyProperties(employee, emp);
        employeeRepositary.save(emp);
        return employee;
    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
        List<Employee> employees = employeeRepositary.findAll();

        List<EmployeeModel> employeeModels = employees.stream()
                .map(emp -> new EmployeeModel(
                        emp.getId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmail()))
                .collect(Collectors.toList());
        return employeeModels;
    }

    @Override
    public boolean deleteEmployee(int id) {
        Employee employee = employeeRepositary.findById(id).get();
        employeeRepositary.delete(employee);
        return true;

    }

    @Override
    public EmployeeModel updateEmployee(int id, EmployeeModel employee) {
        Employee emp = employeeRepositary.findById(id).get();
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        emp.setEmail(employee.getEmail());
        employeeRepositary.save(emp);
        return employee;
    }

}