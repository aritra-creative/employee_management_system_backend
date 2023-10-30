package com.project.com.employee_backend.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.com.employee_backend.entity.Employee;

@Repository
public interface EmployeeRepositary extends JpaRepository<Employee, Integer> {

}
