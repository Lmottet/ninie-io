package io.lmo.ninie.discord.interactions.reactions

import io.lmo.ninie.discord.interactions.NinieRespondable
import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.MessageData
import io.lmo.ninie.data.constants.text.MagicStrings.EXCLAMATION
import io.lmo.ninie.data.constants.text.MagicStrings.GREETER_REGEXES
import io.lmo.ninie.data.constants.text.MagicStrings.WHITESPACE
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

    private fun response(greeter: String): String {
        val capitalized = greeter.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
        }
        return "$capitalized $EXCLAMATION"
    }

}