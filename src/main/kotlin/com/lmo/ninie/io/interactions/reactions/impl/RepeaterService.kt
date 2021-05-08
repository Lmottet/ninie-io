package com.lmo.ninie.io.interactions.reactions.impl

import com.lmo.ninie.io.constants.text.MagicStrings
import com.lmo.ninie.io.constants.text.MagicStrings.REPEATER_TRIGGERS
import com.lmo.ninie.io.interactions.NinieRespondable
import discord4j.core.`object`.entity.Message
import io.vavr.control.Option
import io.vavr.kotlin.option
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class RepeaterService : NinieRespondable<Unit> {

    // todo see whether this creates multiple executions or not  on "di"g
    override fun respondTo(message: Message): Option<Mono<Unit>> = REPEATER_TRIGGERS.stream()
        .map { trigger -> repeatIfTriggered(trigger, message) }
        .filter { it.isDefined }
        .findFirst()
        .orElse(Option.none())

    private fun repeatIfTriggered(trigger: String, message: Message): Option<Mono<Unit>> {
        return message
            .content
            .toLowerCase()
            .option()
            .flatMap { if (it.contains(trigger)) Option.of(response(trigger, it)) else Option.none() }
            .map { message.restChannel.createMessage(it).map { } }
    }

    private fun response(trigger: String, content: String): String =
        content
            .split(trigger)[1] // get the part of the message that follows the trigger
            .trimStart() // remove leading whitespaces
            .replace(MagicStrings.NON_ALPHABETICAL, "")
            .split(MagicStrings.WHITESPACE)[0] // split on whitespace to retrieve only the first word following the trigger

}
