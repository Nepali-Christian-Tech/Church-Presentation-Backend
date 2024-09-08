package net.nepalichristian.churchpresentationbackend.controller;

import net.nepalichristian.churchpresentationbackend.dto.BookResponse;
import net.nepalichristian.churchpresentationbackend.dto.Verse;
import net.nepalichristian.churchpresentationbackend.entity.Bible;
import net.nepalichristian.churchpresentationbackend.service.BibleService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/bible")
public class BibleController {

  private final BibleService bibleService;

  public BibleController(BibleService bibleService) {
    this.bibleService = bibleService;
  }

  @GetMapping("/{book}/{chapter}")
  public List<Bible> getVerses(@PathVariable int book, @PathVariable int chapter) {
    return bibleService.getVersesByBookAndChapter(book, chapter);
  }

  @GetMapping("/book-info")
  public List<BookResponse> getBookInfo(){
    return bibleService.getAllBooks();
  }

  // Get verses for a specific book and chapter
  @GetMapping("/verses/{book}/{chapter}")
  public List<Verse> getBibleVersesByBookAndChapter(@PathVariable Integer book, @PathVariable Integer chapter) {
    return bibleService.getVersesByBookAndChapter(book, chapter);
  }

  @PostMapping("/upload")
  public String uploadBible(@RequestParam("file") MultipartFile file) {
    try {
      bibleService.loadBibleFromXml(file);
      return "Bible uploaded successfully!";
    } catch (IOException e) {
      return "Failed to upload Bible: " + e.getMessage();
    }
  }
}
