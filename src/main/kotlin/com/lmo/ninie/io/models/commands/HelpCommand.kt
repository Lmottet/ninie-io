package com.lmo.ninie.io.models.commands

import com.lmo.ninie.io.models.commands.CommandDescription
import discord4j.core.`object`.entity.channel.MessageChannel
import reactor.core.publisher.Mono

data class HelpCommand(override val action: String, override val channel: Mono<MessageChannel>) : CommandDescription()