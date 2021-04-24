package com.lmo.ninie.io.services.commands

import com.lmo.ninie.io.commands.Alias
import com.lmo.ninie.io.commands.CommandBase
import discord4j.discordjson.json.MessageData
import io.vavr.control.Option

interface AliasService {

    fun all(): List<Alias>

    fun find(alias: String?): Option<Alias>

    fun mapToCommand(alias: Alias): CommandBase<MessageData>
}