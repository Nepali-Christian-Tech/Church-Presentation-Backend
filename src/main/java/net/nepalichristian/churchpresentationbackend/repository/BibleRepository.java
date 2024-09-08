package net.nepalichristian.churchpresentationbackend.repository;

import net.nepalichristian.churchpresentationbackend.dto.BookResponse;
import net.nepalichristian.churchpresentationbackend.entity.Bible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BibleRepository extends JpaRepository<Bible, Long> {
  List<Bible> findByBookAndChapter(int book, int chapter);

  @Query("SELECT new net.nepalichristian.churchpresentationbackend.dto.BookResponse(b.book, b.testament, b.bookNepali, b.bookEnglish, b.bookShort, COUNT(DISTINCT b.chapter))"
      + " FROM Bible b GROUP BY b.book, b.testament, b.bookNepali, b.bookEnglish, b.bookShort ORDER BY b.book")
  List<BookResponse> getALLBooksInfo();


}