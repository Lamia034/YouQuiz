package com.YouQuiz.YouQuiz.Service.Impl;

import com.YouQuiz.YouQuiz.DTOs.MediaDto;
import com.YouQuiz.YouQuiz.DTOs.MediaDto;
import com.YouQuiz.YouQuiz.DTOs.MediaResponseDto;
import com.YouQuiz.YouQuiz.DTOs.MediaResponseDto;

import com.YouQuiz.YouQuiz.Entities.Media;
import com.YouQuiz.YouQuiz.Entities.Media;
import com.YouQuiz.YouQuiz.Entities.Question;
import com.YouQuiz.YouQuiz.Repositories.AnswerRepository;
import com.YouQuiz.YouQuiz.Repositories.MediaRepository;
import com.YouQuiz.YouQuiz.Repositories.QuestionRepository;
import com.YouQuiz.YouQuiz.Service.MediaService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class MediaServiceImpl implements MediaService {
    private final MediaRepository mediaRepository;
    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;

    public MediaServiceImpl(MediaRepository mediaRepository, ModelMapper modelMapper, QuestionRepository questionRepository) {
        this.mediaRepository = mediaRepository;
        this.modelMapper = modelMapper;
        this.questionRepository = questionRepository;
    }

    @Override
    @Transactional
    public MediaDto createMedia(MediaDto mediaDto) {
        try {
            Media media = modelMapper.map(mediaDto, Media.class);
            Media savedMedia = mediaRepository.save(media);
            return modelMapper.map(savedMedia, MediaDto.class);
        } catch (Exception e) {

            throw new RuntimeException("Failed to create media: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<MediaResponseDto> getAllMedias() {
        List<Media> medias = mediaRepository.findAll();
        return medias.stream()
                .map(media -> modelMapper.map(media, MediaResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean deleteMedia(Long mediaId) {
        Optional<Media> optionalMedia = mediaRepository.findById(mediaId);
        if (optionalMedia.isPresent()) {
            mediaRepository.delete(optionalMedia.get());
            return true;
        } else {
            throw new RuntimeException("Media not found");
        }
    }

    @Override
    @Transactional
    public MediaResponseDto updateMedia(Long mediaId, MediaDto updatedMediaDto) {
        Optional<Media> optionalMedia = mediaRepository.findById(mediaId);
        if (optionalMedia.isPresent()) {
            Media media = optionalMedia.get();
            if (updatedMediaDto.getTitle() != null) {
                media.setTitle(updatedMediaDto.getTitle());
            }
            if (updatedMediaDto.getMedia_type() != null) {
                media.setMedia_type(updatedMediaDto.getMedia_type());
            }
            if (updatedMediaDto.getQuestion_id() != null) {
                Long questionId = updatedMediaDto.getQuestion_id();
                Question question = questionRepository.findById(questionId).orElseThrow(() -> new RuntimeException("Question not found with ID: " + questionId));
                media.setQuestion(question);
            }
            Media savedMedia = mediaRepository.save(media);
            return modelMapper.map(savedMedia, MediaResponseDto.class);
        } else {
            throw new RuntimeException("Media not found");
        }
    }

//    @Transactional
//    public List<MediaResponseDto> getAllMedias() {
//        List<Media> medias = mediaRepository.findAll();
//        return medias.stream()
//                .map(media -> modelMapper.map(media, MediaResponseDto.class))
//                .collect(Collectors.toList());
//    }
//
//    @Transactional
//    public MediaDto createMedia(MediaDto mediaDto) {
//        Media media = modelMapper.map(mediaDto, Media.class);
//        Media savedMedia = mediaRepository.save(media);
//        return modelMapper.map(savedMedia, MediaDto.class);
//    }
//
//
//
//    @Transactional
//    public boolean deleteMedia(Long mediaId) {
//        Optional<Media> optionalMedia = mediaRepository.findById(mediaId);
//
//        if (optionalMedia.isPresent()) {
//            mediaRepository.delete(optionalMedia.get());
//            return true;
//        } else {
//            return false;
//        }
//    }

//    @Transactional
//    public MediaResponseDto updateMedia(Long mediaId, MediaDto updatedMediaDto) {
//        Optional<Media> optionalMedia = mediaRepository.findById(mediaId);
//        if (optionalMedia.isPresent()) {
//            Media media = optionalMedia.get();
//            media.setText(updatedMediaDto.getText());
//            Media savedMedia = mediaRepository.save(media);
//            return modelMapper.map(savedMedia, MediaResponseDto.class);
//        }
//        return null; // Media not found
//    }
}