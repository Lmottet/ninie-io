package com.lmo.ninie.io.interactions.reactions

import com.lmo.ninie.io.constants.text.MagicStrings.EXCLAMATION
import com.lmo.ninie.io.constants.text.MagicStrings.WHITESPACE
import com.lmo.ninie.io.interactions.NinieRespondable
import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.MessageData
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class RepeaterService : NinieRespondable {
    val REPEATER_TRIGGERS = listOf("dites", "dire", "dis", "dit")

    override fun respondTo(message: Message): Mono<MessageData> {
        val content = message.content.lowercase(Locale.ROOT)
        val shortRepeat = content.split("di")
        if (shortRepeat.isNotEmpty() && shortRepeat[1][0] != WHITESPACE && shortRepeat[1][1] != WHITESPACE) {
            val response = shortRepeat[1].split(WHITESPACE);
            if (response[0].isNotEmpty())
                return message.restChannel.createMessage(response(response[0]))
        }

        return Flux.fromIterable(REPEATER_TRIGGERS)
            .filter { message.content.lowercase(Locale.ROOT).contains(it) }
            .map { nextWords(message.content.lowercase(Locale.ROOT), it) }
            .filter { nextWord -> nextWord.length > 1 }
            .next()
            .map { nextWord -> "${nextWord.uppercase(Locale.ROOT)}$WHITESPACE$EXCLAMATION" }
            .flatMap { response -> message.restChannel.createMessage(response) }

    }

    fun nextWords(input: String, target: String): String {
        val index = input.indexOf(target)
        if (index == -1) return ""

        val start = index + target.length
        val remainder = input.substring(start).trimStart()

        val endIndex = remainder.indexOfFirst { it == '.' }
        return if (endIndex == -1) remainder else remainder.substring(0, endIndex)
    }

    fun response(repeat: String) = "${repeat.uppercase(Locale.ROOT)}$WHITESPACE$EXCLAMATION"
}