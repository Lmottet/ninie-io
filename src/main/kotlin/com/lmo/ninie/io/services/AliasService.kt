package com.lmo.ninie.io.services

import com.lmo.ninie.io.interactions.commands.Alias
import com.lmo.ninie.io.interactions.commands.CommandBase
import discord4j.discordjson.json.MessageData

interface AliasService {

    fun all(): List<Alias>

    fun find(alias: String?): Alias?

    fun mapToCommand(alias: Alias): CommandBase<MessageData>
}