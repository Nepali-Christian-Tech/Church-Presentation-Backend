package net.nepalichristian.churchpresentationbackend.service;

import net.nepalichristian.churchpresentationbackend.dto.BookResponse;
import net.nepalichristian.churchpresentationbackend.dto.Verse;
import net.nepalichristian.churchpresentationbackend.entity.Bible;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface BibleService {
  List<Bible> getVersesByBookAndChapter(int book, int chapter);

  List<BookResponse> getAllBooks();

  public List<Verse> getVersesByBookAndChapter(Integer book, Integer chapter);

  Bible saveVerse(Bible bibleVerse);

  void loadBibleFromXml(File xmlFile);

  void loadBibleFromXml(MultipartFile file) throws IOException;
}
