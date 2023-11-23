package com.YouQuiz.YouQuiz.Controller;

import com.YouQuiz.YouQuiz.DTOs.MediaDto;
import com.YouQuiz.YouQuiz.DTOs.MediaDto;
import com.YouQuiz.YouQuiz.DTOs.MediaResponseDto;
import com.YouQuiz.YouQuiz.DTOs.MediaResponseDto;
import com.YouQuiz.YouQuiz.Service.MediaService;
import com.YouQuiz.YouQuiz.Service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/medias")
public class MediaController {

        private final MediaService mediaService;


        @Autowired
        public MediaController(MediaService mediaService) {
            this.mediaService = mediaService;

        }

    @PostMapping
    public ResponseEntity<Object> createMedia(@RequestBody MediaDto mediaDto) {
        try {
            MediaDto createdMedia = mediaService.createMedia(mediaDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdMedia);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create media: " + e.getMessage());
        }
    }

    @GetMapping
    public List<MediaResponseDto> getAllMedias() {
        return mediaService.getAllMedias();
    }

    @DeleteMapping("/{mediaId}")
    public ResponseEntity<String> deleteMedia(@PathVariable Long mediaId) {
        try {
            boolean deleted = mediaService.deleteMedia(mediaId);
            if (deleted) {
                return ResponseEntity.ok("Media deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Media not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete media: " + e.getMessage());
        }
    }

    @PutMapping("/{mediaId}")
    public ResponseEntity<Object> updateMedia(@PathVariable Long mediaId, @RequestBody MediaDto updatedMediaDto) {
        try {
            MediaResponseDto updatedMedia = mediaService.updateMedia(mediaId, updatedMediaDto);
            return ResponseEntity.ok(updatedMedia);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update media: " + e.getMessage());
        }
    }
//    @PostMapping
//    public MediaDto createMedia(@RequestBody MediaDto mediaDto) {
//        return mediaService.createMedia(mediaDto);
//    }
//
//        @GetMapping
//        public List<MediaResponseDto> getAllMedias() {
//            return mediaService.getAllMedias();
//        }
//
//        @DeleteMapping("/{mediaId}")
//        public ResponseEntity<String> deleteMedia(@PathVariable Long mediaId) {
//            boolean deleted = mediaService.deleteMedia(mediaId);
//
//            if (deleted) {
//                return new ResponseEntity<>("Media deleted successfully", HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>("Media not found", HttpStatus.NOT_FOUND);
//            }
//        }
//        @PutMapping("/{mediaId}")
//        public MediaResponseDto updateMedia(@PathVariable Long mediaId, @RequestBody MediaDto updatedMedia) {
//            return mediaService.updateMedia(mediaId, updatedMedia);
//        }
    }
