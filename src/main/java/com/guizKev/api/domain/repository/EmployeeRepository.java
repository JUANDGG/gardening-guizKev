package com.guizKev.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.guizKev.api.persistence.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.manager.employeeCode = 7")
    List<Employee> findEmployeesByManagerCode();

    // @Query("SELECT e.position.name, e.firstName, e.lastName, e.email FROM Employee e WHERE e.manager IS NULL")
    // List<Object[]> findCEO();

    // @Query("SELECT e.firstName, e.lastName, e.position.name FROM Employee e WHERE e.position.name <> 'Sales Representative'")
    // List<Object[]> findNonSalesRepresentatives();

    // @Query("SELECT e.firstName, e.lastName, e.manager.firstName, e.manager.lastName FROM Employee e")
    // List<Object[]> findEmployeesWithManagers();

    // @Query("SELECT e.employeeName, e.manager.employeeName, e.manager.manager.employeeName FROM Employee e")
    // List<Object[]> findEmployeeManagerAndGrandManagerNames();

    @Query("SELECT e FROM Employee e WHERE e.office IS NULL")
    List<Employee> findEmployeesWithoutOffice();

    @Query("SELECT e FROM Employee e WHERE e.client IS NULL")
    List<Employee> findEmployeesWithoutClients();

    @Query("SELECT e, o FROM Employee e LEFT JOIN e.client c LEFT JOIN e.office o WHERE c IS NULL")
    List<Object[]> findEmployeesWithoutClientsWithOffice();

    @Query("SELECT e FROM Employee e WHERE e.office IS NULL OR e.client IS NULL")
    List<Employee> findEmployeesWithoutOfficeOrClient();

    @Query("SELECT e, e.manager.firstName, e.manager.lastName1 FROM Employee e WHERE e.client IS NULL")
    List<Object[]> findEmployeesWithoutClientsAndManager();

    @Query("SELECT COUNT(e) FROM Employee e")
    Long countEmployees();

    // @Query("SELECT e.firstName, e.lastName1, COUNT(c) AS numClients FROM Employee e LEFT JOIN e.clients c GROUP BY e.firstName, e.lastName1")
    // List<Object[]> findSalesRepresentativesAndClientCount();

}
