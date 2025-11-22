package io.lmo.ninie.api.configurations

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "appsecurity")
data class SecurityConfigurationProperties(val jwtSecret: String, val allowedOrigin: String)

//openssl rand -base64 64