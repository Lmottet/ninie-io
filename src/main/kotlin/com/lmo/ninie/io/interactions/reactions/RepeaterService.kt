package com.lmo.ninie.io.interactions.reactions

import com.lmo.ninie.io.constants.text.MagicStrings
import com.lmo.ninie.io.constants.text.MagicStrings.REPEATER_TRIGGERS
import com.lmo.ninie.io.interactions.NinieRespondable
import discord4j.core.`object`.entity.Message
import io.vavr.control.Option
import io.vavr.kotlin.option
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.*

@Service
class RepeaterService : NinieRespondable<Unit> {

    override fun respondTo(message: Message): Option<Mono<Unit>> = REPEATER_TRIGGERS.stream()
        .map { trigger -> repeatIfTriggered(trigger, message) }
        .filter { it.isDefined }
        .findFirst()
        .orElse(Option.none())

    private fun repeatIfTriggered(trigger: String, message: Message): Option<Mono<Unit>> {
        return message
            .content
            .lowercase(Locale.ROOT)
            .option()
            .flatMap { buildResponse(trigger, it) }
            .map { message.restChannel.createMessage(it).map { } }
    }

    private fun buildResponse(trigger: String, content: String): Option<String> {
        return if (!content.contains(trigger)) Option.none() else {
            val nextWord = nextWord(trigger, content)
            return if (nextWord.length > 1) Option.of(nextWord.uppercase(Locale.ROOT) + MagicStrings.WHITESPACE + MagicStrings.EXCLAMATION) else Option.none()
        }
    }

    private fun nextWord(trigger: String, content: String): String =
        content
            .filter { char -> char.isLetter() || char.isWhitespace() }
            .split(trigger)[1] // get the part of the message that follows the trigger
            .trimStart() // remove leading whitespaces
            .split(MagicStrings.WHITESPACE)[0] // split on whitespace to retrieve only the first word following the trigger

}
