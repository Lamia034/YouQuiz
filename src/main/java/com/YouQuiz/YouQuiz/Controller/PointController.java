package com.YouQuiz.YouQuiz.Controller;

import com.YouQuiz.YouQuiz.DTOs.*;
import com.YouQuiz.YouQuiz.Service.PointService;
import com.YouQuiz.YouQuiz.Service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/points")
public class PointController {
    private final PointService pointService;


    @Autowired
    public PointController(PointService pointService) {
        this.pointService = pointService;

    }

    @PostMapping
    public ResponseEntity<Object> createPoint(@RequestBody PointDto pointDto) {
        try {
            PointDto createdPoint = pointService.createPoint(pointDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPoint);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create point: " + e.getMessage());
        }
    }

    @GetMapping
    public List<PointResponseDto> getAllPoints() {
        return pointService.getAllPoints();
    }

    @DeleteMapping("/{pointId}")
    public ResponseEntity<String> deletePoint(@PathVariable Long pointId) {
        try {
            boolean deleted = pointService.deletePoint(pointId);
            if (deleted) {
                return ResponseEntity.ok("Point deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Point not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete point: " + e.getMessage());
        }
    }

    @PutMapping("/{pointId}")
    public ResponseEntity<Object> updatePoint(@PathVariable Long pointId, @RequestBody PointDto updatedPointDto) {
        try {
            PointResponseDto updatedPoint = pointService.updatePoint(pointId, updatedPointDto);
            return ResponseEntity.ok(updatedPoint);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update point: " + e.getMessage());
        }
    }

}
