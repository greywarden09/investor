package pl.greywarden.investor.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseInitializationServiceTest {

    @Mock
    private Resource initSql;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private CloseableService closeableService;

    @InjectMocks
    private DatabaseInitializationService databaseInitializationService = new DatabaseInitializationService();

    @Test
    public void initializeDatabase() throws Exception {
        // given
        String sql = "sql";
        InputStream inputStream = new ByteArrayInputStream(sql.getBytes(UTF_8));

        when(initSql.getInputStream()).thenReturn(inputStream);

        // when
        databaseInitializationService.initializeDatabase();

        // then
        verify(closeableService, times(1)).closeCloseable(inputStream);
        verify(jdbcTemplate, times(1)).execute(sql);
    }

    @Test(expected = IOException.class)
    public void initializeDatabaseWithException() throws Exception {
        // given
        when(initSql.getInputStream()).thenThrow(IOException.class);

        // when
        try {
            databaseInitializationService.initializeDatabase();
        }

        // then
        finally {
            verify(closeableService, times(1)).closeCloseable(null);
            verify(jdbcTemplate, times(0)).execute(anyString());
        }
    }

}