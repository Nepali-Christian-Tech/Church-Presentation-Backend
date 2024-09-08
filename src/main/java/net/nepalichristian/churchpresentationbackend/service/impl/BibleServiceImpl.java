package net.nepalichristian.churchpresentationbackend.service.impl;

import net.nepalichristian.churchpresentationbackend.dto.BookResponse;
import net.nepalichristian.churchpresentationbackend.dto.Verse;
import net.nepalichristian.churchpresentationbackend.repository.BibleRepository;
import net.nepalichristian.churchpresentationbackend.entity.Bible;
import net.nepalichristian.churchpresentationbackend.service.BibleService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BibleServiceImpl implements BibleService {

  private final BibleRepository bibleRepository;

  public BibleServiceImpl(BibleRepository bibleRepository) {
    this.bibleRepository = bibleRepository;
  }

  @Override
  @Cacheable(value = "verses", key = "#book.concat('-').concat(#chapter)")
  public List<Bible> getVersesByBookAndChapter(int book, int chapter) {
    return bibleRepository.findByBookAndChapter(book, chapter);
  }

  @Override
  public List<BookResponse> getAllBooks() {
    return bibleRepository.getALLBooksInfo();
  }

  @Override
  public List<Verse> getVersesByBookAndChapter(Integer book, Integer chapter) {
    // Fetch verses for a specific book and chapter
    List<Bible> verses = bibleRepository.findByBookAndChapter(book, chapter);

    List<Verse> list = new ArrayList<>();
    for (Bible v : verses) {
      Verse build = Verse.builder().verseNumber(v.getVerse()).verseText(v.getScripture())
          .build();
      list.add(build);
    }
    return list;
  }

  @Override
  public Bible saveVerse(Bible bible) {
    return bibleRepository.save(bible);
  }

  @Override
  public void loadBibleFromXml(File xmlFile) {
    // Implement parsing and loading logic here
    xmlFile.delete();  // Cleanup after processing
  }

  @Override
  public void loadBibleFromXml(MultipartFile file) throws IOException {
    File tempFile = File.createTempFile("bible", ".xml");
    file.transferTo(tempFile);
    loadBibleFromXml(tempFile);
  }
}
