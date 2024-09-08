package net.nepalichristian.churchpresentationbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bible", schema = "public")
public class Bible {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "book")
  private Integer book;

  @Column(name = "chapter")
  private Integer chapter;

  @Column(name = "verse")
  private Integer verse;

  @Column(name = "scripture")
  private String scripture;

  @Column(name = "testament")
  private String testament;

  @Column(name = "book_short")
  private String bookShort;

  @Column(name = "book_nepali")
  private String bookNepali;

  @Column(name = "book_english")
  private String bookEnglish;

  @Column(name = "version")
  private Integer version;

  @Column(name = "istitle")
  private Integer isTitle;

}
