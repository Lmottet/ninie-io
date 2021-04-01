package com.lmo.ninie.io.events.message.commands

import discord4j.core.`object`.entity.channel.MessageChannel
import reactor.core.publisher.Mono

interface CommandListener {

    fun matches(command: Command): Boolean

    fun execute(command: Command, channel: Mono<MessageChannel>)

}