package com.lmo.ninie.io.interactions.reactions

import com.lmo.ninie.io.constants.text.Emojis
import com.lmo.ninie.io.interactions.NinieRespondable
import discord4j.core.`object`.entity.Message
import discord4j.core.`object`.reaction.ReactionEmoji
import io.vavr.control.Option
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class StalkerService : NinieRespondable<Unit> {
    override fun respondTo(message: Message): Option<Mono<Unit>> =
        Option.of(message.addReaction(ReactionEmoji.unicode(Emojis.EYES)).map {  })
}