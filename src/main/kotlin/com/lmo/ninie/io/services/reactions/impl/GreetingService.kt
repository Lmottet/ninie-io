package com.lmo.ninie.io.services.reactions.impl

import com.lmo.ninie.io.constants.text.MagicStrings.EXCLAMATION
import com.lmo.ninie.io.constants.text.MagicStrings.GREETER_REGEXES
import com.lmo.ninie.io.constants.text.MagicStrings.WHITESPACE
import com.lmo.ninie.io.services.NinieRespondable
import discord4j.core.`object`.entity.Message
import io.vavr.control.Option
import io.vavr.kotlin.option
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.*

@Service
class GreetingService : NinieRespondable<Unit> {
    override fun respondTo(message: Message): Option<Mono<Unit>> =
        GREETER_REGEXES
            .map { regex -> searchGreeter(message.content, regex) }
            .find { it.isDefined }
            .option()
            .map { message.restChannel.createMessage(it.get()).map { } }

    private fun searchGreeter(messageContent: String, regex: Regex): Option<String> {
        val firstWord: String = messageContent.split(WHITESPACE)[0]
        return if (matches(firstWord, regex)) response(firstWord) else Option.none()
    }

    private fun matches (word:String, regex: Regex) = word.toLowerCase(Locale.ROOT).matches(regex)

    private fun response(greeter:String) = (greeter.capitalize() + WHITESPACE + EXCLAMATION).option()

}