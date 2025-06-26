package com.lmo.ninie.io.configurations

import com.lmo.ninie.io.events.EventListener
import discord4j.core.DiscordClientBuilder
import discord4j.core.GatewayDiscordClient
import discord4j.core.event.domain.Event
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.publisher.Mono

@Configuration
class BotConfiguration(
    val botConfigurationProperties: BotConfigurationProperties
) {

    @Bean
    fun <T : Event> startDiscordClient(eventListeners: List<EventListener<T>>): GatewayDiscordClient? {
        return DiscordClientBuilder
            .create(botConfigurationProperties.token)
            .build()
            .login()
            .block()
            ?.let { client -> registerListeners(eventListeners, client) }
    }

    private fun <T : Event> registerListeners(
        eventListeners: List<EventListener<T>>,
        discordClient: GatewayDiscordClient
    ): GatewayDiscordClient {
        eventListeners.forEach { eventListener -> registerListener(eventListener, discordClient) }
        return discordClient
    }

    private fun <T : Event> registerListener(eventListener: EventListener<T>, discordClient: GatewayDiscordClient) {
        discordClient
            .on(eventListener.getEventType())
            .flatMap { event -> eventListener.execute(Mono.just(event)) }
            .onErrorResume { error -> eventListener.handleError(error).block() }
            .subscribe()
    }
}