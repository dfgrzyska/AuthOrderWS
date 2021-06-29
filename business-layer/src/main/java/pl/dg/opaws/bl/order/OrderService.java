package pl.dg.opaws.bl.order;

import java.util.List;

public interface OrderService {
    List<OrderHistory> getOrders();
    List<OrderHistory> getAllOrdersByEmail(String email);
}
