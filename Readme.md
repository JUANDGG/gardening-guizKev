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

## Queries in MySQL

<details>
   <summary>Queries about a table in MySQL</summary>

   1. Devuelve un listado con el código de oficina y la ciudad donde hay oficinas.

   ```sql
   SELECT codigo_oficina, ciudad
   FROM oficina;

   ```

   2. Devuelve un listado con la ciudad y el teléfono de las oficinas de España.

   ```sql
   SELECT ciudad, telefono
   FROM oficina
   WHERE pais = 'España';


   ```
   3. Devuelve un listado con el nombre, apellidos y email de los empleados cuyo jefe tiene un código de jefe igual a 7.

   ```sql
   SELECT nombre, apellido1, apellido2, email
   FROM empleado
   WHERE codigo_jefe = 7;

   ```

   4. Devuelve el nombre del puesto, nombre, apellidos y email del jefe de la empresa.

   ```sql
   SELECT e.puesto AS nombre_puesto, j.nombre, j.apellido1, j.apellido2, j.email
   FROM empleado j
   JOIN empleado e ON j.codigo_empleado = e.codigo_jefe
   WHERE e.codigo_jefe IS NULL;

   ```

   5. Devuelve un listado con el nombre, apellidos y puesto de aquellos empleados que no sean representantes de ventas.

   ```sql
   SELECT nombre, apellido1, apellido2, puesto
   FROM empleado
   WHERE puesto IS NOT NULL AND puesto <> 'Representante Ventas';

   ```

   6. Devuelve un listado con el nombre de los todos los clientes españoles.

   ```sql
   SELECT nombre_cliente
   FROM cliente
   WHERE pais = 'Spain';

   ```

   7. Devuelve un listado con los distintos estados por los que puede pasar un pedido.

   ```sql
   SELECT DISTINCT estado
   FROM pedido;

   ```

   8. Devuelve un listado con el código de cliente de aquellos clientes que realizaron algún pago en 2008. Tenga en cuenta que deberá eliminar aquellos códigos de cliente que aparezcan repetidos. Resuelva la consulta:

   ```sql
   SELECT DISTINCT c.codigo_cliente
   FROM cliente c
   JOIN pago p ON c.codigo_cliente = p.codigo_cliente
   WHERE YEAR(p.fecha_pago) = 2008;

   ```

   9. Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de entrega de los pedidos que no han sido entregados a tiempo.

   ```sql
   SELECT codigo_pedido, codigo_cliente, fecha_esperada,fecha_entrega
   FROM pedido
   WHERE fecha_entrega > fecha_esperada;

   ```

   10. Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de entrega de los pedidos cuya fecha de entrega ha sido al menos dos días antes de la fecha esperada.

   ```sql
   SELECT codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega
   FROM pedido
   WHERE DATEDIFF(fecha_entrega, fecha_esperada) = -2;

   ```

   11. Devuelve un listado de todos los pedidos que fueron **rechazados** en `2009`.

   ```sql
   SELECT codigo_pedido, fecha_pedido, estado, comentarios
   FROM pedido
   WHERE YEAR(fecha_pedido) = 2009 AND estado = 'Rechazado';

   ```

   12. Devuelve un listado de todos los pedidos que han sido **entregados** en el mes de enero de cualquier año.

   ```sql
   SELECT codigo_pedido, fecha_pedido, fecha_entrega, estado
   FROM pedido
   WHERE MONTH(fecha_entrega) = 1;

   ```

   13. Devuelve un listado con todos los pagos que se realizaron en el año `2008` mediante `Paypal`. Ordene el resultado de mayor a menor.

   ```sql
   SELECT *
   FROM pago
   WHERE YEAR(fecha_pago) = 2008 AND forma_pago = 'PayPal'
   ORDER BY total DESC;

   ```

   14. Devuelve un listado con todas las formas de pago que aparecen en la tabla `pago`. Tenga en cuenta que no deben aparecer formas de pago repetidas.

   ```sql
   SELECT DISTINCT forma_pago
   FROM pago;

   ```

   15. Devuelve un listado con todos los productos que pertenecen a la gama `Ornamentales` y que tienen más de `100` unidades en stock. El listado deberá estar ordenado por su precio de venta, mostrando en primer lugar los de mayor precio.

   ```sql
   SELECT codigo_producto, nombre, gama, cantidad_en_stock, precio_venta
   FROM producto
   WHERE gama = 'Ornamentales' AND cantidad_en_stock > 100
   ORDER BY precio_venta DESC;

   ```

   16. Devuelve un listado con todos los clientes que sean de la ciudad de `Madrid` y cuyo representante de ventas tenga el código de empleado `11` o `30`.

   ```sql
   SELECT codigo_cliente, nombre_cliente, ciudad, codigo_empleado_rep_ventas
   FROM cliente
   WHERE ciudad = 'Madrid' AND codigo_empleado_rep_ventas IN (11, 30);

   ```

