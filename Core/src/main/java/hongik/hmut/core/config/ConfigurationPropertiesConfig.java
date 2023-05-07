package hongik.hmut.core.config;


import hongik.hmut.core.properties.JwtProperties;
import hongik.hmut.core.properties.OauthProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties({JwtProperties.class, OauthProperties.class})
@Configuration
public class ConfigurationPropertiesConfig {}
