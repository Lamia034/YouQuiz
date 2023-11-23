package com.YouQuiz.YouQuiz.Entities;

    
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @GeneratedValue
    private Long subject_id;
    @NonNull
    private String title;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
  //  @JsonIgnoreProperties("children")
    private Subject parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Subject> children;

    @OneToMany(mappedBy = "subject", fetch = FetchType.EAGER)
    private List<Question> questions;

//    @ManyToOne( fetch = FetchType.EAGER)
//    @JoinColumn(name = "parent_id")
//    @JsonIgnore
//    //@JsonBackReference
//    private Subject parent;
//
//    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
//    //@JsonManagedReference
//    private List<Subject> children;
//    @OneToMany(mappedBy = "subject", fetch = FetchType.EAGER)
//    private List<Question> questions;
}

