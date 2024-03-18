package com.guizKev.api.domain.service.employee;

import java.util.List;

import com.guizKev.api.persistence.entity.Employee;

public interface EmployeeService {
    
    List<Employee> getAllEmployee();

    List<Object[]> findEmployeesByManagerCode(Long managerCode);

    Object findCompanyManager();

    List<Object[]> findNonSalesRepresentatives(String position);

    List<Object[]> findEmployeesWithManagers();

    List<Object[]> findEmployeesWithManagersAndManagerOfManagers();

    List<Employee> findEmployeesWithoutOffice(Long officeCode);

    List<Object[]> findEmployeesWithoutClient(Long clientCode);

    List<Object[]> findEmployeesWithoutClientAndTheirOffice(Long clientCode);

    List<Employee> findEmployeesWithoutOfficeAndClient(Long officeCode, Long clientCode);

    List<Object[]> findEmployeesWithoutClientAndTheirManager(Long clientCode);

    Long countEmployees();

    //List<Object[]> findSalesRepresentativesAndTheirClients();
}