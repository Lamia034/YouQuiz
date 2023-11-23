package com.YouQuiz.YouQuiz.Service;

import com.YouQuiz.YouQuiz.DTOs.AnswerDto;
import com.YouQuiz.YouQuiz.DTOs.AnswerResponseDto;
import com.YouQuiz.YouQuiz.DTOs.MediaDto;
import com.YouQuiz.YouQuiz.DTOs.MediaResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MediaService {
    List<MediaResponseDto> getAllMedias();
    MediaDto createMedia(MediaDto mediaDto );
    boolean deleteMedia(Long mediaId);
    MediaResponseDto updateMedia(Long mediaId, MediaDto updatedMedia);
}
