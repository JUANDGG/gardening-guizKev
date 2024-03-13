# **Api Gardening GuizKev 👀**

## what does it consist of ? :
The project is to develop a dedicated api to support the operations of a company in the gardening industry. This software will cover several areas, including office and employee details, customer management, orders, products and payments.

## Main objective
The main objective of the project is to develop software dedicated to backing up the operations of a company in the gardening sector.

## Technologies Used
The project will utilize the following technologies:
- Java 
- Spring Boot framework
- MySQL  database


## Database Design
![Database Design](/imagesDocumentation/physical_database_model.png)

## Queries about a table in MySQL

## Multi-table queries (Internal composition) in MySQL

1. Obtén un listado con el nombre de cada cliente y el nombre y apellido de su representante de ventas.

   ```sql
   SELECT c.nombre_cliente AS Nombre_Cliente, CONCAT(e.nombre,' ',e.apellido1,' ',e.apellido2) AS Nombre_Representante_Ventas FROM cliente c JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado;
   ```

2. Muestra el nombre de los clientes que hayan realizado pagos junto con el nombre de sus representantes de ventas.

   ```sql
   SELECT c.codigo_cliente AS codigoCliente, c.nombre_cliente AS nombreCliente, e.nombre AS nombreRepresentanteVentas FROM cliente c JOIN pago p ON c.codigo_cliente = p.codigo_cliente JOIN empleado e
   ON c.codigo_empleado_rep_ventas = e.codigo_empleado;
   ```

3. Muestra el nombre de los clientes que **no** hayan realizado pagos junto con el nombre de sus representantes de ventas.

   ```sql
   SELECT c.codigo_cliente AS codigoCliente, c.nombre_cliente AS nombreCliente, e.nombre AS nombreRepresentanteVentas FROM cliente c Left  JOIN pago p ON c.codigo_cliente = p.codigo_cliente JOIN empleado e
   ON c.codigo_empleado_rep_ventas = e.codigo_empleado;
   ```

4. Devuelve el nombre de los clientes que han hecho pagos y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante.

   ```sql
    SELECT 
    c.nombre_cliente AS NombreCliente,
    e.nombre AS NombreRepresentante,
    o.ciudad AS CiudadRepresentante
    FROM cliente AS c
    JOIN empleado AS e ON c.codigo_empleado_rep_ventas = e.codigo_empleado
    JOIN oficina AS o ON e.codigo_oficina = o.codigo_oficina
    WHERE c.codigo_cliente IN (
    SELECT DISTINCT codigo_cliente
    FROM pago
    );

   ```

5. Devuelve el nombre de los clientes que **no** hayan hecho pagos y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante.

    ```sql
        SELECT c.nombre_cliente AS NombreCliente, e.nombre AS NombreRepresentante, o.ciudad AS CiudadRepresentante
        FROM cliente AS c
        LEFT JOIN empleado AS e ON c.codigo_empleado_rep_ventas = e.codigo_empleado
        LEFT JOIN oficina AS o ON e.codigo_oficina = o.codigo_oficina
        WHERE c.codigo_cliente NOT IN (
        SELECT DISTINCT codigo_cliente
        FROM pago
        ) OR c.codigo_cliente IS NULL;
   ```

6. Lista la dirección de las oficinas que tengan clientes en `Fuenlabrada`.

   ```sql
   SELECT DISTINCT o.linea_direccion1, o.linea_direccion2, o.ciudad, o.region, o.pais, o.codigo_postal
   FROM oficina AS o
   JOIN empleado AS e ON o.codigo_oficina = e.codigo_oficina
   JOIN cliente AS c ON e.codigo_empleado = c.codigo_empleado_rep_ventas
   WHERE c.ciudad = 'Fuenlabrada';

   ```

7. Devuelve el nombre de los clientes y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante.

   ```sql
   SELECT
    c.nombre_cliente AS NombreCliente,
    e.nombre AS NombreRepresentante,
    o.ciudad AS CiudadRepresentante
   FROM cliente AS c
   JOIN empleado AS e ON c.codigo_empleado_rep_ventas = e.codigo_empleado
   JOIN oficina AS o ON e.codigo_oficina = o.codigo_oficina;

   ```

