package com.testservice.webapp.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("security")
public class JwtCfg {
        private String uri;
        private String refresh;
        private String header;
        private String prefix;
        private int expiration;
        private String secret;

        public String getSecret() {
                return secret;
        }

        public void setSecret(String secret) {
                this.secret = secret;
        }

        public String getUri() {
                return uri;
        }

        public void setUri(String uri) {
                this.uri = uri;
        }

        public String getRefresh() {
                return refresh;
        }

        public void setRefresh(String refresh) {
                this.refresh = refresh;
        }

        public String getHeader() {
                return header;
        }

        public void setHeader(String header) {
                this.header = header;
        }

        public String getPrefix() {
                return prefix;
        }

        public void setPrefix(String prefix) {
                this.prefix = prefix;
        }

        public int getExpiration() {
                return expiration;
        }

        public void setExpiration(int expiration) {
                this.expiration = expiration;
        }
}

