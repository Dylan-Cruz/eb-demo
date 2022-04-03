package com.cruz.ebdemo.xml;

import com.cruz.ebdemo.config.TestTopicRepoPopulatorConfig;
import com.cruz.ebdemo.model.Topic;
import com.cruz.ebdemo.repos.TopicRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@Import(TestTopicRepoPopulatorConfig.class)
public class TopicRepoPopulatorTests {

    @Autowired
    private TopicRepository topicRepository;

    @Test
    public void validatePopulatorPopulatesRepo() {
        Topic expectedTopic = new Topic(3L, "william-butler-yeats", "literature");
        Topic actualTopic = topicRepository.findById(3L).get();
        assertEquals(expectedTopic, actualTopic);
    }
}
