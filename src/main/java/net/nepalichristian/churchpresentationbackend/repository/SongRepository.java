package net.nepalichristian.churchpresentationbackend.repository;

import net.nepalichristian.churchpresentationbackend.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Integer>, JpaSpecificationExecutor<Song> {
    List<Song> findByTitleContaining(String title);
}
