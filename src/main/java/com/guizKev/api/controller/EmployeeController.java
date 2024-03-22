package com.guizKev.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.guizKev.api.domain.service.employee.EmployeeService;
import com.guizKev.api.exeptions.ErrorResponses;
import com.guizKev.api.exeptions.NotFoundEndPoint;
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

    //PERFECT
    @GetMapping("/managers/{managerCode}")
    public List<Object[]> findEmployeesByManagerCode(@PathVariable Long managerCode) {
        return employeeService.findEmployeesByManagerCode(managerCode);
    }
    
    //ERROR
    @GetMapping("/company/manager")
    public List<Object[]> findEmployeesWithoutManager() {
        throw new NotFoundEndPoint("No se encontró el recurso solicitado");
    } 

    //PERFECT
    //EXAMPLE :http://localhost:8080/api/employee/non-sales-representatives?position=Representante Ventas
    @GetMapping("/non-sales-representatives")
    public List<Object[]> findNonSalesRepresentatives(@RequestParam String position) {
        return employeeService.findNonSalesRepresentatives(position);
    }

    //PERFECT
    @GetMapping("/with-managers")
    public List<Object[]> findEmployeesWithManagers() {
        return employeeService.findEmployeesWithManagers();
    }

    //PERFECT
    @GetMapping("/with-managers-and-manager-of-managers")
    public List<Object[]> findEmployeesWithManagersAndManagerOfManagers() {
        return employeeService.findEmployeesWithManagersAndManagerOfManagers();
    }

    //ERROR
    @GetMapping("/without-office")
    public List<Employee> findEmployeesWithoutOffice() {
        throw new NotFoundEndPoint("No se encontró el recurso solicitado");
    }
    

     //PERFECT
    @GetMapping("/without-client")
    public List<Object[]> findEmployeesWithoutClient() {
        return employeeService.findEmployeesWithoutClient();
    }

    //ERROR
    @GetMapping("/without-client-and-office")
    public List<Object[]> findEmployeesWithoutClientAndTheirOffice() {
        throw new NotFoundEndPoint("No se encontró el recurso solicitado");
    }

    //PERFECT
    @GetMapping("/without-office-and-client")
    public List<Employee> findEmployeesWithoutOfficeAndClient() {
        return employeeService.findEmployeesWithoutOfficeAndClient();
    }

    //PERFECT
    @GetMapping("/without-client-and-manager")
    public List<Object[]> findEmployeesWithoutClientAndTheirManager() {
        return employeeService.findEmployeesWithoutClientAndTheirManager();
    }

    //PERFECT
    @GetMapping("/count")
    public Long countEmployees() {
        return employeeService.countEmployees();
    }


    //PERFECT
    @GetMapping("/sales-representatives")
    public List<Object[]> findSalesRepresentativesAndTheirClients() {
        return employeeService.findSalesRepresentativesAndTheirClients();
    }

    // Exception handling for endpoint not found
    @ExceptionHandler(NotFoundEndPoint.class)
    public ResponseEntity<Object> handleNotFoundEndPoint(NotFoundEndPoint ex) {
        ErrorResponses errorResponse = new ErrorResponses("The requested endpoint is not defined in the API", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    
}