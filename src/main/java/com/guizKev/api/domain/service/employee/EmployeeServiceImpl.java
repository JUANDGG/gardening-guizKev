package com.guizKev.api.domain.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guizKev.api.domain.repository.EmployeeRepository;
import com.guizKev.api.persistence.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Object[]> findEmployeesByManagerCode(Long managerCode) {
        return employeeRepository.findEmployeesByManagerCode(managerCode);
    }

    @Override
    public Object findCompanyManager() {
        return employeeRepository.findCompanyManager();
    }

    @Override
    public List<Object[]> findNonSalesRepresentatives(String position) {
        return employeeRepository.findNonSalesRepresentatives(position);
    }

    @Override
    public List<Object[]> findEmployeesWithManagers() {
        return employeeRepository.findEmployeesWithManagers();
    }

    @Override
    public List<Object[]> findEmployeesWithManagersAndManagerOfManagers() {
        return employeeRepository.findEmployeesWithManagersAndManagerOfManagers();
    }

    @Override
    public List<Employee> findEmployeesWithoutOffice(Long officeCode) {
        return employeeRepository.findEmployeesWithoutOffice(officeCode);
    }

    @Override
    public List<Object[]> findEmployeesWithoutClient(Long clientCode) {
        return employeeRepository.findEmployeesWithoutClient(clientCode);
    }

    @Override
    public List<Object[]> findEmployeesWithoutClientAndTheirOffice(Long clientCode) {
        return employeeRepository.findEmployeesWithoutClientAndTheirOffice(clientCode);
    }

    @Override
    public List<Employee> findEmployeesWithoutOfficeAndClient(Long officeCode, Long clientCode) {
        return employeeRepository.findEmployeesWithoutOfficeAndClient(officeCode, clientCode);
    }

    @Override
    public List<Object[]> findEmployeesWithoutClientAndTheirManager(Long clientCode) {
        return employeeRepository.findEmployeesWithoutClientAndTheirManager(clientCode);
    }

    @Override
    public Long countEmployees() {
        return employeeRepository.countEmployees();
    }

    /* 

    @Override
    public List<Object[]> findSalesRepresentativesAndTheirClients() {
        return employeeRepository.findSalesRepresentativesAndTheirClients();
    }

    */
}