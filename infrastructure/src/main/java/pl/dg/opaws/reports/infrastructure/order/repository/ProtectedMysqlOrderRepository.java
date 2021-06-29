package pl.dg.opaws.reports.infrastructure.order.repository;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import pl.dg.opaws.bl.order.OrderHistory;
import pl.dg.opaws.bl.order.OrderRepository;

import java.util.List;

@Component
@GraphQLApi
public class ProtectedMysqlOrderRepository implements OrderRepository {

    @Autowired
    @Qualifier("mysqlOrderRepository")
    OrderRepository orderRepository;

    @Override
    @GraphQLQuery(name = "ordersByCustomerEmail") // READ BY ID
    @PreAuthorize("@opaClient.allow('read', T(java.util.Map).of('type', 'ordersByCustomerEmail', 'email', #email))")
    public List<OrderHistory> findAllByEmail(@GraphQLArgument(name = "email") String email) {
        return orderRepository.findAllByEmail(email);
    }

    @Override
    @GraphQLQuery(name = "orders") // READ ALL
    @PreAuthorize("@opaClient.allow('read', T(java.util.Map).of('type', 'orders'))")
    public List<OrderHistory> findAll() {
        return orderRepository.findAll();
    }
}