</details>


<details>
   <summary>Multi-table queries (Internal composition) in MySQL</summary>

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
   SELECT c.nombre_cliente AS NombreCliente, GROUP_CONCAT(DISTINCT pr.gama ORDER BY pr.gama ASC) AS GamasCompradas
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
   SELECT c.*
   FROM cliente c
   LEFT JOIN pedido pd ON c.codigo_cliente = pd.codigo_cliente
   WHERE pd.codigo_cliente IS NULL;

   ```

   14. Devuelve un listado que muestre los clientes que no han realizado ningún pago y los que no han realizado ningún pedido.

   ```sql
   SELECT c.*
   FROM cliente c
   LEFT JOIN pago p ON c.codigo_cliente = p.codigo_cliente
   LEFT JOIN pedido pd ON c.codigo_cliente = pd.codigo_cliente
   WHERE p.codigo_cliente IS NULL AND pd.codigo_pedido IS NULL;   
   ```

   15. Devuelve un listado que muestre solamente los empleados que no tienen una oficina asociada.

   ```sql
   SELECT e.*
   FROM empleado e
   LEFT JOIN oficina o ON e.codigo_oficina = o.codigo_oficina
   WHERE o.codigo_oficina IS NULL;

   ```

   16. Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado.

   ```sql
   SELECT e.*
   FROM empleado e
   LEFT JOIN cliente c ON e.codigo_empleado = c.codigo_empleado_rep_ventas
   WHERE c.codigo_empleado_rep_ventas IS NULL;

   ```

   17. Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado junto con los datos de la oficina donde trabajan.

   ```sql
   SELECT e.*, o.*
   FROM empleado e
   JOIN oficina o ON e.codigo_oficina = o.codigo_oficina
   LEFT JOIN cliente c ON e.codigo_empleado = c.codigo_empleado_rep_ventas
   WHERE c.codigo_empleado_rep_ventas IS NULL;

   ```

   18. Devuelve un listado que muestre los empleados que no tienen una oficina asociada y los que no tienen un cliente asociado.

   ```sql
   SELECT e.*
   FROM empleado e
   LEFT JOIN oficina o ON e.codigo_oficina = o.codigo_oficina
   LEFT JOIN cliente c ON e.codigo_empleado = c.codigo_empleado_rep_ventas
   WHERE o.codigo_oficina IS NULL AND c.codigo_empleado_rep_ventas IS NULL;

   ```

   19. Devuelve un listado de los productos que nunca han aparecido en un pedido.

   ```sql
   SELECT p.*
   FROM producto p
   LEFT JOIN detalle_pedido dp ON p.codigo_producto = dp.codigo_producto
   WHERE dp.codigo_producto IS NULL;

   ```

   20. Devuelve un listado de los productos que nunca han aparecido en un pedido. El resultado debe mostrar el nombre, la descripción y la imagen del producto.

   ```sql
   SELECT p.nombre, p.descripcion, p.imagen
   FROM producto p
   LEFT JOIN detalle_pedido dp ON p.codigo_producto = dp.codigo_producto
   WHERE dp.codigo_producto IS NULL;

   ```

   21. Devuelve las oficinas donde **no trabajan** ninguno de los empleados que hayan sido los representantes de ventas de algún cliente que haya realizado la compra de algún producto de la gama `Frutales`.

   ```sql
   SELECT DISTINCT o.*
   FROM oficina o
   LEFT JOIN empleado e ON o.codigo_oficina = e.codigo_oficina
   LEFT JOIN cliente c ON e.codigo_empleado = c.codigo_empleado_rep_ventas
   LEFT JOIN pedido pd ON c.codigo_cliente = pd.codigo_cliente
   LEFT JOIN detalle_pedido dp ON pd.codigo_pedido = dp.codigo_pedido
   LEFT JOIN producto p ON dp.codigo_producto = p.codigo_producto
   WHERE p.gama = 'Frutales' AND e.codigo_empleado IS NULL;
   ```

   22. Devuelve un listado con los clientes que han realizado algún pedido pero no han realizado ningún pago.

   ```sql
   SELECT DISTINCT c.*
   FROM cliente c
   JOIN pedido pd ON c.codigo_cliente = pd.codigo_cliente
   LEFT JOIN pago p ON c.codigo_cliente = p.codigo_cliente
   WHERE p.codigo_cliente IS NULL;

   ```

   23. Devuelve un listado con los datos de los empleados que no tienen clientes asociados y el nombre de su jefe asociado.

   ```sql
   SELECT e.*, jefe.nombre AS nombre_jefe
   FROM empleado e
   LEFT JOIN cliente c ON e.codigo_empleado = c.codigo_empleado_rep_ventas
   LEFT JOIN empleado jefe ON e.codigo_jefe = jefe.codigo_empleado
   WHERE c.codigo_empleado_rep_ventas IS NULL;

   ```

</details>

<details>
   <summary>Summary queries in MySQL</summary>

   1. ¿Cuántos empleados hay en la compañía?

   ```sql
   SELECT COUNT(*) AS total_empleados
   FROM empleado;

   ```

   2. ¿Cuántos clientes tiene cada país?

   ```sql
   SELECT pais, COUNT(*) AS total_clientes
   FROM cliente
   GROUP BY pais;

   ```

   3. ¿Cuál fue el pago medio en 2009?

   ```sql
   SELECT AVG(total) AS pago_promedio_2009
   FROM pago
   WHERE YEAR(fecha_pago) = 2009;

   ```

   4. ¿Cuántos pedidos hay en cada estado? Ordena el resultado de forma descendente por el número de pedidos.

   ```sql
   SELECT estado, COUNT(*) AS total_pedidos
   FROM pedido
   GROUP BY estado
   ORDER BY total_pedidos DESC;

   ```

   5. Calcula el precio de venta del producto más caro y más barato en una misma consulta.

   ```sql
   SELECT MAX(precio_venta) AS precio_mas_caro, MIN(precio_venta) AS precio_mas_barato
   FROM producto;

   ```

   6. Calcula el número de clientes que tiene la empresa.

   ```sql
   SELECT COUNT(*) AS total_clientes
   FROM cliente;

   ```

   7. ¿Cuántos clientes existen con domicilio en la ciudad de Madrid?

   ```sql
   SELECT COUNT(*) AS total_clientes_madrid
   FROM cliente
   WHERE ciudad = 'Madrid';

   ```

   8. ¿Calcula cuántos clientes tiene cada una de las ciudades que empiezan por `M`?

   ```sql
   SELECT ciudad, COUNT(*) AS total_clientes
   FROM cliente
   WHERE ciudad LIKE 'M%'
   GROUP BY ciudad;

   ```

   9. Devuelve el nombre de los representantes de ventas y el número de clientes al que atiende cada uno.

   ```sql
   SELECT e.nombre, e.apellido1, e.apellido2, COUNT(c.codigo_cliente) AS total_clientes_atendidos
   FROM empleado e
   LEFT JOIN cliente c ON e.codigo_empleado = c.codigo_empleado_rep_ventas
   WHERE e.puesto = 'Representante de Ventas'
   GROUP BY e.codigo_empleado;

   ```

   10. Calcula el número de clientes que no tiene asignado representante de ventas.

   ```sql
   SELECT COUNT(*) AS clientes_sin_representante
   FROM cliente
   WHERE codigo_empleado_rep_ventas IS NULL;

   ```

   11. Calcula la fecha del primer y último pago realizado por cada uno de los clientes. El listado deberá mostrar el nombre y los apellidos de cada cliente.

   ```sql
   SELECT c.nombre_cliente, c.nombre_contacto, c.apellido_contacto,
       MIN(p.fecha_pago) AS primera_fecha_pago,
       MAX(p.fecha_pago) AS ultima_fecha_pago
   FROM cliente c
   LEFT JOIN pago p ON c.codigo_cliente = p.codigo_cliente
   GROUP BY c.codigo_cliente;

   ```

   12. Calcula el número de productos diferentes que hay en cada uno de los pedidos.

   ```sql
   SELECT codigo_pedido, COUNT(DISTINCT codigo_producto) AS num_productos_diferentes
   FROM detalle_pedido
   GROUP BY codigo_pedido;

   ```

   13. Calcula la suma de la cantidad total de todos los productos que aparecen en cada uno de los pedidos.

   ```sql
   SELECT codigo_pedido, SUM(cantidad) AS cantidad_total
   FROM detalle_pedido
   GROUP BY codigo_pedido;

   ```

   14. Devuelve un listado de los 20 productos más vendidos y el número total de unidades que se han vendido de cada uno. El listado deberá estar ordenado por el número total de unidades vendidas.

   ```sql
   SELECT p.codigo_producto, p.nombre, SUM(dp.cantidad) AS total_unidades_vendidas
   FROM producto p
   JOIN detalle_pedido dp ON p.codigo_producto = dp.codigo_producto
   GROUP BY p.codigo_producto, p.nombre
   ORDER BY total_unidades_vendidas DESC
   LIMIT 20;

   ```

   15. La facturación que ha tenido la empresa en toda la historia, indicando la base imponible, el IVA y el total facturado. La base imponible se calcula sumando el coste del producto por el número de unidades vendidas de la tabla `detalle_pedido`. El IVA es el 21 % de la base imponible, y el total la suma de los dos campos anteriores.

   ```sql
   SELECT
      SUM(dp.cantidad * p.precio_venta) AS base_imponible,
      SUM(dp.cantidad * p.precio_venta) * 0.21 AS iva,
      SUM(dp.cantidad * p.precio_venta) + (SUM(dp.cantidad * p.precio_venta) * 0.21) AS total_facturado
   FROM
      detalle_pedido dp
   JOIN
      producto p ON dp.codigo_producto = p.codigo_producto;

   ```

   16. La misma información que en la pregunta anterior, pero agrupada por código de producto.

   ```sql
   SELECT
      p.codigo_producto,
      p.nombre AS nombre_producto,
      SUM(dp.cantidad * p.precio_venta) AS base_imponible,
      SUM(dp.cantidad * p.precio_venta) * 0.21 AS iva,
      SUM(dp.cantidad * p.precio_venta) + (SUM(dp.cantidad * p.precio_venta) * 0.21) AS total_facturado
   FROM
      detalle_pedido dp
   JOIN
      producto p ON dp.codigo_producto = p.codigo_producto
   GROUP BY
      p.codigo_producto, p.nombre;

   ```

   17. La misma información que en la pregunta anterior, pero agrupada por código de producto filtrada por los códigos que empiecen por `OR`.

   ```sql
   SELECT
      p.codigo_producto,
      p.nombre AS nombre_producto,
      SUM(dp.cantidad * p.precio_venta) AS base_imponible,
      SUM(dp.cantidad * p.precio_venta) * 0.21 AS iva,
      SUM(dp.cantidad * p.precio_venta) + (SUM(dp.cantidad * p.precio_venta) * 0.21) AS total_facturado
   FROM
      detalle_pedido dp
   JOIN
      producto p ON dp.codigo_producto = p.codigo_producto
   WHERE
      p.codigo_producto LIKE 'OR%'
   GROUP BY
      p.codigo_producto, p.nombre;

   ```

   18. Lista las ventas totales de los productos que hayan facturado más de 3000 euros. Se mostrará el nombre, unidades vendidas, total facturado y total facturado con impuestos (21% IVA).

   ```sql
   SELECT
    p.nombre AS nombre_producto,
    SUM(dp.cantidad) AS unidades_vendidas,
    SUM(dp.cantidad * p.precio_venta) AS total_facturado,
    SUM(dp.cantidad * p.precio_venta) * 0.21 AS total_facturado_con_iva
   FROM
      detalle_pedido dp
   JOIN
      producto p ON dp.codigo_producto = p.codigo_producto
   GROUP BY
      p.nombre
   HAVING
      total_facturado > 3000;

   ```

   19. Muestre la suma total de todos los pagos que se realizaron para cada uno de los años que aparecen en la tabla `pagos`.

   ```sql
   SELECT YEAR(fecha_pago) AS año, SUM(total) AS suma_total_pagos
   FROM pago
   GROUP BY YEAR(fecha_pago)
   ORDER BY YEAR(fecha_pago);

   ```

</details>

## Class Diagram
[Link Class Diagram](https://drive.google.com/file/d/1BhnQA5zl94FS9KlvVA2zUUOgZXkZM_Uv/view?usp=sharing)

![Class Diagram]()

## Folder organization
![Folder Organization](/imagesDocumentation/FolderOrganitation.png)

# Entity
![Folder Entity](/imagesDocumentation/Entity.png)


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