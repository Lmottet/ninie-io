package com.lmo.ninie.io.interactions.reactions

import com.lmo.ninie.io.constants.text.MagicStrings.EXCLAMATION
import com.lmo.ninie.io.constants.text.MagicStrings.GREETER_REGEXES
import com.lmo.ninie.io.constants.text.MagicStrings.WHITESPACE
import com.lmo.ninie.io.interactions.NinieRespondable
import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.MessageData
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.*

@Service
class GreetingService : NinieRespondable {
    override fun respondTo(message: Message): Mono<MessageData> {
        val greeter = GREETER_REGEXES.firstNotNullOfOrNull { regex -> findGreeter(message.content, regex) }

        return if (greeter != null)
            message.restChannel.createMessage(greeter)
        else
            Mono.empty()
    }

    private fun findGreeter(messageContent: String, regex: Regex): String? {
        val firstWord = messageContent.split(WHITESPACE)[0]
        return if (matches(firstWord, regex)) response(firstWord) else null
    }

    private fun matches(word: String, regex: Regex) = word.lowercase(Locale.ROOT).matches(regex)

    private fun response(greeter: String) = (greeter.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() } + WHITESPACE + EXCLAMATION)

}