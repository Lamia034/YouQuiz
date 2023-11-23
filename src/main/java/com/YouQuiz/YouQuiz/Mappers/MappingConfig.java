package com.YouQuiz.YouQuiz.Mappers;

import com.YouQuiz.YouQuiz.Entities.Answer;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}