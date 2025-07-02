package com.lmo.ninie.io.interactions.reactions

import com.lmo.ninie.io.constants.text.Emojis
import com.lmo.ninie.io.interactions.NinieRespondable
import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.MessageData
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.*

@Service
class TriggeredResponseService : NinieRespondable {
    override fun respondTo(message: Message): Mono<MessageData> {
        val content = message.content.lowercase(Locale.ROOT)
        return if (content.contains("bite"))
            message.restChannel.createMessage("Hehe bite")
        else if (content.contains("penis"))
            message.restChannel.createMessage("Hehe penis")
        else if (content.contains("mojito"))
            message.restChannel.createMessage("Que se paso ? Old el paso ? No no jose ! No no jose ! No se bueno.")
        else if (content.contains("porto"))
            message.restChannel.createMessage("Un grand pour moi !")
        else if (content.contains("clef"))
            message.restChannel.createMessage("Une clef ? Je heal !")
        else if (content.contains("la ness") || content.contains("nessa"))
            message.restChannel.createMessage("Ma nessouille ${Emojis.HEART}")
        else if (content.contains("je rigole"))
            message.restChannel.createMessage("T'as pas vu le panneau blague là ?")
        else
            Mono.empty()
    }
}
