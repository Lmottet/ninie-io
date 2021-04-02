package com.lmo.ninie.io.commands.impl

import com.lmo.ninie.io.commands.CommandListener
import com.lmo.ninie.io.commands.impl.CommandNames.HELP
import com.lmo.ninie.io.models.commands.Command
import discord4j.core.`object`.entity.Message
import discord4j.core.`object`.entity.channel.MessageChannel
import reactor.core.publisher.Mono

class Help : CommandListener {

    override fun matches(command: Command): Boolean = command.action == HELP

    override fun execute(command: Command): Mono<Message> =
            command.channel
                    .flatMap { chan -> sendMessages(chan)


                    }

    fun sendMessages(messageChannel : MessageChannel): Mono<Message>{
        messageChannel
                .createMessage("Ninie.IO is Helping ! :heart:")

       return messageChannel.createMessage("help command")

    }

}