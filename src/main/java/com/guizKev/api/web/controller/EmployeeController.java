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

    //Perfect 
    @GetMapping("/1")
    public List<Employee> getEmployeesByManagerCode(){
        return employeeService.getEmployeesByManagerCode();
    }

    // @GetMapping("/2")
    // public List<Object[]> getCEO() {
    //     return employeeService.getCEO();
    // }

    //
    // @GetMapping("/3")
    // public List<Object[]> getNonSalesRepresentatives(){
    //     return employeeService.getNonSalesRepresentatives();
    // }

    // 
    // @GetMapping("/4")
    // public List<Object[]> getEmployeesWithManagers(){
    //     return employeeService.getEmployeesWithManagers();
    // }

    // @GetMapping("/5")
    // public List<Object[]> getEmployeeManagerAndGrandManagerNames(){
    //     return employeeService.getEmployeeManagerAndGrandManagerNames();
    // }    
    
    //Perfect
    @GetMapping("/6")
    public List<Employee> getEmployeesWithoutOffice(){
        return employeeService.getEmployeesWithoutOffice();
    }

    //It doesn´t work, but it doesn´t return error
    @GetMapping("/7")
    public List<Employee> getEmployeesWithoutClients(){
        return employeeService.getEmployeesWithoutClients();
    }
    
    //It works, but return nuts data
    @GetMapping("/8")
    public List<Object[]> getEmployeesWithoutClientsWithOffice(){
        return employeeService.getEmployeesWithoutClientsWithOffice();
    }

    //It doesn´t work, but it doesn´t return error
    @GetMapping("/9")
    public List<Employee> getEmployeesWithoutOfficeOrClient(){
        return employeeService.getEmployeesWithoutOfficeOrClient();
    }

    //It doesn´t work, but it doesn´t return error
    @GetMapping("/10")
    public List<Object[]> getEmployeesWithoutClientsAndManager(){
        return employeeService.getEmployeesWithoutClientsAndManager();
    }
    
    //Perfect
    @GetMapping("/11")
    public Long countEmployees(){
        return employeeService.countEmployees();
    }
    
    //
    // @GetMapping("/12")
    // public List<Object[]> getSalesRepresentativesAndClientCount(){
    //     return employeeService.getSalesRepresentativesAndClientCount();
    // }
    

}
