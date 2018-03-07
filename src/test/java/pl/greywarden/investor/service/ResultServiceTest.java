package pl.greywarden.investor.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.greywarden.investor.model.dto.CalculatedFundDto;
import pl.greywarden.investor.model.dto.ResultDto;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ResultServiceTest {

    @Mock
    private List<CalculatedFundDto> calculatedFunds;

    @Test
    public void createResult() throws Exception {
        // given
        int remaining = 5;
        ResultService resultService = new ResultService();

        // when
        ResultDto result = resultService.createResult(calculatedFunds, remaining);

        // then
        assertNotNull(result);
        assertThat(result.getFunds(), is(calculatedFunds));
        assertThat(result.getRemaining(), is(remaining));
    }

}