package net.nepalichristian.churchpresentationbackend.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Verse {
  Integer verseNumber;
  String verseText;
}
