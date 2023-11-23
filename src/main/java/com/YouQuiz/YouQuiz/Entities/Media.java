package com.YouQuiz.YouQuiz.Entities;
import com.YouQuiz.YouQuiz.Enum.MediaType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
    private MediaType media_type;
    //@OneToMany(mappedBy = "media", fetch = FetchType.EAGER)
     //@ManyToMany(fetch = FetchType.EAGER)
   // private List<Question> questions;
    @ManyToOne
    @JoinColumn(name="question_id")
    private Question question;
}
