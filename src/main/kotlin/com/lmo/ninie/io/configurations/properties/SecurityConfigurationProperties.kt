package com.lmo.ninie.io.configurations.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "app-security")
data class SecurityConfigurationProperties(val jwtSecret: String, val allowedOrigin: String)