package pl.greywarden.investor.service;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Service
@CommonsLog
public class DatabaseInitializationService {

    @Autowired
    private CloseableService closeableService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("classpath:initialization.sql")
    private Resource initSql;

    @EventListener(ApplicationReadyEvent.class)
    public void initializeDatabase() throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = initSql.getInputStream();

            String sql = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            jdbcTemplate.execute(sql);

        } finally {
            closeableService.closeCloseable(inputStream);
        }
    }

}
