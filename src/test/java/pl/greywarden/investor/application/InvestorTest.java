package pl.greywarden.investor.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

import static org.apache.commons.lang3.reflect.FieldUtils.writeDeclaredStaticField;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InvestorTest {

    @Mock
    private SpringApplication springApplication;

    @Mock
    private Environment environment;

    @Mock
    private PrintStream printStream;

    @InjectMocks
    private Investor investor = new Investor();

    @Test
    public void main() throws Exception {
        // given
        String[] args = {"arg1", "arg2"};

        writeDeclaredStaticField(Investor.class, "springApplication", springApplication, true);

        // when
        Investor.main(args);

        // then
        verify(springApplication, times(1)).run(args);
    }

    @Test
    public void printApplicationStatus() throws Exception {
        // given
        String applicationName = "applicationName";
        String applicationPort = "applicationPort";
        String[] activeProfiles = {"dev"};

        when(environment.getActiveProfiles()).thenReturn(activeProfiles);
        when(environment.getProperty("spring.application.name")).thenReturn(applicationName);
        when(environment.getProperty("server.port")).thenReturn(applicationPort);

        System.setOut(printStream);

        // when
        investor.printApplicationStatus();

        // then
        verify(printStream, times(2)).write(any(byte[].class));
    }

}