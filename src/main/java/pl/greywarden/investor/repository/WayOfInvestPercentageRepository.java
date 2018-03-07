package pl.greywarden.investor.repository;

import org.springframework.data.repository.CrudRepository;
import pl.greywarden.investor.model.FundType;
import pl.greywarden.investor.model.WayOfInvest;
import pl.greywarden.investor.model.WayOfInvestPercentage;

public interface WayOfInvestPercentageRepository extends CrudRepository<WayOfInvestPercentage, Long> {

    WayOfInvestPercentage findByFundTypeAndWayOfInvest(FundType fundType, WayOfInvest wayOfInvest);

}
