package hongik.hmut.outer.api.oauth.config;


import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

public class KakaoInfoClientConfig {

    @Bean
    @ConditionalOnMissingBean(value = ErrorDecoder.class)
    public KakaoInfoErrorDecoder commonFeignErrorDecoder() {
        return new KakaoInfoErrorDecoder();
    }

    @Bean
    Encoder formEncoder() {
        return new feign.form.FormEncoder();
    }
}
