package ru.andri.simplepdm;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class OpenApiConfig {

    @Value(value = "${build.version:1.0-SNAPSHOT}")
    private String buildVersion;

    private static final String TITLE = "Simple PDM";
    private static final String DESCRIPTION = "Api Documentation";
    private static final String LICENSE = "Apache 2.0";
    private static final String LICENSE_URL = "http://www.apache.org/licenses/LICENSE-2.0";

    @Bean
    public OpenAPI simplePdmOpenAPI() {
        return new OpenAPI()
                .info(new Info().title(TITLE)
                        .description(DESCRIPTION)
                        .version(buildVersion)
                        .license(new License().name(LICENSE).url(LICENSE_URL)));
    }

}
