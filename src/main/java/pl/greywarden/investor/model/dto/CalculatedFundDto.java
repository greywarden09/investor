package pl.greywarden.investor.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CalculatedFundDto extends FundDto {

    private String percentage;
    private int amount;

    public CalculatedFundDto(FundDto fundDto) {
        setFundType(fundDto.getFundType());
        setId(fundDto.getId());
        setName(fundDto.getName());
    }

}
