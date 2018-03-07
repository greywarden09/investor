package pl.greywarden.investor.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import pl.greywarden.investor.model.dto.QueryDto;
import pl.greywarden.investor.repository.WayOfInvestRepository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WayOfInvestServiceTest {

    @Mock
    private WayOfInvestRepository wayOfInvestRepository;

    @Mock
    private QueryDto queryDto;

    @InjectMocks
    private WayOfInvestService wayOfInvestService = new WayOfInvestService();

    @Test
    public void getWayOfInvest() throws Exception {
        // given
        String wayOfInvestName = "name";

        when(queryDto.getWayOfInvest()).thenReturn(wayOfInvestName);

        // when
        wayOfInvestService.getWayOfInvest(queryDto);

        // then
        verify(wayOfInvestRepository, times(1)).findByName(wayOfInvestName);
    }

}