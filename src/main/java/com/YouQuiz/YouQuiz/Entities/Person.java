package com.YouQuiz.YouQuiz.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
//@RequiredArgsConstructor
@NoArgsConstructor
//@Entity
@MappedSuperclass
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person implements Serializable {
//    @Id
//    @GeneratedValue
//    private Long person_id;


    private String name;

    private String prenoun;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String address;

}