8. Devuelve un listado con el nombre de los empleados junto con el nombre de sus jefes.

   ```sql
   SELECT
    e1.nombre AS NombreEmpleado,
    e2.nombre AS NombreJefe
   FROM empleado AS e1
   LEFT JOIN empleado AS e2 ON e1.codigo_jefe = e2.codigo_empleado;

   ```

9. Devuelve un listado que muestre el nombre de cada empleados, el nombre de su jefe y el nombre del jefe de sus jefe.

   ```sql
   SELECT
    E1.nombre AS NombreEmpleado,
    E2.nombre AS NombreJefe,
    E3.nombre AS NombreJefeDelJefe
   FROM empleado AS E1
   LEFT JOIN empleado AS E2 ON E1.codigo_jefe = E2.codigo_empleado
   LEFT JOIN empleado AS E3 ON E2.codigo_jefe = E3.codigo_empleado;

   ```

10. Devuelve el nombre de los clientes a los que no se les ha entregado a tiempo un pedido.

   ```sql
    SELECT DISTINCT c.nombre_cliente AS NombreCliente
    FROM cliente AS c
    JOIN pedido AS p ON c.codigo_cliente = p.codigo_cliente
    WHERE p.fecha_entrega IS NULL OR p.fecha_entrega > p.fecha_esperada;

   ```

11. Devuelve un listado de las diferentes gamas de producto que ha comprado cada cliente.

   ```sql
   SELECT
  c.nombre_cliente AS NombreCliente,
  GROUP_CONCAT(DISTINCT pr.gama ORDER BY pr.gama ASC) AS GamasCompradas
   FROM cliente AS c
   JOIN pedido AS p ON c.codigo_cliente = p.codigo_cliente
   JOIN detalle_pedido AS dp ON p.codigo_pedido = dp.codigo_pedido
   JOIN producto AS pr ON dp.codigo_producto = pr.codigo_producto
   GROUP BY c.nombre_cliente;

   ```

12. Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.

   ```sql
    SELECT c.*
    FROM cliente c
    LEFT JOIN pago p ON c.codigo_cliente = p.codigo_cliente
    WHERE p.codigo_cliente IS NULL;

   ```

13. Devuelve un listado que muestre solamente los clientes que no han realizado ningún pedido.

   ```sql
   #Consulta aca

   ```

14. Devuelve un listado que muestre los clientes que no han realizado ningún pago y los que no han realizado ningún pedido.

   ```sql
   #Consulta aca

   ```

15. Devuelve un listado que muestre solamente los empleados que no tienen una oficina asociada.

   ```sql
   #Consulta aca

   ```

16. Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado.

   ```sql
   #Consulta aca

   ```

17. Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado junto con los datos de la oficina donde trabajan.

   ```sql
   #Consulta aca

   ```

18. Devuelve un listado que muestre los empleados que no tienen una oficina asociada y los que no tienen un cliente asociado.

   ```sql
   #Consulta aca

   ```

19. Devuelve un listado de los productos que nunca han aparecido en un pedido.

   ```sql
   #Consulta aca

   ```

20. Devuelve un listado de los productos que nunca han aparecido en un pedido. El resultado debe mostrar el nombre, la descripción y la imagen del producto.

   ```sql
   #Consulta aca

   ```

21. Devuelve las oficinas donde **no trabajan** ninguno de los empleados que hayan sido los representantes de ventas de algún cliente que haya realizado la compra de algún producto de la gama `Frutales`.

   ```sql
   #Consulta aca

   ```

22. Devuelve un listado con los clientes que han realizado algún pedido pero no han realizado ningún pago.

   ```sql
   #Consulta aca

   ```

23. Devuelve un listado con los datos de los empleados que no tienen clientes asociados y el nombre de su jefe asociado.

   ```sql
   #Consulta aca

   ```


## Summary queries in MySQL


## Class Diagram
not yet implemented !
![Class Diagram]() 

## Features
The software will include the following features:
- Office and employee management
- Customer management
- Order management
- Product management
- Payment management

## Development Practices
The project will adhere to the following development practices:

- Use of version control (e.g., Git) for code management
- Implementation of unit tests for ensuring code quality
- Adoption of coding standards and best practices
- Documentation of code and project structure
- Continuous integration and deployment for automated builds and deployments


## Next steps
The next steps of the project include

1. Setting up the development environment
2. Database schema design
3. Implementation of backend functionality
4. Application testing and debugging
5. Deployment of the application in a production environment.
6. Ongoing support and maintenance