package pl.greywarden.investor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.greywarden.investor.model.FundType;
import pl.greywarden.investor.model.WayOfInvest;
import pl.greywarden.investor.model.dto.CalculatedFundDto;
import pl.greywarden.investor.model.dto.FundDto;
import pl.greywarden.investor.model.dto.QueryDto;
import pl.greywarden.investor.model.dto.ResultDto;
import pl.greywarden.investor.repository.FundTypeRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

@Service
public class CalculatorService {

    @Autowired
    private FundsService fundsService;

    @Autowired
    private WayOfInvestService wayOfInvestService;

    @Autowired
    private FundTypeRepository fundTypeRepository;

    @Autowired
    private PercentageService percentageService;

    @Autowired
    private ResultService resultService;

    public ResultDto calculateFunds(QueryDto queryDto) {
        Map<String, List<FundDto>> fundsGroupedByType = fundsService.groupFundsByType(queryDto);
        WayOfInvest wayOfInvest = wayOfInvestService.getWayOfInvest(queryDto);

        List<CalculatedFundDto> calculatedFunds = new LinkedList<>();

        int input = queryDto.getInput();
        int sum = 0;

        for (String fundTypeName : fundsGroupedByType.keySet()) {
            FundType fundType = fundTypeRepository.findByName(fundTypeName);
            List<FundDto> funds = fundsGroupedByType.get(fundTypeName);

            int percentage = percentageService.getPercentageByFundTypeAndWayOfInvest(fundType, wayOfInvest);
            int wholePart = percentageService.calculatePercentage(input, percentage);
            int fundPart = wholePart / funds.size();
            String partPercentage = format("%.2f", ((double) fundPart / (double) input) * 100);

            funds.stream().map(CalculatedFundDto::new)
                    .forEach(calculatedFundDto -> {
                        calculatedFundDto.setAmount(fundPart);
                        calculatedFundDto.setPercentage(partPercentage);
                        calculatedFunds.add(calculatedFundDto);
                    });
            sum += wholePart;
        }
        int remaining = queryDto.getInput() - sum;

        return resultService.createResult(calculatedFunds, remaining);
    }

}
