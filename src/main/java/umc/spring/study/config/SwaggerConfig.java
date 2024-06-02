package umc.spring.study.config;



import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI UMCstudyAPI() {



        return new OpenAPI()
                .components(new Components())
                .info(info());

    }
   private Info info(){
        return new Info()
            .title("UMC Server WorkBook API")
            .description("UMC Server WorkBook API 명세서")
            .version("1.0.0");

    }
}