package pl.greywarden.investor.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.Closeable;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CloseableServiceTest {

    @Mock
    private Closeable closeable;

    @Test
    public void closeCloseable() throws Exception {
        // given
        CloseableService closeableService = new CloseableService();

        // when
        closeableService.closeCloseable(closeable);

        // then
        verify(closeable, times(1)).close();
    }

    @Test
    public void closeNullCloseable() throws Exception {
        // given
        CloseableService closeableService = new CloseableService();

        // when
        closeableService.closeCloseable(null);

        // then

    }

}