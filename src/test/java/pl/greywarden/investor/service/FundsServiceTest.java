package pl.greywarden.investor.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import pl.greywarden.investor.model.dto.FundDto;
import pl.greywarden.investor.model.dto.QueryDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FundsServiceTest {

    @Mock
    private QueryDto queryDto;

    @Mock
    private FundDto fundDto;

    private FundsService fundsService = new FundsService();

    @Test
    public void groupFundsByType() throws Exception {
        // given
        String fundType = "fundType";
        List<FundDto> funds = singletonList(fundDto);

        Map<String, List<FundDto>> expected = new HashMap<>();
        expected.put(fundType, funds);

        when(fundDto.getFundType()).thenReturn(fundType);
        when(queryDto.getFunds()).thenReturn(funds);

        // when
        Map<String, List<FundDto>> result = fundsService.groupFundsByType(queryDto);

        // then
        assertNotNull(result);
        assertThat(result, is(expected));
    }

}