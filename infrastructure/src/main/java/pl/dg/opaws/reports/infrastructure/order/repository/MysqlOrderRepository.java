package pl.dg.opaws.reports.infrastructure.order.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dg.opaws.bl.customer.Customer;
import pl.dg.opaws.bl.order.OrderHistory;
import pl.dg.opaws.bl.order.OrderRepository;
import pl.dg.opaws.reports.infrastructure.order.PersistOrderHistory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class MysqlOrderRepository implements OrderRepository {

    @Autowired
    SpringDataOrderRepository springDataOrderRepository;

    @Override
    public List<OrderHistory> findAllByEmail(String email) {
        List<PersistOrderHistory> pohList = springDataOrderRepository.findAllByCustomerEmail(email);
        List<OrderHistory> ohList = new ArrayList<>();
        for(PersistOrderHistory poh : pohList)
        {
            OrderHistory oh = new OrderHistory();
            oh.setId(poh.getId());
            Customer customer = new Customer();
            customer.setId(poh.getCustomer().getId());
            customer.setEmail(poh.getCustomer().getEmail());
            customer.setName(poh.getCustomer().getName());
            oh.setCustomer(customer);
            ohList.add(oh);
        }
        return ohList;
    }

    @Override
    public List<OrderHistory> findAll() {
        List<PersistOrderHistory> allPersistOrderHistory = StreamSupport.stream(springDataOrderRepository
                .findAll()
                .spliterator(), false)
                .collect(Collectors.toList());
        return allPersistOrderHistory.stream().map(poh ->
        {
            OrderHistory oh = new OrderHistory();
            oh.setId(poh.getId());
            Customer customer = new Customer();
            customer.setId(poh.getCustomer().getId());
            customer.setEmail(poh.getCustomer().getEmail());
            customer.setName(poh.getCustomer().getName());
            oh.setCustomer(customer);
            return oh;
        }).collect(Collectors.toList());
    }
}
