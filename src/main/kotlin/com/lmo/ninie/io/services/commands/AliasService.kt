package com.lmo.ninie.io.services.commands

import com.lmo.ninie.io.commands.Alias
import io.vavr.control.Option

interface AliasService {

    fun find(alias: String?): Option<Alias>
}