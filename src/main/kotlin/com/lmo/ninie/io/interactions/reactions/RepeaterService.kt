package com.lmo.ninie.io.interactions.reactions

import com.lmo.ninie.io.constants.text.MagicStrings.EXCLAMATION
import com.lmo.ninie.io.constants.text.MagicStrings.REPEATER_TRIGGERS
import com.lmo.ninie.io.constants.text.MagicStrings.WHITESPACE
import com.lmo.ninie.io.interactions.NinieRespondable
import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.MessageData
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.*

@Service
class RepeaterService : NinieRespondable {

    override fun respondTo(message: Message): Mono<MessageData>? = REPEATER_TRIGGERS.stream()
        .filter { message.content.lowercase(Locale.ROOT).contains(it) }
        .findFirst()
        .map { nextWord(it, message.content.lowercase(Locale.ROOT)) }
        .map { nextWord ->
            if (nextWord.length <= 1) null else {
                nextWord.uppercase(Locale.ROOT) + WHITESPACE + EXCLAMATION
            }
        }
        .map { message.restChannel.createMessage(it) }
        .orElse(null)

    private fun nextWord(beacon: String, content: String): String =
        content
            .filter { char -> char.isLetter() || char.isWhitespace() }
            .split(beacon)[1] // get the part of the message that follows the trigger
            .trimStart() // remove leading whitespaces
            .split(WHITESPACE)[0] // split on whitespace to retrieve only the first word following the trigger

}
