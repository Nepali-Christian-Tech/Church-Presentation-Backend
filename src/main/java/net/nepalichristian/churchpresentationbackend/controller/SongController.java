package net.nepalichristian.churchpresentationbackend.controller;

import net.nepalichristian.churchpresentationbackend.dto.SongDTO;
import net.nepalichristian.churchpresentationbackend.entity.Song;
import net.nepalichristian.churchpresentationbackend.service.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public List<SongDTO> getAllSongs() {
        return songService.getAllSongs();
    }

    @PostMapping
    public SongDTO createSong(@RequestBody SongDTO songDTO) {
        return songService.createSong(songDTO);
    }

    @GetMapping("/search")
    public List<SongDTO> searchSongsByTitle(@RequestParam String title) {
        return songService.searchSongsByTitle(title);
    }

    @GetMapping("/search/advanced")
    public List<SongDTO> advancedSearch(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String songCode,
            @RequestParam(required = false) String lyrics) {
        return songService.advancedSearch(title, songCode, lyrics);
    }
}