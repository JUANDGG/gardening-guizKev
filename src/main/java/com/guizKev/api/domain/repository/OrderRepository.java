package com.guizKev.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.guizKev.api.persistence.entity.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order ,Integer>{

     // 1. Retrieve a list of the distinct states that an order can pass through.
    @Query("SELECT DISTINCT o.state FROM Order o")
    List<String> findDistinctOrderStates();

    // 2. Retrieve a list of order code, client code, expected date, and delivery date for orders that have not been delivered on time.
    @Query("SELECT o.orderCode, o.client.clientCode, o.expectedDate, o.deliveryDate FROM Order o WHERE o.deliveryDate > o.expectedDate")
    List<Object[]> findOrdersNotDeliveredOnTime();

    // 3. Retrieve a list of order code, client code, expected date, and delivery date for orders where the delivery date is at least a certain number of days before the expected date.
    @Query("SELECT o.orderCode, o.client.clientCode, o.expectedDate, o.deliveryDate FROM Order o WHERE DATEDIFF(o.deliveryDate, o.expectedDate) = :daysBefore")
    List<Object[]> findOrdersDeliveredDaysBeforeExpectedDate(@Param("daysBefore") int daysBefore);
    
    // 4. Retrieve a list of all orders that were rejected in a certain year.
    @Query("SELECT o.orderCode, o.orderDate, o.state, o.comments FROM Order o WHERE EXTRACT(YEAR FROM o.orderDate) = :year AND o.state = 'Rechazado'")
    List<Object[]> findRejectedOrdersInYear(@Param("year") int year);

    // 5. Retrieve a list of all orders that have been delivered in a certain month of any year.
    @Query("SELECT o.orderCode, o.orderDate, o.deliveryDate, o.state FROM Order o WHERE MONTH(o.deliveryDate) = :month")
    List<Object[]> findOrdersDeliveredInMonth(@Param("month") int month);

    // 6. How many orders are there in each state? Order the result in descending order by the number of orders.
    @Query("SELECT o.state, COUNT(*) AS totalOrders FROM Order o GROUP BY o.state ORDER BY totalOrders DESC")
    List<Object[]> countOrdersByState();
    
}
