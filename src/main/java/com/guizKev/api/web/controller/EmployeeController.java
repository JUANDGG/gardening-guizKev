package com.guizKev.api.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/managers/{managerCode}")
    public List<Object[]> findEmployeesByManagerCode(@PathVariable Long managerCode) {
        return employeeService.findEmployeesByManagerCode(managerCode);
    }
    
    @GetMapping("/company/manager")
    public Object findCompanyManager() {
        return employeeService.findCompanyManager();
    }

    @GetMapping("/non-sales-representatives")
    public List<Object[]> findNonSalesRepresentatives(@RequestParam String position) {
        return employeeService.findNonSalesRepresentatives(position);
    }

    @GetMapping("/with-managers")
    public List<Object[]> findEmployeesWithManagers() {
        return employeeService.findEmployeesWithManagers();
    }

    @GetMapping("/with-managers-and-manager-of-managers")
    public List<Object[]> findEmployeesWithManagersAndManagerOfManagers() {
        return employeeService.findEmployeesWithManagersAndManagerOfManagers();
    }

    @GetMapping("/without-office")
    public List<Employee> findEmployeesWithoutOffice() {
        return employeeService.findEmployeesWithoutOffice();
    }

    @GetMapping("/without-client")
    public List<Object[]> findEmployeesWithoutClient() {
        return employeeService.findEmployeesWithoutClient();
    }

    @GetMapping("/without-client-and-office")
    public List<Object[]> findEmployeesWithoutClientAndTheirOffice() {
        return employeeService.findEmployeesWithoutClientAndTheirOffice();
    }


    @GetMapping("/without-office-and-client")
    public List<Employee> findEmployeesWithoutOfficeAndClient() {
        return employeeService.findEmployeesWithoutOfficeAndClient();
    }

    @GetMapping("/without-client-and-manager")
    public List<Object[]> findEmployeesWithoutClientAndTheirManager() {
        return employeeService.findEmployeesWithoutClientAndTheirManager();
    }

    @GetMapping("/count")
    public Long countEmployees() {
        return employeeService.countEmployees();
    }

    /* 

    @GetMapping("/sales-representatives")
    public List<Object[]> findSalesRepresentativesAndTheirClients() {
        return employeeService.findSalesRepresentativesAndTheirClients();
    }

    */
}