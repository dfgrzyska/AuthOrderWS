package pl.dg.opaws.reports.infrastructure.order.repository;

import org.springframework.data.repository.CrudRepository;
import pl.dg.opaws.reports.infrastructure.order.PersistOrderHistory;

import java.util.List;

public interface SpringDataOrderRepository extends CrudRepository<PersistOrderHistory, Long> {
    List<PersistOrderHistory> findAllByCustomerEmail(String email);

}
