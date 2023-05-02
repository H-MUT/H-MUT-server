package hongik.hmut.api.auth.service.helper;

import hongik.hmut.core.dto.OIDCDto;
import hongik.hmut.core.jwt.JwtOIDCProvider;
import hongik.hmut.outer.api.oauth.dto.OIDCPublicKeyDto;
import hongik.hmut.outer.api.oauth.dto.OIDCResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OIDCHelper {

    private final JwtOIDCProvider jwtOIDCProvider;

    private String getKidFromUnsignedIdToken(String token, String iss, String aud) {
        return jwtOIDCProvider.getKidFromUnsignedTokenHeader(token, iss, aud);
    }

    public OIDCDto getPayloadFromIdToken(
        String token, String iss, String aud, OIDCResponse oidcResponse) {
        String kid = getKidFromUnsignedIdToken(token, iss, aud);

        OIDCPublicKeyDto oidcPublicKeyDto =
            oidcResponse.getOidcPublicKeyDtos().stream()
                .filter(o -> o.getKid().equals(kid))
                .findFirst()
                .orElseThrow();

        return jwtOIDCProvider.getOIDCTokenBody(
            token, oidcPublicKeyDto.getN(), oidcPublicKeyDto.getE());
    }
}
