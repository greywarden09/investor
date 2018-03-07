package pl.greywarden.investor.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.greywarden.investor.model.dto.QueryDto;
import pl.greywarden.investor.model.dto.ResultDto;
import pl.greywarden.investor.service.CalculatorService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorResource {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResultDto calculateFunds(@RequestBody QueryDto queryDto) {
        return calculatorService.calculateFunds(queryDto);
    }

}
