package com.YouQuiz.YouQuiz.Entities;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;

@Data
@Entity

@Table(name="timing")
@NoArgsConstructor
@AllArgsConstructor
public class Timing {

    @Id
    @GeneratedValue
    private Long timing_id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

  //  private Time timing;
  private Integer timing;

    private String timingUnit;

}
