package hongik.hmut.infrastructure.config;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import feign.Logger.Level;
import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;
import hongik.hmut.infrastructure.outer.BaseFeignClientPackage;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackageClasses = BaseFeignClientPackage.class)
public class FeignCommonConfig {

    @Bean
    public Decoder feignDecoder() {
        return new JacksonDecoder(customObjectMapper());
    }

    public ObjectMapper customObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);
        return objectMapper;
    }

    @Bean
    Level feignLoggerLevel() {
        return Level.FULL;
    }
}
