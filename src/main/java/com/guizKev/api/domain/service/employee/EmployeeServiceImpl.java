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
    public List<Employee> getEmployeesByManagerCode() {
        return employeeRepository.findEmployeesByManagerCode();
    }

    // @Override
    // public List<Object[]> getCEO() {
    //     return employeeRepository.findCEO();
    // }

    // @Override
    // public List<Object[]> getNonSalesRepresentatives() {
    //     return employeeRepository.findNonSalesRepresentatives();
    // }

    // @Override
    // public List<Object[]> getEmployeesWithManagers() {
    //     return employeeRepository.findEmployeesWithManagers();
    // }

    // @Override
    // public List<Object[]> getEmployeeManagerAndGrandManagerNames() {
    //     return employeeRepository.findEmployeeManagerAndGrandManagerNames();
    // }

    @Override
    public List<Employee> getEmployeesWithoutOffice() {
        return employeeRepository.findEmployeesWithoutOffice();
    }

    @Override
    public List<Employee> getEmployeesWithoutClients() {
        return employeeRepository.findEmployeesWithoutClients();
    }

    @Override
    public List<Object[]> getEmployeesWithoutClientsWithOffice() {
        return employeeRepository.findEmployeesWithoutClientsWithOffice();
    }

    @Override
    public List<Employee> getEmployeesWithoutOfficeOrClient() {
        return employeeRepository.findEmployeesWithoutOfficeOrClient();
    }

    @Override
    public List<Object[]> getEmployeesWithoutClientsAndManager() {
        return employeeRepository.findEmployeesWithoutClientsAndManager();
    }

    @Override
    public Long countEmployees() {
        return employeeRepository.countEmployees();
    }

    // @Override
    // public List<Object[]> getSalesRepresentativesAndClientCount() {
    //     return employeeRepository.findSalesRepresentativesAndClientCount();
    // }

}
