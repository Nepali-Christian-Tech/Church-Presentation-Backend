package net.nepalichristian.churchpresentationbackend.service;

import net.nepalichristian.churchpresentationbackend.dto.BookResponse;
import net.nepalichristian.churchpresentationbackend.dto.SongDTO;
import net.nepalichristian.churchpresentationbackend.dto.Verse;
import net.nepalichristian.churchpresentationbackend.entity.Bible;
import net.nepalichristian.churchpresentationbackend.entity.Song;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface SongService {
  List<SongDTO> getAllSongs();
  SongDTO createSong(SongDTO songDTO);
  List<SongDTO> searchSongsByTitle(String title);
  List<SongDTO> advancedSearch(String title, String songCode, String lyrics);
}
