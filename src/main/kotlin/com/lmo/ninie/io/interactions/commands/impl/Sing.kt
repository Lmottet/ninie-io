package com.lmo.ninie.io.interactions.commands.impl

import com.lmo.ninie.io.interactions.commands.MessageCommandBase
import com.lmo.ninie.io.extensions.eventmessage.extractArg
import com.lmo.ninie.io.dao.SongDao
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component

@Component
class Sing(val songDao: SongDao) : MessageCommandBase {

    override fun response(message: Message): String {
        val song = songDao.find((message.extractArg(1) ?: ""))
        return (song ?: songDao.any()).content
    }
}