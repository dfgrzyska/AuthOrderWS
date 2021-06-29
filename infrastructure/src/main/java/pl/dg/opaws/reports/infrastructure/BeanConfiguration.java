package pl.dg.opaws.reports.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.dg.opaws.bl.order.DomainOrderService;
import pl.dg.opaws.bl.order.OrderRepository;
import pl.dg.opaws.bl.order.OrderService;

@Configuration
public class BeanConfiguration {

    @Autowired
    @Qualifier("protectedMysqlOrderRepository")
    private OrderRepository orderRepository;

    @Bean
    OrderService orderService() {
        return new DomainOrderService(orderRepository);
    }
}
