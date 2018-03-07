package pl.greywarden.investor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.greywarden.investor.model.FundType;
import pl.greywarden.investor.model.WayOfInvest;
import pl.greywarden.investor.repository.WayOfInvestPercentageRepository;

@Service
public class PercentageService {

    @Autowired
    private WayOfInvestPercentageRepository wayOfInvestPercentageRepository;

    public Integer getPercentageByFundTypeAndWayOfInvest(FundType fundType, WayOfInvest wayOfInvest) {
        return wayOfInvestPercentageRepository.findByFundTypeAndWayOfInvest(fundType, wayOfInvest).getPercentage();
    }

    public int calculatePercentage(int input, int percentage) {
        return (input * percentage) / 100;
    }
}
