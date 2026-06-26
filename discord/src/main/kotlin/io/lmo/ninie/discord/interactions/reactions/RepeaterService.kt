package io.lmo.ninie.discord.interactions.reactions

import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.MessageData
import io.lmo.ninie.data.constants.text.MagicStrings.EXCLAMATION
import io.lmo.ninie.data.constants.text.MagicStrings.WHITESPACE
import io.lmo.ninie.discord.interactions.NinieRespondable
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.Locale

@Service
class RepeaterService : NinieRespondable {

    companion object {
        private val REPEATER_TRIGGERS = listOf("dites", "dire", "dis", "dit")
    }

    override fun respondTo(message: Message): Mono<MessageData> {
        val content = message.content.lowercase(Locale.ROOT)

        val shortRepeat = content.split("di")
        if (shortRepeat.size > 1 && shortRepeat[1].length > 1
            && shortRepeat[1][0] != WHITESPACE && shortRepeat[1][1] != WHITESPACE
        ) {
            val word = shortRepeat[1].split(WHITESPACE)[0]
            if (word.isNotEmpty()) return message.restChannel.createMessage("${word.uppercase(Locale.ROOT)} $EXCLAMATION")
        }

        return Flux.fromIterable(REPEATER_TRIGGERS)
            .filter { content.contains(it) }
            .map { nextWords(content, it) }
            .filter { it.length > 1 }
            .next()
            .map { "${it.uppercase(Locale.ROOT)} $EXCLAMATION" }
            .flatMap { message.restChannel.createMessage(it) }
    }

    private fun nextWords(input: String, target: String): String {
        val index = input.indexOf(target)
        if (index == -1) return ""
        val remainder = input.substring(index + target.length).trimStart()
        val endIndex = remainder.indexOf('.')
        return if (endIndex == -1) remainder else remainder.substring(0, endIndex)
    }
}
