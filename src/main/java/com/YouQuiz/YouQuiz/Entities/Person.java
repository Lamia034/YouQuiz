package com.YouQuiz.YouQuiz.Entities;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Person implements Serializable {
    @NonNull
    private String name;
    @NonNull
    private String prenoun;
    @NonNull
    private LocalDate birthDate;
    @NonNull
    private String address;

}
