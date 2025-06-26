package com.lmo.ninie.io.interactions.commands.impl

import com.lmo.ninie.io.interactions.commands.MessageCommandBase
import com.lmo.ninie.io.extensions.eventmessage.extractArg
import com.lmo.ninie.io.dao.SongDao
import discord4j.core.`object`.entity.Message
import org.springframework.stereotype.Component
import java.util.Optional
import kotlin.jvm.optionals.getOrElse

@Component
class Sing(val songDao: SongDao) : MessageCommandBase {

    override fun response(message: Message): String {
        return Optional.of(message.extractArg(1) ?: "")
            .flatMap { songName -> songDao.find(songName) }
            .getOrElse { songDao.any() }
            .content
    }
}