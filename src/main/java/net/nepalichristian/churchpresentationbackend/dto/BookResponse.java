package net.nepalichristian.churchpresentationbackend.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookResponse {
  private Integer bookId;
  private String testament;
  private String bookNepali;
  private String bookEnglish;
  private String bookShort;
  private Long chapter;
}
