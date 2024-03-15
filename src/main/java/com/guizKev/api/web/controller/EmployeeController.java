package com.guizKev.api.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guizKev.api.domain.service.employee.EmployeeService;
import com.guizKev.api.persistence.entity.Employee;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    
    @Autowired
    private  EmployeeService employeeService ;


    @GetMapping("/all")
    public List<Employee> getAllEmployee (){
        return employeeService.getAllEmployee();
    }


}
