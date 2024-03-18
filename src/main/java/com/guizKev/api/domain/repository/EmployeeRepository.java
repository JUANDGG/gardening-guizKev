package com.guizKev.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.guizKev.api.persistence.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
     // 1. Devuelve un listado con el nombre, apellidos y email de los empleados cuyo jefe tiene un código de jefe igual a 7.
     @Query("SELECT e.firstName, e.lastName1, e.lastName2, e.email FROM Employee e WHERE e.manager.employeeCode = :managerCode")
     List<Object[]> findEmployeesByManagerCode(@Param("managerCode") Long managerCode);


     // 2. Devuelve el nombre del puesto, nombre, apellidos y email del jefe de la empresa.
     @Query("SELECT e.position AS jobName, m.firstName, m.lastName1, m.lastName2, m.email FROM Employee e JOIN e.manager m WHERE e.manager IS NULL")
     Object findCompanyManager();

     // 3. Devuelve un listado con el nombre, apellidos y puesto de aquellos empleados que no sean representantes de ventas.
     @Query("SELECT e.firstName, e.lastName1, e.lastName2, e.position FROM Employee e WHERE e.position IS NOT NULL AND e.position <> :position")
     List<Object[]> findNonSalesRepresentatives(@Param("position") String position);


     // 4. Devuelve un listado con el nombre de los empleados junto con el nombre de sus jefes.
     @Query("SELECT e1.firstName AS employeeName, e2.firstName AS managerName FROM Employee e1 LEFT JOIN e1.manager e2")
     List<Object[]> findEmployeesWithManagers();

     // 5. Devuelve un listado que muestre el nombre de cada empleados, el nombre de su jefe y el nombre del jefe de sus jefe.
     @Query("SELECT e1.firstName AS employeeName, e2.firstName AS managerName, e3.firstName AS managerOfManagerName FROM Employee e1 LEFT JOIN e1.manager e2 LEFT JOIN e2.manager e3")
     List<Object[]> findEmployeesWithManagersAndManagerOfManagers();

     
     // 6. Devuelve un listado que muestre solamente los empleados que no tienen una oficina asociada.
     @Query("SELECT e FROM Employee e LEFT JOIN e.office o WHERE o.officeCode = :officeCode")
     List<Employee> findEmployeesWithoutOffice(@Param("officeCode") Long officeCode);

     // 7. Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado.
     @Query("SELECT e, m.firstName AS managerName FROM Employee e LEFT JOIN e.client c LEFT JOIN e.manager m WHERE c.clientCode = :clientCode")
     List<Object[]> findEmployeesWithoutClient(@Param("clientCode") Long clientCode);

     // 8. Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado junto con los datos de la oficina donde trabajan.
     @Query("SELECT e, o FROM Employee e JOIN e.office o LEFT JOIN e.client c WHERE c.clientCode = :clientCode")
     List<Object[]> findEmployeesWithoutClientAndTheirOffice(@Param("clientCode") Long clientCode);

     // 9. Devuelve un listado que muestre los empleados que no tienen una oficina asociada y los que no tienen un cliente asociado.
     @Query("SELECT e FROM Employee e LEFT JOIN e.office o LEFT JOIN e.client c WHERE o.officeCode = :officeCode AND c.clientCode = :clientCode")
     List<Employee> findEmployeesWithoutOfficeAndClient(@Param("officeCode") Long officeCode, @Param("clientCode") Long clientCode);

     // 10. Devuelve un listado con los datos de los empleados que no tienen clientes asociados y el nombre de su jefe asociado.
     @Query("SELECT e, m.firstName AS managerName FROM Employee e LEFT JOIN e.client c LEFT JOIN e.manager m WHERE c.clientCode = :clientCode")
     List<Object[]> findEmployeesWithoutClientAndTheirManager(@Param("clientCode") Long clientCode);

     // 11. ¿Cuántos empleados hay en la compañía?
     @Query("SELECT COUNT(e) FROM Employee e")
     Long countEmployees();

     /* 
     // 12. Devuelve el nombre de los representantes de ventas y el número de clientes al que atiende cada uno.
     @Query("SELECT e.firstName, e.lastName1, e.lastName2, COUNT(c) AS totalClients FROM Employee e LEFT JOIN e.clients c WHERE e.position = 'Sales Representative' GROUP BY e.employeeCode")
     List<Object[]> findSalesRepresentativesAndTheirClients();
     }
     */
}
