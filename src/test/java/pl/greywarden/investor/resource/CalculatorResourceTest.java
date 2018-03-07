package pl.greywarden.investor.resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.greywarden.investor.model.dto.QueryDto;
import pl.greywarden.investor.model.dto.ResultDto;
import pl.greywarden.investor.service.CalculatorService;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorResourceTest {

    @Mock
    private CalculatorService calculatorService;

    @Mock
    private QueryDto queryDto;

    @Mock
    private ResultDto resultDto;

    @InjectMocks
    private CalculatorResource calculatorResource = new CalculatorResource();

    @Test
    public void calculateFunds() throws Exception {
        // given
        when(calculatorService.calculateFunds(queryDto)).thenReturn(resultDto);

        // when
        ResultDto actual = calculatorResource.calculateFunds(queryDto);

        // then
        assertThat(actual, is(resultDto));
    }

}