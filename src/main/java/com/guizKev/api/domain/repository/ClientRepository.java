package com.guizKev.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.guizKev.api.persistence.entity.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client , Integer>{

    //1 -Devuelve un listado con el nombre de los todos los clientes españoles.
    @Query("SELECT c.clientName FROM Client c WHERE c.country = 'Spain'")
    List<String> clientFromSpain();

    //2  Devuelve un listado con el código de cliente de aquellos clientes que realizaron algún pago en 2008. Tenga en cuenta que deberá eliminar aquellos códigos de cliente que aparezcan repetidos. Resuelva la consulta:
    @Query("SELECT DISTINCT c.clientCode FROM Client c JOIN c.payment p WHERE FUNCTION('YEAR', p.paymentDate) = 2008")
    List<Integer> clientCodesWithPaymentsIn2008();

    //3 Devuelve un listado con todos los clientes que sean de la ciudad de Madrid y cuyo representante de ventas tenga el código de empleado 11 o 30.
    @Query("SELECT c.clientCode, c.clientName, c.city, c.employee.employeeCode FROM Client c WHERE c.city = 'Madrid' AND c.employee.employeeCode IN (11, 30)")
    List<Object[]> clientsFromMadridWithSalesRepresentatives11Or30();


    ////// FALTA IMPLEMENTACION  :

    //4 Obtén un listado con el nombre de cada cliente y el nombre y apellido de su representante de ventas.
    @Query("SELECT c.clientName AS Nombre_Cliente, CONCAT(e.firstName, ' ', e.lastName1, ' ', e.lastName2) AS Nombre_Representante_Ventas FROM Client c JOIN c.employee e WHERE c.employee.employeeCode = e.employeeCode")
    List<Object[]> clientAndSalesRepresentativeNames();

    //5 Muestra el nombre de los clientes que no hayan realizado pagos junto con el nombre de sus representantes de ventas.
    @Query("SELECT c.clientCode AS codigoCliente, c.clientName AS nombreCliente, e.firstName AS nombreRepresentanteVentas FROM Client c LEFT JOIN c.payment p JOIN c.employee e WHERE c.clientCode = p.client.clientCode")
    List<Object[]> clientsWithPaymentsAndSalesRepresentatives();

    //6 
} 
