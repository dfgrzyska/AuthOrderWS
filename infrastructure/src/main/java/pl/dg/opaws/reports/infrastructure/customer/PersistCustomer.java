package pl.dg.opaws.reports.infrastructure.customer;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name="customer")
public class PersistCustomer implements Serializable {
    @Id
    @GraphQLQuery(name = "customerId", description = "A customer id")
    private Long id;

    @GraphQLQuery(name = "name", description = "A customer name")
    private String name;

    @Column(unique = true)
    @GraphQLQuery(name = "email", description = "A customer email")
    private String email;
}
