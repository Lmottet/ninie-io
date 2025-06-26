package com.lmo.ninie.io.dao.impl

import com.lmo.ninie.io.models.songs.Song
import com.lmo.ninie.io.repositories.SongRepository
import com.lmo.ninie.io.dao.SongDao
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class SongDaoImpl(
    val songRepository: SongRepository
) : SongDao {

    override fun find(name: String): Song? = songRepository.find(name)

    override fun any(): Song = songRepository.any()

    override fun all(): List<Song> = songRepository
        .all()
        .stream()
        .collect(Collectors.toList())
}