package pl.dg.opaws.bl.order;

import lombok.Getter;
import lombok.Setter;
import pl.dg.opaws.bl.customer.Customer;

@Getter
@Setter
public class OrderHistory {
    private Long id;
    private Customer customer;
}
