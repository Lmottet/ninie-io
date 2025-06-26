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
    fun <T : Event> startDiscordClient(eventListeners: List<EventListener<T>>): GatewayDiscordClient {
        val client = DiscordClientBuilder
            .create(botConfigurationProperties.token)
            .build()
            .login()
            .block() ?: throw IllegalStateException("Discord client failed to login")

        // Register listeners
        eventListeners.forEach { eventListener ->
            client.on(eventListener.getEventType())
                .flatMap { event ->
                    eventListener.execute(Mono.just(event))
                        ?.onErrorResume { error ->
                            eventListener.handleError(error)
                                .onErrorResume { Mono.empty() }
                        }
                        ?: Mono.empty()
                }
                .subscribe()
        }

        // This will block the Spring Boot application startup thread and keep JVM alive until disconnect
        // Alternatively, run this in a separate thread if you want Spring to continue starting
        client.onDisconnect().block()

        return client
    }
}
