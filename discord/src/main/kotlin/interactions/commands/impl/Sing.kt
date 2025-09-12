package com.lmo.ninie.io.discord.interactions.commands.impl

import com.lmo.ninie.io.data.dao.SongDao
import com.lmo.ninie.io.discord.eventmessage.extractArg
import com.lmo.ninie.io.discord.interactions.commands.MessageCommandBase
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component

@Component
class Sing(val songDao: SongDao) : MessageCommandBase {

    override fun response(message: Message): String {
        val song = songDao.find((message.extractArg(1) ?: ""))
        return (song ?: songDao.any()).content
    }
}