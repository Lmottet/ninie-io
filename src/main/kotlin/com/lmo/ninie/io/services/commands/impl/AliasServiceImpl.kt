package com.lmo.ninie.io.services.commands.impl

import com.lmo.ninie.io.commands.Alias
import com.lmo.ninie.io.services.commands.AliasService
import io.vavr.control.Option
import io.vavr.kotlin.option
import org.springframework.stereotype.Service

@Service
class AliasServiceImpl : AliasService {

    override fun find(alias: String?) = all()
        .find { e -> e.defaultAlias == alias }
        .option()

    fun all(): List<Alias> = Alias::class.nestedClasses.map { it.objectInstance as Alias }

}