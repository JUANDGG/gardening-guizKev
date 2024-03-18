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
    // ERROR 
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

    @GetMapping("/without-office/{officeCode}")
    public List<Employee> findEmployeesWithoutOffice(@PathVariable Long officeCode) {
        return employeeService.findEmployeesWithoutOffice(officeCode);
    }

    @GetMapping("/without-client/{clientCode}")
    public List<Object[]> findEmployeesWithoutClient(@PathVariable Long clientCode) {
        return employeeService.findEmployeesWithoutClient(clientCode);
    }

    @GetMapping("/without-client-and-office/{clientCode}")
    public List<Object[]> findEmployeesWithoutClientAndTheirOffice(@PathVariable Long clientCode) {
        return employeeService.findEmployeesWithoutClientAndTheirOffice(clientCode);
    }

    //error
    @GetMapping("/without-office-and-client/{officeCode}/{clientCode}")
    public List<Employee> findEmployeesWithoutOfficeAndClient(@PathVariable Long officeCode, @PathVariable Long clientCode) {
        return employeeService.findEmployeesWithoutOfficeAndClient(officeCode, clientCode);
    }

    @GetMapping("/without-client-and-manager/{clientCode}")
    public List<Object[]> findEmployeesWithoutClientAndTheirManager(@PathVariable Long clientCode) {
        return employeeService.findEmployeesWithoutClientAndTheirManager(clientCode);
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