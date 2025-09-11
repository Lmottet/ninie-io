package com.lmo.ninie.io.configurations

import com.lmo.ninie.io.configurations.properties.BotConfigurationProperties
import com.lmo.ninie.io.discord.events.EventListener
import discord4j.common.ReactorResources
import discord4j.core.DiscordClientBuilder
import discord4j.core.GatewayDiscordClient
import discord4j.core.event.domain.Event
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.publisher.Mono
import reactor.netty.resources.ConnectionProvider
import java.time.Duration

@Configuration
class BotConfiguration(
    val botConfigurationProperties: BotConfigurationProperties
) {

    @Bean
    fun <T : Event> startDiscordClient(eventListeners: List<EventListener<T>>): GatewayDiscordClient {

        val provider = ConnectionProvider.builder("fixed")
            .maxConnections(500)
            .maxIdleTime(Duration.ofSeconds(20))
            .maxLifeTime(Duration.ofSeconds(60))
            .pendingAcquireTimeout(Duration.ofSeconds(60))
            .evictInBackground(Duration.ofSeconds(120)).build()
        val client = DiscordClientBuilder
            .create(botConfigurationProperties.token)
            .setReactorResources(ReactorResources.builder().httpClient(ReactorResources.newHttpClient(provider)).build())
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

        client.onDisconnect()
            .subscribe {
                println("🔌 Discord client disconnected")
            }

        return client
    }
}
