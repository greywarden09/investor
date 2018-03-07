package pl.greywarden.investor.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResultDto {

    private List<CalculatedFundDto> funds;
    private int remaining;

}
