package net.nepalichristian.churchpresentationbackend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import net.nepalichristian.churchpresentationbackend.entity.Song;

@Getter
@Setter
@Builder
public class SongDTO {
    private Integer id;
    private String songCode;
    private String title;
    private String url;
    private String lyrics;

    public static SongDTO toDto(Song song) {
        return SongDTO.builder()
                .id(song.getId())
                .songCode(song.getSongCode())
                .title(song.getTitle())
                .url(song.getUrl())
                .lyrics(song.getLyrics())
                .build();
    }

    public static Song toEntity(SongDTO songDTO) {
        return Song.builder()
                .id(songDTO.getId())
                .songCode(songDTO.getSongCode())
                .title(songDTO.getTitle())
                .url(songDTO.getUrl())
                .lyrics(songDTO.getLyrics())
                .build();
    }

}
