package com.lmo.ninie.io.interactions.reactions

import com.lmo.ninie.io.interactions.NinieRespondable
import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.MessageData
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class DisagreementService : NinieRespondable {

    override fun respondTo(message: Message): Mono<MessageData> =
        if ((1..50).random() == 42)
            message.restChannel.createMessage("NON !")
        else Mono.empty()
}
