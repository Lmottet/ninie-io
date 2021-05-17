package com.lmo.ninie.io.interactions.reactions

import com.lmo.ninie.io.interactions.NinieRespondable
import discord4j.core.`object`.entity.Message
import io.vavr.control.Option
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class DisagreementService : NinieRespondable<Unit> {

    override fun respondTo(message: Message): Option<Mono<Unit>> {
        //val shouldResp =
        return if ((1..50).random() == 42)
            Option.of(message.restChannel.createMessage("NON !").map { })
        else Option.none()
    }

}