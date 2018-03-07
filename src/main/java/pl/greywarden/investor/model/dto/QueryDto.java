package pl.greywarden.investor.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QueryDto {

    @JsonProperty(required = true)
    private List<FundDto> funds;

    @JsonProperty(required = true)
    private Integer input;

    @JsonProperty(required = true)
    private String wayOfInvest;
}
