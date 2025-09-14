package io.lmo.ninie.discord.interactions.commands.impl

import io.lmo.ninie.discord.eventmessage.extractArg
import io.lmo.ninie.discord.interactions.commands.MessageCommandBase
import discord4j.core.`object`.entity.Message
import io.lmo.ninie.data.dao.SongDao
import org.springframework.stereotype.Component

@Component
class Sing(val songDao: SongDao) : MessageCommandBase {

    override fun response(message: Message): String {
        val song = songDao.find((message.extractArg(1) ?: ""))
        return (song ?: songDao.any()).content
    }
}