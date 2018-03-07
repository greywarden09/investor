package pl.greywarden.investor.service;

import org.springframework.stereotype.Service;
import pl.greywarden.investor.model.dto.FundDto;
import pl.greywarden.investor.model.dto.QueryDto;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Service
public class FundsService {

    public Map<String, List<FundDto>> groupFundsByType(QueryDto queryDto) {
        return queryDto.getFunds().stream().collect(groupingBy(FundDto::getFundType));
    }

}
