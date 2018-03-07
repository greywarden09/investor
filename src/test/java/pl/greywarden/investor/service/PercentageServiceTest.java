package pl.greywarden.investor.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.greywarden.investor.model.FundType;
import pl.greywarden.investor.model.WayOfInvest;
import pl.greywarden.investor.model.WayOfInvestPercentage;
import pl.greywarden.investor.repository.WayOfInvestPercentageRepository;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PercentageServiceTest {

    @Mock
    private WayOfInvestPercentageRepository wayOfInvestPercentageRepository;

    @Mock
    private FundType fundType;

    @Mock
    private WayOfInvest wayOfInvest;

    @Mock
    private WayOfInvestPercentage wayOfInvestPercentage;

    @InjectMocks
    private PercentageService percentageService = new PercentageService();

    @Test
    public void getPercentageByFundTypeAndWayOfInvest() throws Exception {
        // given
        int percentage = 50;

        when(wayOfInvestPercentageRepository.findByFundTypeAndWayOfInvest(fundType, wayOfInvest))
                .thenReturn(wayOfInvestPercentage);
        when(wayOfInvestPercentage.getPercentage()).thenReturn(percentage);

        // when
        Integer result = percentageService.getPercentageByFundTypeAndWayOfInvest(fundType, wayOfInvest);

        // then
        assertThat(result, is(percentage));
    }

    @Test
    public void calculatePercentage() throws Exception {
        // given
        int input = 25;
        int percentage = 10;
        int expected = 2;

        // when
        int result = percentageService.calculatePercentage(input, percentage);

        // then
        assertThat(result, is(expected));
    }

}