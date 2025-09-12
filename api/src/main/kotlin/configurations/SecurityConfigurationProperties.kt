package com.lmo.ninie.io.configurations

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "app-security")
data class SecurityConfigurationProperties(val jwtSecret: String, val allowedOrigin: String)