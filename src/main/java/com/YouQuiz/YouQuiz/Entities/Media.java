package com.YouQuiz.YouQuiz.Entities;
import com.YouQuiz.YouQuiz.Enum.MediaType;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="media")
@NoArgsConstructor
@AllArgsConstructor
public class Media {
    @Id
    @GeneratedValue
    private Long media_id;
    private String title;

    @Enumerated(EnumType.STRING)
    private MediaType type;
    @ManyToOne
    @JoinColumn(name="question_id")
    private Question question;
}
