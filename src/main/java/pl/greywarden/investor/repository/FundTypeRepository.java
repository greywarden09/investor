package pl.greywarden.investor.repository;

import org.springframework.data.repository.CrudRepository;
import pl.greywarden.investor.model.FundType;

public interface FundTypeRepository extends CrudRepository<FundType, Long> {

    FundType findByName(String name);

}
