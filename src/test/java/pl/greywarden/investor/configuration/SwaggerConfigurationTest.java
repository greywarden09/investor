package pl.greywarden.investor.configuration;

import org.junit.Test;
import springfox.documentation.spring.web.plugins.Docket;

import static org.junit.Assert.*;

public class SwaggerConfigurationTest {

    @Test
    public void api() throws Exception {
        // given
        SwaggerConfiguration swaggerConfiguration = new SwaggerConfiguration();

        // when
        Docket result = swaggerConfiguration.api();

        // then
        assertNotNull(result);
    }

}