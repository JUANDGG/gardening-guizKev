package com.guizKev.api.domain.service.employee;

import java.util.List;

import com.guizKev.api.persistence.entity.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    //1
    List<Employee> getEmployeesByManagerCode();

    // List<Object[]> getCEO();

    // List<Object[]> getNonSalesRepresentatives();

    // List<Object[]> getEmployeesWithManagers();

    // List<Object[]> getEmployeeManagerAndGrandManagerNames();

    List<Employee> getEmployeesWithoutOffice();

    List<Employee> getEmployeesWithoutClients();

    List<Object[]> getEmployeesWithoutClientsWithOffice();

    List<Employee> getEmployeesWithoutOfficeOrClient();

    List<Object[]> getEmployeesWithoutClientsAndManager();

    Long countEmployees();

    //12
    // List<Object[]> getSalesRepresentativesAndClientCount();

}
