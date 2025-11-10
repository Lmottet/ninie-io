package io.lmo.ninie.discord.interactions.reactions

import io.lmo.ninie.discord.eventmessage.knownGuild
import io.lmo.ninie.discord.interactions.NinieRespondable
import io.lmo.ninie.discord.KnownGuild
import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.MessageData
import io.lmo.ninie.data.constants.text.Emojis
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.*

@Service
class TriggeredResponseService : NinieRespondable {
    override fun respondTo(message: Message): Mono<MessageData> {
        val content = message.content.lowercase(Locale.ROOT)
        val guild = message.knownGuild();
        return if (content.contains("bite"))
            message.restChannel.createMessage("Hehe bite")
        else if (content.contains("penis"))
            message.restChannel.createMessage("Hehe penis")
        else if (content.contains("fesses"))
            message.restChannel.createMessage("Hehe fesses")
        else if (content.contains("dans ton cul"))
            message.restChannel.createMessage("TOUS DANS SON CUL")
        else if (content.contains("mojito"))
            message.restChannel.createMessage("Que se paso ? Old el paso ? No no jose ! No no jose ! No se bueno.")
        else if (content.contains("porto"))
            message.restChannel.createMessage("Un grand pour moi !")
        else if (guild == KnownGuild.Teuteu || guild == KnownGuild.Doom) {
            if (content.contains("clef"))
                message.restChannel.createMessage("Une clef ? Je heal !")
            else if (content.contains(" ness ") || content.contains("nessa"))
                message.restChannel.createMessage("Ma nessouille ${Emojis.HEART}")
            else if (content.contains("je rigole"))
                message.restChannel.createMessage("T'as pas vu le panneau blague là ?")
            else
                Mono.empty()
        } else if (guild == KnownGuild.Nani) {
            if (content.contains("burger"))
                message.restChannel.createMessage("Thomas !!! N'oublies pas le burger de JP :D")
            else Mono.empty()
        } else
            Mono.empty()
    }
}
