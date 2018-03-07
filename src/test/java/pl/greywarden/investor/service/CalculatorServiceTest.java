package pl.greywarden.investor.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.greywarden.investor.model.FundType;
import pl.greywarden.investor.model.WayOfInvest;
import pl.greywarden.investor.model.dto.CalculatedFundDto;
import pl.greywarden.investor.model.dto.FundDto;
import pl.greywarden.investor.model.dto.QueryDto;
import pl.greywarden.investor.model.dto.ResultDto;
import pl.greywarden.investor.repository.FundTypeRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceTest {

    @Mock
    private QueryDto queryDto;

    @Mock
    private FundDto fundDto;

    @Mock
    private WayOfInvest wayOfInvest;

    @Mock
    private WayOfInvestService wayOfInvestService;

    @Mock
    private FundTypeRepository fundTypeRepository;

    @Mock
    private FundType fundType;

    @Mock
    private PercentageService percentageService;

    @Mock
    private FundsService fundsService;

    @Mock
    private ResultService resultService;

    @InjectMocks
    private CalculatorService calculatorService = new CalculatorService();

    @Test
    public void calculateFunds() throws Exception {
        // given
        String fundType = "fundType";
        List<FundDto> funds = singletonList(fundDto);
        int input = 101;
        int percentage = 10;

        String expectedPercentageOfFund = String.format("%.2f", 9.9);

        Map<String, List<FundDto>> fundsGroupedByType = new HashMap<>();
        fundsGroupedByType.put(fundType, funds);

        when(resultService.createResult(anyList(), anyInt())).thenCallRealMethod();
        when(fundsService.groupFundsByType(queryDto)).thenReturn(fundsGroupedByType);
        when(wayOfInvestService.getWayOfInvest(queryDto)).thenReturn(wayOfInvest);
        when(queryDto.getInput()).thenReturn(input);
        when(fundTypeRepository.findByName(fundType)).thenReturn(this.fundType);
        when(percentageService.getPercentageByFundTypeAndWayOfInvest(this.fundType, wayOfInvest)).thenReturn(percentage);
        when(percentageService.calculatePercentage(input, percentage)).thenReturn(10);

        // when
        ResultDto result = calculatorService.calculateFunds(queryDto);

        // then
        verify(resultService, times(1)).createResult(anyList(), eq(91));
        assertThat(result.getFunds(), hasSize(1));
        assertThat(result.getRemaining(), is(91));

        CalculatedFundDto calculatedFundDto = result.getFunds().get(0);

        assertThat(calculatedFundDto.getPercentage(), is(expectedPercentageOfFund));
        assertThat(calculatedFundDto.getAmount(), is(10));
    }

}