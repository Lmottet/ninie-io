package io.lmo.ninie.discord.interactions.reactions

import discord4j.core.`object`.entity.Message
import discord4j.discordjson.json.MessageData
import io.lmo.ninie.data.constants.text.MagicStrings.EXCLAMATION
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.Locale

@Service
@Order(3)
class RepeaterService : CreationReactionService {

    companion object {
        private val CONJUGATED_FORMS = setOf("dis", "dit", "dites", "dire")
    }

    override fun respondTo(message: Message): Mono<MessageData> {
        val words = message.content.lowercase(Locale.ROOT)
            .split(' ')
            .filter { it.isNotEmpty() }

        // "dis bonjour" / "dites qu'il fait beau" → repeat next word(s)
        val conjugatedIndex = words.indexOfFirst { it in CONJUGATED_FORMS }
        if (conjugatedIndex != -1 && conjugatedIndex < words.lastIndex) {
            val toRepeat = words.subList(conjugatedIndex + 1, words.size)
                .joinToString(" ")
                .substringBefore('.')
                .trim()
            if (toRepeat.length > 1)
                return message.restChannel.createMessage("${toRepeat.uppercase(Locale.ROOT)} $EXCLAMATION")
        }

        // "dinosaure" → "di" sounds like the imperative → repeat the suffix: "NOSAURE !"
        val diWord = words.firstOrNull { it.startsWith("di") && it !in CONJUGATED_FORMS && it.length > 2 }
        if (diWord != null)
            return message.restChannel.createMessage("${diWord.removePrefix("di").uppercase(Locale.ROOT)} $EXCLAMATION")

        return Mono.empty()
    }
}
