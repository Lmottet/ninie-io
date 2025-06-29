package com.lmo.ninie.io.interactions.reactions

import com.lmo.ninie.io.constants.text.MagicStrings.EXCLAMATION
import com.lmo.ninie.io.constants.text.MagicStrings.REPEATER_TRIGGERS
import com.lmo.ninie.io.constants.text.MagicStrings.WHITESPACE
import com.lmo.ninie.io.interactions.NinieRespondable
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.util.*

@Service
class RepeaterService : NinieRespondable {

    override fun respondTo(message: Message) = Flux.fromIterable(REPEATER_TRIGGERS)
        .filter { message.content.lowercase(Locale.ROOT).contains(it) }
        .map { nextWord(message.content.lowercase(Locale.ROOT), it) }
        .filter { nextWord -> nextWord.length > 1 }
        .next()
        .map { nextWord -> "${nextWord.uppercase(Locale.ROOT)}$WHITESPACE$EXCLAMATION" }
        .flatMap { response -> message.restChannel.createMessage(response) }

    fun nextWord(input: String, target: String): String {
        val index = input.indexOf(target)
        if (index == -1) return ""

        val start = index + target.length
        val remainder = input.substring(start).trimStart()

        val endIndex = remainder.indexOfFirst { it.isWhitespace() }
        return if (endIndex == -1) remainder else remainder.substring(0, endIndex)
    }
}