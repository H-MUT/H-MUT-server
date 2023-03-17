package hongik.hmut.core.config;


import hongik.hmut.core.jwt.JwtProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({JwtProperties.class})
public class ConfigurationPropertiesConfig {}
