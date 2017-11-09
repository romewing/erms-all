/*
 * Copyright (c) 2017 旭博蓝凌.Co.Ltd. All rights reserved.
 */

package com.xblltech.erms;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.security.oauth2.authserver.AuthorizationServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
@EnableConfigurationProperties(AuthorizationServerProperties.class)
public class AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;

    private final TokenStore tokenStore;

    private final AccessTokenConverter tokenConverter;

    private final AuthorizationServerProperties properties;

    public AuthorizationServerConfigurer(AuthenticationManager authenticationManager,
                                         ObjectProvider<TokenStore> tokenStore,
                                         ObjectProvider<AccessTokenConverter> tokenConverter,
                                         AuthorizationServerProperties properties) {
        this.authenticationManager = authenticationManager;
        this.tokenStore = tokenStore.getIfAvailable();
        this.tokenConverter = tokenConverter.getIfAvailable();
        this.properties = properties;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        if (this.properties.getCheckTokenAccess() != null) {
            security.checkTokenAccess(this.properties.getCheckTokenAccess());
        }
        if (this.properties.getTokenKeyAccess() != null) {
            security.tokenKeyAccess(this.properties.getTokenKeyAccess());
        }
        if (this.properties.getRealm() != null) {
            security.realm(this.properties.getRealm());
        }
       /* security.tokenKeyAccess("permitAll()").checkTokenAccess(
                "isAuthenticated()");*/
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("web_app")
                .scopes("FOO")
                .authorities("FOO_READ", "FOO_WRITE")
                .authorizedGrantTypes("implicit", "refresh_token", "password", "authorization_code");

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        if (this.tokenConverter != null) {
            endpoints.accessTokenConverter(this.tokenConverter);
        }
        if (this.tokenStore != null) {
            endpoints.tokenStore(this.tokenStore);
        }
        endpoints.authenticationManager(this.authenticationManager);
    }


}
