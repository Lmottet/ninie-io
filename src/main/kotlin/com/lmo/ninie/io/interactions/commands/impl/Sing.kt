package com.lmo.ninie.io.interactions.commands.impl

import com.lmo.ninie.io.interactions.commands.MessageCommandBase
import com.lmo.ninie.io.extensions.eventmessage.extractArg
import com.lmo.ninie.io.services.dao.SongService
import discord4j.core.`object`.entity.Message
import io.vavr.kotlin.option
import org.springframework.stereotype.Component

@Component
class Sing(val songService: SongService) : MessageCommandBase {

    override fun response(message: Message) = message.extractArg(1)
        .option()
        .flatMap { songName -> songService.find(songName) }
        .getOrElse(songService.any())
        .content
}