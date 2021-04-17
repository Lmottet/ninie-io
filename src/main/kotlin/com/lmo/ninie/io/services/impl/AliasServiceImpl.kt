package com.lmo.ninie.io.services.impl

import com.lmo.ninie.io.commands.Command
import com.lmo.ninie.io.extensions.eventmessage.extractCommandAlias
import com.lmo.ninie.io.services.AliasService
import discord4j.core.`object`.entity.Message
import io.vavr.kotlin.option
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class AliasServiceImpl : AliasService {

    override fun find(alias: String?) = Command.find(alias + "")

}