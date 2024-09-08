package net.nepalichristian.churchpresentationbackend.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Chapter {
  private Integer chapterNumber;
  private List<Verse> verses;
}
