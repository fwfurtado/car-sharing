package me.fwfurtado.carsharing.configurations;

import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuthServerConfiguration extends AuthorizationServerConfigurerAdapter {

    private final RedisConnectionFactory redisConnectionFactory;
    private final AuthenticationManager authenticationManager;
    private final OAuth2ClientProperties clientProperties;

    public OAuthServerConfiguration(RedisConnectionFactory redisConnectionFactory, AuthenticationManager authenticationManager, OAuth2ClientProperties clientProperties) {
        this.redisConnectionFactory = redisConnectionFactory;
        this.authenticationManager = authenticationManager;
        this.clientProperties = clientProperties;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
            .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        ClientDetailsService

        clients.inMemory()
            .withClient(clientProperties.getClientId())
            .secret(clientProperties.getClientSecret())
            .scopes("write");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
            .tokenStore(tokenStore())
            .accessTokenConverter(accessTokenConverter())
            .authenticationManager(authenticationManager);
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenService() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();

        tokenServices.setTokenStore(tokenStore());
        tokenServices.setSupportRefreshToken(true);

        return tokenServices;
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setKeyPair(keyPair);
        converter.setSigningKey("123");
        return converter;
    }
}
