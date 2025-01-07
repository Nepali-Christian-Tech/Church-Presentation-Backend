package net.nepalichristian.churchpresentationbackend.specification;

import net.nepalichristian.churchpresentationbackend.entity.Song;
import org.springframework.data.jpa.domain.Specification;


public class SongSpecification {
    public static Specification<Song> titleContains(String title) {
        return (root, query, criteriaBuilder) -> {
            if (title == null || title.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("title"), "%" + title + "%");
        };
    }

    public static Specification<Song> songCodeContains(String songCode) {
        return (root, query, criteriaBuilder) -> {
            if (songCode == null || songCode.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("songCode"), "%" + songCode + "%");
        };
    }

    public static Specification<Song> lyricsContains(String lyrics) {
        return (root, query, criteriaBuilder) -> {
            if (lyrics == null || lyrics.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("lyrics"), "%" + lyrics + "%");
        };
    }
} 