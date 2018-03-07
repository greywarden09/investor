package pl.greywarden.investor.repository;

import org.springframework.data.repository.CrudRepository;
import pl.greywarden.investor.model.WayOfInvest;

public interface WayOfInvestRepository extends CrudRepository<WayOfInvest, Long> {

    WayOfInvest findByName(String name);

}
