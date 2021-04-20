package com.lmo.ninie.io.services.reactions.impl

import com.lmo.ninie.io.constants.text.MagicStrings
import com.lmo.ninie.io.constants.text.MagicStrings.REPEATER_TRIGGERS
import com.lmo.ninie.io.services.NinieRespondable
import discord4j.core.`object`.entity.Message
import io.vavr.control.Option
import io.vavr.kotlin.option
import reactor.core.publisher.Mono

class RepeaterService : NinieRespondable<Unit> {

    // TODO validate ordering will not be lost between triggers
    override fun respondTo(message: Message): Option<Mono<Unit>> = REPEATER_TRIGGERS.stream()
        .map { trigger -> repeatedIfTriggered(trigger, message) }
        .filter { repetition -> repetition.isDefined }
        .findFirst()
        .orElse(Option.none())

    private fun repeatedIfTriggered(trigger: String, message: Message): Option<Mono<Unit>> {
        return message
            .content
            .toLowerCase()
            .option()
            .flatMap { if (it.contains(trigger)) Option.of(response(trigger, it)) else Option.none() }
            .map { message.restChannel.createMessage(it).map { } }
    }

    private fun response(trigger: String, content: String): String =
        content.split(trigger)[2].split(MagicStrings.WHITESPACE)[0]

}
