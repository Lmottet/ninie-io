package com.lmo.ninie.io.services

import com.lmo.ninie.io.commands.Command
import io.vavr.control.Option

interface AliasService {

    fun find(alias: String?): Option<Command>
}