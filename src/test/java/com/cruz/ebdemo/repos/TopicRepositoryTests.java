package com.cruz.ebdemo.repos;

import com.cruz.ebdemo.config.TestTopicRepoPopulatorConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@Import(TestTopicRepoPopulatorConfig.class)
public class TopicRepositoryTests {

    @Autowired
    private TopicRepository topicRepo;

    @Test
    public void testFindTopicByClass() {
        assertEquals(2, topicRepo.findByUrlClass("science").size());
    }
}
