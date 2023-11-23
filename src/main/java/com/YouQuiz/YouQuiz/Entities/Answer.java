package com.YouQuiz.YouQuiz.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name="answer")
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
public class Answer {
    @Id
    @GeneratedValue
   // @Column(name = "answer_id")
    private Long answer_id;
    private String text;

    @OneToMany(mappedBy = "answer", fetch = FetchType.EAGER)     //immediate without req
    private List<Point> points;

}