package com.cruz.ebdemo.controllers;

import com.cruz.ebdemo.model.ApiResponse;
import com.cruz.ebdemo.model.Topic;
import com.cruz.ebdemo.repos.TopicRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TopicControllerTests {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private TopicRepository mockTopicRepository;

    // test getTopicById returns a 404 as expected when id not found
    @Test
    public void whenIdIsNotPresentReturn404AsExpected() {
        Optional<Topic> optional = Optional.empty();
        when(mockTopicRepository.findById(1)).thenReturn(optional);

        webTestClient.get()
                .uri("/eb/topic/1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isNotFound()
                .expectBody(ApiResponse.class)
                .value(resp -> resp.getData(), equalTo(null))
                .value(resp -> resp.getError(), equalTo("topic 1 not in database"));
    }

    // test getTopicById returns a 200 and a complete entity when id is present
    @Test
    public void whenIdIsPresentReturnTopicAsExpected() {
        Topic topic = new Topic(1, "testTitle", "testClass");
        ApiResponse<Topic> expectedResponse = new ApiResponse<>(new Topic(1, "testTitle", "testClass"));
        when(mockTopicRepository.findById(1)).thenReturn(Optional.of(topic));

        webTestClient.get()
                .uri("/eb/topic/1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<ApiResponse<Topic>>() {})
                .isEqualTo(expectedResponse);
    }

    // test getTopicById returns a 500 when user passes a string
    @Test
    public void whenErrorOccursReturns500() {
        webTestClient.get()
                .uri("/eb/topic/abc")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().is5xxServerError()
                .expectBody(ApiResponse.class)
                .value(resp -> resp.getError(), equalTo("An unknown internal server error occurred"));
    }

    // test getTopicsByClassName returns a list of topics
    @Test
    public void givenClassNameIsValidReturns200AsExpected() {
        List<Topic> topics = new ArrayList<>();
        topics.add(new Topic(1, "Dog", "animal"));
        topics.add(new Topic(2, "Cat", "animal"));

        when(mockTopicRepository.findByUrlClass("animal")).thenReturn(topics);

        webTestClient.get()
                .uri("/eb/class/animal")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<ApiResponse<List<Integer>>>() {})
                .value(resp -> resp.getData(), contains(1, 2));
    }

    // test getAllTopics returns a list of topics
    @Test
    public void allTopicsRequestReturns200AsExpected() {
        List<Topic> topics = new ArrayList<>();
        topics.add(new Topic(1, "Dog", "animal"));
        topics.add(new Topic(2, "Cat", "animal"));

        when(mockTopicRepository.findAll()).thenReturn(topics);

        webTestClient.get()
                .uri("/eb/all/topic")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<ApiResponse<List<Topic>>>() {})
                .value(resp -> resp.getData(), equalTo(topics));
    }

    // when an unknown route is called return a 404
    @Test
    public void whenUnknownRouteIsCalledReturn404() {
        webTestClient.get()
                .uri("/invalidRoute")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isNotFound();
    }
}
