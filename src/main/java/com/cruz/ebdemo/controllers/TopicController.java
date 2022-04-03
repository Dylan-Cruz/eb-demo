package com.cruz.ebdemo.controllers;

import com.cruz.ebdemo.model.ApiResponse;
import com.cruz.ebdemo.model.Topic;
import com.cruz.ebdemo.repos.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/eb")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping("/topic/{id}")
    public Mono<ServerResponse> getTopic(@PathVariable String id) {
        Topic topic = topicRepository.findById(Long.parseLong(id)).orElse(null);
        if (topic != null) {
            return null;
        } else {
            return ServerResponse.status(HttpStatus.NOT_FOUND).body(BodyInserters.fromValue(new ApiResponse<Topic>("Topic with id " + id + " does not exist.")));
        }
    }
}
