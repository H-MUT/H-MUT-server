package hongik.hmut.core.config;


import hongik.hmut.core.jwt.JwtProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties({JwtProperties.class})
@Configuration
public class ConfigurationPropertiesConfig {}
