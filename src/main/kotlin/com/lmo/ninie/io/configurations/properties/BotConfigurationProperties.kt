package com.lmo.ninie.io.configurations.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "bot")
data class BotConfigurationProperties(val token: String, val prefix: String)