package net.nepalichristian.churchpresentationbackend.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Book {
  private Integer bookNumber;
  private String name;
  private String shortName;
  private String nepaliName;
  private String testament;
  private List<Chapter> chapterList;
}
