package com.YouQuiz.YouQuiz.Entities;

import com.YouQuiz.YouQuiz.Enum.MediaType;
import com.YouQuiz.YouQuiz.Enum.QuestionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Entity

@Table(name="question")
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue
    private Long question_id;
    private String text;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="subject_id")
    private Subject subject;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="level_id")
    private Level level;

    @Enumerated(EnumType.STRING)
    private QuestionType question_type;
    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    private List<Point> points;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
 //   @ManyToMany(fetch = FetchType.EAGER)
    private List<Media> medias;
    @ManyToMany(fetch = FetchType.EAGER)
            //(mappedBy = "questions")
    private List<Quiz> quizs;
}
