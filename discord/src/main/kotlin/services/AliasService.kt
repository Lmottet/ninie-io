package com.lmo.ninie.io.discord.services

import com.lmo.ninie.io.discord.interactions.commands.Alias
import com.lmo.ninie.io.discord.interactions.commands.CommandBase

interface AliasService {

    fun all(): List<Alias>

    fun find(alias: String?): Alias?

    fun mapToCommand(alias: Alias): CommandBase
}