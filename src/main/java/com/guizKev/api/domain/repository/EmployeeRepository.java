package com.guizKev.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.guizKev.api.persistence.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
     // 1. Returns a list with the first name, last name and email of the employees whose boss has a boss code equal to 7.
     @Query("SELECT e.firstName, e.lastName1, e.lastName2, e.email FROM Employee e WHERE e.manager.employeeCode = :managerCode")
     List<Object[]> findEmployeesByManagerCode(@Param("managerCode") Long managerCode);


     // 2. Returns the name of the position, first name, last name and email of the company manager.
     @Query("SELECT e FROM Employee e WHERE e.manager IS NULL")
     List<Employee> findCompanyManager();

     // 3. Returns a list with the first name, last name and position of those employees who are not sales representatives.
     @Query("SELECT e.firstName, e.lastName1, e.lastName2, e.position FROM Employee e WHERE e.position IS NOT NULL AND e.position <> :position")
     List<Object[]> findNonSalesRepresentatives(@Param("position") String position);


     // 4. Returns a list with the name of the employees along with the name of their managers.
     @Query("SELECT e1.firstName AS employeeName, e2.firstName AS managerName FROM Employee e1 LEFT JOIN e1.manager e2")
     List<Object[]> findEmployeesWithManagers();

     // 5.  Returns a list showing the name of each employee, the name of their manager and the name of their manager's manager.
     @Query("SELECT e1.firstName AS employeeName, e2.firstName AS managerName, e3.firstName AS managerOfManagerName FROM Employee e1 LEFT JOIN e1.manager e2 LEFT JOIN e2.manager e3")
     List<Object[]> findEmployeesWithManagersAndManagerOfManagers();

     
     // 6. Returns a list showing only employees who do not have an associated office.
     @Query("SELECT e FROM Employee e LEFT JOIN e.office o WHERE o.officeCode IS NULL")
     List<Employee> findEmployeesWithoutOffice();

     // 7. Returns a list that shows only employees that do not have an associated customer.
     @Query("SELECT e, m.firstName AS managerName FROM Employee e LEFT JOIN e.client c LEFT JOIN e.manager m WHERE c IS NULL")
     List<Object[]> findEmployeesWithoutClient();

     // 8.  Returns a list showing only those employees who do not have an associated customer along with the office data where they work..
     @Query("SELECT e, o FROM Employee e JOIN e.office o LEFT JOIN e.client c WHERE c IS NULL")
     List<Object[]> findEmployeesWithoutClientAndTheirOffice();

     // 9. Returns a list showing employees who do not have an associated office and those who do not have an associated customer.
     @Query("SELECT e FROM Employee e LEFT JOIN e.office o LEFT JOIN e.client c WHERE o.officeCode IS NULL AND c IS NULL")
     List<Employee> findEmployeesWithoutOfficeAndClient();

     // 10. Returns a list with the data of the employees who have no associated customers and the name of their associated manager.
     @Query("SELECT e, m.firstName AS managerName FROM Employee e LEFT JOIN e.client c LEFT JOIN e.manager m WHERE c IS NULL")
     List<Object[]> findEmployeesWithoutClientAndTheirManager();



     // 11  How many employees are there in the company
     @Query("SELECT COUNT(e) FROM Employee e")
     Long countEmployees();

     //12   Returns the name of the sales representatives and the number of customers served by each one.
     @Query("SELECT e.firstName, e.lastName1, e.lastName2, COUNT(c) AS totalClients " +
            "FROM Employee e " +
            "LEFT JOIN e.client c " +
            "WHERE LOWER(TRIM(e.position)) = 'representante ventas' " +
            "GROUP BY e.firstName, e.lastName1, e.lastName2")
    List<Object[]> findSalesRepresentativesAndTheirClients();

     
}
