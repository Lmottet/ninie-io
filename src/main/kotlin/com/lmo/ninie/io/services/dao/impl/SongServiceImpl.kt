package com.lmo.ninie.io.services.dao.impl

import com.lmo.ninie.io.models.songs.Song
import com.lmo.ninie.io.repositories.SongRepository
import com.lmo.ninie.io.services.dao.SongService
import io.vavr.control.Option
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class SongServiceImpl(
    val songRepository: SongRepository
) : SongService {

    override fun find(name: String): Option<Song> = songRepository.find(name)

    override fun any(): Song = songRepository.any()

    override fun all(): List<Song> = songRepository
        .all()
        .stream()
        .collect(Collectors.toList())
}