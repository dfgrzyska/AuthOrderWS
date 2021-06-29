package pl.dg.opaws.bl.order;

import java.util.List;

public class DomainOrderService implements OrderService{

    private final OrderRepository orderRepository;

    public DomainOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderHistory> getOrders() {
        return orderRepository.findAll();
    }

    public List<OrderHistory> getAllOrdersByEmail(String email) {
        return orderRepository.findAllByEmail(email);
    }
}
