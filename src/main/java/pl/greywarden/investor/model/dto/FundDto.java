package pl.greywarden.investor.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FundDto {

    @JsonProperty(required = true)
    private Long id;

    @JsonProperty(required = true)
    private String name;

    @JsonProperty(required = true)
    private String fundType;

}
