package com.cruz.ebdemo.controllers;

import com.cruz.ebdemo.model.ApiResponse;
import com.cruz.ebdemo.model.Topic;
import com.cruz.ebdemo.repos.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/eb")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping("/topic/{id}")
    public ResponseEntity<Mono<ApiResponse<Topic>>> getTopic(@PathVariable String id) {
        try {
            Topic topic = topicRepository.findById(Integer.parseInt(id)).orElse(null);
            if (topic != null) {
                return ResponseEntity.status(HttpStatus.OK).body(Mono.just(new ApiResponse<>(topic)));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Mono.just(new ApiResponse<>("topic " + id + " not in database")));
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Mono.just(new ApiResponse<>("An unknown internal server error occurred")));
        }
    }

    @GetMapping("/class/{className}")
    public ResponseEntity<Mono<ApiResponse<List<Integer>>>> getTopicsByClass(@PathVariable String className) {
        try {
            List<Integer> topicIds = topicRepository.findByUrlClass(className)
                    .stream()
                    .map(Topic::getTopicId)
                    .collect(Collectors.toList());

            return ResponseEntity.ok().body(Mono.just(new ApiResponse<>(topicIds)));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Mono.just(new ApiResponse<>("An unknown internal server error occurred")));
        }
    }

    @GetMapping("/all/topic")
    public ResponseEntity<Mono<ApiResponse<List<Topic>>>> getTopicsByClass() {
        try {
            List<Topic> topics = topicRepository.findAll();
            return ResponseEntity.ok().body(Mono.just(new ApiResponse<>(topics)));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Mono.just(new ApiResponse<>("An unknown internal server error occurred")));
        }
    }
}
