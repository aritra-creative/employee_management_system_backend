package com.project.com.employee_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
}
