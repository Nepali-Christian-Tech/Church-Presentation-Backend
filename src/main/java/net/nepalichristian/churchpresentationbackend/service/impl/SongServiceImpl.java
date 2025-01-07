package net.nepalichristian.churchpresentationbackend.service.impl;// src/main/java/com/example/service/SongService.java

import net.nepalichristian.churchpresentationbackend.dto.SongDTO;
import net.nepalichristian.churchpresentationbackend.entity.Song;
import net.nepalichristian.churchpresentationbackend.repository.SongRepository;
import net.nepalichristian.churchpresentationbackend.service.SongService;
import net.nepalichristian.churchpresentationbackend.specification.SongSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
  @Autowired
  private SongRepository songRepository;

  @Override
  @Cacheable(value = "songs")
  public List<SongDTO> getAllSongs() {
    return songRepository.findAll().stream().map(SongDTO::toDto).toList();
  }

  @Override
  public SongDTO createSong(SongDTO songDTO) {
    Song song = new Song();
    // Map fields from DTO to entity
    return SongDTO.toDto(songRepository.save(song));
  }

  @Override
  public List<SongDTO> searchSongsByTitle(String title) {
    return songRepository.findByTitleContaining(title).stream().map(SongDTO::toDto).toList();
  }

  @Override
  @Cacheable(value = "songs", key = "#title + '_' + #songCode + '_' + #lyrics")
  public List<SongDTO> advancedSearch(String title, String songCode, String lyrics) {
    Specification<Song> spec = Specification.where(SongSpecification.titleContains(title))
            .and(SongSpecification.songCodeContains(songCode))
            .and(SongSpecification.lyricsContains(lyrics));
    
    return songRepository.findAll(spec).stream().map(SongDTO::toDto).toList();
  }

}