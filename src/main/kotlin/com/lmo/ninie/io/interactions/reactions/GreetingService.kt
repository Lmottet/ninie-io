package com.lmo.ninie.io.interactions.reactions

import com.lmo.ninie.io.constants.text.MagicStrings.EXCLAMATION
import com.lmo.ninie.io.constants.text.MagicStrings.GREETER_REGEXES
import com.lmo.ninie.io.constants.text.MagicStrings.WHITESPACE
import com.lmo.ninie.io.interactions.NinieRespondable
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
            .map { regex -> findGreeter(message.content, regex) }
            .find { it.isDefined }
            .option()
            .map { message.restChannel.createMessage(it.get()).map { } }

    private fun findGreeter(messageContent: String, regex: Regex): Option<String> {
        val firstWord: String = messageContent.split(WHITESPACE)[0]
        return if (matches(firstWord, regex)) response(firstWord) else Option.none()
    }

    private fun matches (word:String, regex: Regex) = word.lowercase(Locale.ROOT).matches(regex)

    private fun response(greeter:String) = (greeter.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() } + WHITESPACE + EXCLAMATION).option()

}