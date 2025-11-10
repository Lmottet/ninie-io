package io.lmo.ninie.discord.events.messages

import io.lmo.ninie.discord.eventmessage.callsNinie
import io.lmo.ninie.discord.eventmessage.extractCommandAlias
import io.lmo.ninie.discord.eventmessage.isBotAuthor
import io.lmo.ninie.discord.configuration.BotConfigurationProperties
import discord4j.core.`object`.entity.Message
import discord4j.core.event.domain.message.MessageCreateEvent
import io.lmo.ninie.discord.eventmessage.knownGuild
import io.lmo.ninie.discord.events.EventListener
import io.lmo.ninie.discord.interactions.RespondableMapperService
import io.lmo.ninie.discord.interactions.commands.Alias
import io.lmo.ninie.discord.services.AliasService
import io.lmo.ninie.discord.services.SilenceService
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class MessageCreateListener(
    private val respondableMapperService: RespondableMapperService,
    private val aliasService: AliasService,
    private val silenceService: SilenceService,
    private val botConfigurationProperties: BotConfigurationProperties
) : EventListener<MessageCreateEvent>() {

    override fun getEventType(): Class<MessageCreateEvent> = MessageCreateEvent::class.java

    override fun execute(event: Mono<MessageCreateEvent>): Mono<*> {
        return event.flatMap { messageCreateEvent ->
            execute(messageCreateEvent.message)
        }
    }

    private fun execute(message: Message): Mono<*> {
        val guild = message.knownGuild()
        if (guild != null && silenceService.shouldKeepQuiet(guild))
            return Mono.empty<Unit>();

        return when {
            message.callsNinie(botConfigurationProperties.prefix) -> aliasService.mapToCommand(findAlias(message)).respondTo(message)
            !message.isBotAuthor() -> respondableMapperService.reactToCreation(message)
            else -> Mono.empty<Unit>()
        }
    }

    private fun findAlias(message: Message): Alias {
        return aliasService.find(message.extractCommandAlias()) ?: Alias.Unknown
    }
}
