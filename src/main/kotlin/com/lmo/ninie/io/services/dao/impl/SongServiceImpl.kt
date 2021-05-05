package com.lmo.ninie.io.services.dao.impl

import com.lmo.ninie.io.models.songs.*
import com.lmo.ninie.io.services.dao.SongService
import io.vavr.control.Option
import io.vavr.kotlin.option
import org.springframework.stereotype.Service
import com.lmo.ninie.io.repositories.SongRepository
import java.util.stream.Collectors

@Service
class SongServiceImpl(
    val songRepository: SongRepository
) : SongService {

    override fun find(name: String): Option<Song> = songRepository.all()
        .find { song -> song.name.equals(name, ignoreCase = true) }
        .option()

    override fun any(): Song = songRepository.all().get(3)

    override fun all(): List<Song> = songRepository
        .all()
        .stream()
        .collect(Collectors.toList())
}