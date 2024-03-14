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

    // 1. Obtén un listado con el nombre de cada cliente y el nombre y apellido de su representante de ventas.
    @Query("SELECT c.nombreCliente, CONCAT(e.nombre, ' ', e.apellido1, ' ', e.apellido2) AS NombreRepresentanteVentas FROM Cliente c JOIN c.empleado e")
    List<Object[]> obtenerClientesConRepresentantes();

    // 2. Muestra el nombre de los clientes que hayan realizado pagos junto con el nombre de sus representantes de ventas.
    @Query("SELECT c.codigoCliente, c.nombreCliente, e.nombre AS nombreRepresentanteVentas FROM Cliente c JOIN c.pagos p JOIN c.empleado e WHERE p.codigoCliente = c.codigoCliente")
    List<Object[]> obtenerClientesConPagosYRepresentantes();

    // 3. Muestra el nombre de los clientes que no hayan realizado pagos junto con el nombre de sus representantes de ventas.
    @Query("SELECT c.codigoCliente, c.nombreCliente, e.nombre AS nombreRepresentanteVentas FROM Cliente c LEFT JOIN c.pagos p JOIN c.empleado e WHERE p.codigoCliente IS NULL")
    List<Object[]> obtenerClientesSinPagosYRepresentantes();

    // 4. Devuelve el nombre de los clientes que han hecho pagos y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante.
    @Query("SELECT c.nombreCliente, e.nombre AS nombreRepresentante, o.ciudad AS ciudadRepresentante FROM Cliente c JOIN c.pagos p JOIN c.empleado e JOIN e.oficina o")
    List<Object[]> obtenerClientesConPagosYCiudadRepresentante();

    // 5. Devuelve el nombre de los clientes que no hayan hecho pagos y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante.
    @Query("SELECT c.nombreCliente, e.nombre AS nombreRepresentante, o.ciudad AS ciudadRepresentante FROM Cliente c LEFT JOIN c.pagos p JOIN c.empleado e JOIN e.oficina o WHERE p.codigoCliente IS NULL")
    List<Object[]> obtenerClientesSinPagosYCiudadRepresentante();

    // 6. Devuelve el nombre de los clientes y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante.
    @Query("SELECT c.nombreCliente, e.nombre AS nombreRepresentante, o.ciudad AS ciudadRepresentante FROM Cliente c JOIN c.empleado e JOIN e.oficina o")
    List<Object[]> obtenerClientesConCiudadRepresentante();

    // 7. Devuelve el nombre de los clientes a los que no se les ha entregado a tiempo un pedido.
    @Query("SELECT DISTINCT c.nombreCliente FROM Cliente c JOIN c.pedidos p WHERE p.fechaEntrega IS NULL OR p.fechaEntrega > p.fechaEsperada")
    List<String> obtenerClientesConPedidosFueraDeTiempo();

    // 8. Devuelve un listado de las diferentes gamas de producto que ha comprado cada cliente.
    @Query("SELECT c.nombreCliente, GROUP_CONCAT(DISTINCT pr.gama ORDER BY pr.gama ASC) AS GamasCompradas FROM Cliente c JOIN c.pedidos p JOIN p.detallePedido dp JOIN dp.producto pr GROUP BY c.nombreCliente")
    List<Object[]> obtenerGamasCompradasPorCliente();

    // 9. Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.
    @Query("SELECT c FROM Cliente c LEFT JOIN c.pagos p WHERE p.codigoCliente IS NULL")
    List<Client> obtenerClientesSinPagos();

    // 10. Devuelve un listado que muestre solamente los clientes que no han realizado ningún pedido.
    @Query("SELECT c FROM Cliente c LEFT JOIN c.pedidos pd WHERE pd.codigoCliente IS NULL")
    List<Client> obtenerClientesSinPedidos();

    // 11. Devuelve un listado que muestre los clientes que no han realizado ningún pago y los que no han realizado ningún pedido
    @Query("SELECT c FROM Cliente c LEFT JOIN c.pagos p LEFT JOIN c.pedidos pd WHERE p.codigoCliente IS NULL AND pd.codigoPedido IS NULL")
    List<Client> obtenerClientesSinPagosNiPedidos();

    // 12. Devuelve un listado con los clientes que han realizado algún pedido pero no han realizado ningún pago.
    @Query("SELECT DISTINCT c FROM Cliente c JOIN c.pedidos pd LEFT JOIN c.pagos p WHERE p.codigoCliente IS NULL")
    List<Client> obtenerClientesConPedidosSinPagos();

    // 13. ¿Cuántos clientes tiene cada país?
    @Query("SELECT c.pais, COUNT(c) FROM Cliente c GROUP BY c.pais")
    List<Object[]> obtenerCantidadClientesPorPais();

    // 14. Calcula el número de clientes que tiene la empresa.
    @Query("SELECT COUNT(c) FROM Cliente c")
    Long contarClientes();

    // 15. ¿Cuántos clientes existen con domicilio en la ciudad de Madrid?
    @Query("SELECT COUNT(c) FROM Cliente c WHERE c.ciudad = 'Madrid'")
    Long contarClientesEnMadrid();

    // 16. ¿Calcula cuántos clientes tiene cada una de las ciudades que empiezan por M?
    @Query("SELECT c.ciudad, COUNT(c) FROM Cliente c WHERE c.ciudad LIKE 'M%' GROUP BY c.ciudad")
    List<Object[]> obtenerCantidadClientesPorCiudadQueEmpiezanPorM();

    // 17. Calcula el número de clientes que no tiene asignado representante de ventas.
    @Query("SELECT COUNT(c) FROM Cliente c WHERE c.codigoEmpleadoRepVentas IS NULL")
    Long contarClientesSinRepresentanteVentas();

    // 18. Calcula la fecha del primer y último pago realizado por cada uno de los clientes. El listado deberá mostrar el nombre y los apellidos de cada cliente.
    @Query("SELECT c.nombreCliente, c.nombreContacto, c.apellidoContacto, MIN(p.fechaPago) AS primeraFechaPago, MAX(p.fechaPago) AS ultimaFechaPago FROM Cliente c LEFT JOIN c.pagos p GROUP BY c.nombreCliente, c.nombreContacto, c.apellidoContacto")
    List<Object[]> obtenerFechaPrimerUltimoPagoPorCliente();


    
} 
