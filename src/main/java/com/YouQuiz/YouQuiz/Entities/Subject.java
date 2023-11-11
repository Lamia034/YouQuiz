package com.YouQuiz.YouQuiz.Entities;

    
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity

@Table(name="subject")
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subject_id;
    @NonNull
    private String title;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private Subject parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    private List<Subject> children;
    @OneToMany(mappedBy = "subject", fetch = FetchType.EAGER)
    private List<Question> questions;
}

