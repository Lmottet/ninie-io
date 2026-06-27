package io.lmo.ninie.discord.interactions.reactions

import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.MessageData
import io.lmo.ninie.data.constants.text.Emojis
import io.lmo.ninie.discord.KnownGuild
import io.lmo.ninie.discord.eventmessage.knownGuild
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.Locale

@Service
@Order(2)
class TriggeredResponseService : CreationReactionService {

    companion object {
        private val RULES = listOf(
            TriggerRule(listOf("bite"), response = "Hehe bite"),
            TriggerRule(listOf("penis"), response = "Hehe penis"),
            TriggerRule(listOf("fesses"), response = "Hehe fesses"),
            TriggerRule(listOf("dans ton cul"), response = "TOUS DANS SON CUL"),
            TriggerRule(listOf("mojito"), response = "Que se paso ? Old el paso ? No no jose ! No no jose ! No se bueno."),
            TriggerRule(listOf("porto"), response = "Un grand pour moi !"),
            TriggerRule(
                keywords = listOf("clef"),
                guilds = setOf(KnownGuild.Teuteu, KnownGuild.Doom),
                response = "Une clef ? Je heal !"
            ),
            TriggerRule(
                keywords = listOf(" ness ", "nessa"),
                guilds = setOf(KnownGuild.Teuteu, KnownGuild.Doom),
                response = "Ma nessouille ${Emojis.HEART}"
            ),
            TriggerRule(
                keywords = listOf("je rigole"),
                guilds = setOf(KnownGuild.Teuteu, KnownGuild.Doom),
                response = "T'as pas vu le panneau blague là ?"
            ),
            TriggerRule(
                keywords = listOf("burger"),
                guilds = setOf(KnownGuild.Nani),
                response = "Thomas !!! N'oublies pas le burger de JP :D"
            ),
        )
    }

    override fun respondTo(message: Message): Mono<MessageData> {
        val content = message.content.lowercase(Locale.ROOT)
        val guild = message.knownGuild()

        val rule = RULES.firstOrNull { rule ->
            (rule.guilds == null || guild in rule.guilds) &&
            rule.keywords.any { content.contains(it) }
        } ?: return Mono.empty()

        return message.restChannel.createMessage(rule.response)
    }
}
