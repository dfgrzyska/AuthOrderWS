package pl.dg.opaws.bl.order;

import java.util.List;

public interface OrderRepository {
    List<OrderHistory> findAllByEmail(String email);
    List<OrderHistory> findAll();
}
