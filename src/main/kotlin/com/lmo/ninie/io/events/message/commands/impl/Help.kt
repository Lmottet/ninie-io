package com.lmo.ninie.io.events.message.commands.impl

import com.lmo.ninie.io.events.message.commands.Command
import com.lmo.ninie.io.events.message.commands.CommandListener
import discord4j.core.`object`.entity.channel.MessageChannel
import reactor.core.publisher.Mono

class Help : CommandListener {

    override fun matches(command: Command): Boolean {
        return command.action == "help" // todo expected action name should come from utility class / config
    }

    override fun execute(command: Command, channel: Mono<MessageChannel>) {
        channel.block()?.restChannel?.createMessage("Ninie.IO is Helping ! <3")
    }
}