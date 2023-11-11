package com.YouQuiz.YouQuiz.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name="level")
@NoArgsConstructor
@AllArgsConstructor
public class Level {
    @Id
    @GeneratedValue
    private Long level_id;
    @NonNull
    private String description;
    @NonNull
    private Integer maxPoints;
    @NonNull
    private Integer minPoints;
    @OneToMany(mappedBy = "level", fetch = FetchType.EAGER)
    private List<Question> questions;

}


/*
public enum Level {
    EASY("EASY", 0, 2),
    MEDIUM("MEDIUM", 3, 5),
    HARD("HARD", 6, 8);

    private final String description;
    private final int maxPoints;
    private final int minPoints;

    Level(String description, int maxPoints, int minPoints) {
        this.description = description;
         this.maxPoints = maxPoints;
        this.minPoints = minPoints;
    }

  
}*/

