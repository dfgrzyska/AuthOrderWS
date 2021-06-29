package pl.dg.opaws.reports.infrastructure.customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<PersistCustomer, Long> {

}
