package pl.dg.opaws.reports.infrastructure.order;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Getter;
import lombok.Setter;
import pl.dg.opaws.reports.infrastructure.customer.PersistCustomer;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="order_history")
public class PersistOrderHistory implements Serializable {
    @Id
    @GraphQLQuery(name = "id", description = "A order id")
    private Long id;

    @GraphQLQuery(name = "customer", description = "A customer")
    @OneToOne
    @JoinColumn(name = "customer_email", referencedColumnName = "email")
    private PersistCustomer customer;
}
