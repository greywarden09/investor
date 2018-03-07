package pl.greywarden.investor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.greywarden.investor.model.WayOfInvest;
import pl.greywarden.investor.model.dto.QueryDto;
import pl.greywarden.investor.repository.WayOfInvestRepository;

@Service
public class WayOfInvestService {

    @Autowired
    private WayOfInvestRepository wayOfInvestRepository;

    public WayOfInvest getWayOfInvest(QueryDto queryDto) {
        return wayOfInvestRepository.findByName(queryDto.getWayOfInvest());
    }
}
