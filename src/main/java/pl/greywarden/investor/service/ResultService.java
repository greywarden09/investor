package pl.greywarden.investor.service;

import org.springframework.stereotype.Service;
import pl.greywarden.investor.model.dto.CalculatedFundDto;
import pl.greywarden.investor.model.dto.ResultDto;

import java.util.List;

@Service
public class ResultService {

    public ResultDto createResult(List<CalculatedFundDto> calculatedFunds, int remaining) {
        ResultDto resultDto = new ResultDto();
        resultDto.setFunds(calculatedFunds);
        resultDto.setRemaining(remaining);
        return resultDto;
    }

}
