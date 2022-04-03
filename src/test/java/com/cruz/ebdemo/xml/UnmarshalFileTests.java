package com.cruz.ebdemo.xml;

import com.cruz.ebdemo.model.Topic;
import com.cruz.ebdemo.model.TopicList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.transform.stream.StreamSource;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Contains tests pertaining to the successful unmarshalling of
 * topic lists from files
 */
@SpringBootTest
public class UnmarshalFileTests {

    @Autowired
    private Jaxb2Marshaller marshaller;

    @Test
    public void verifyValidFileUnmarshalls() throws IOException {
        // get the file from resources
        ClassPathResource file = new ClassPathResource("test_valid_topics.xml");

        // unmarshal the file
        marshaller.unmarshal(new StreamSource(file.getInputStream()));
    }

    @Test
    public void verifyValidTopicUnmarshallsCorrectly() throws IOException {
        // get the file from resources
        ClassPathResource file = new ClassPathResource("test_valid_topics.xml");

        // unmarshal the file
        TopicList list = (TopicList) marshaller.unmarshal(new StreamSource(file.getInputStream()));

        // verify the first item in the list is as expected
        Topic expectedTopic = new Topic(1L, "a-search-algorithm", "computing");
        assertEquals(expectedTopic, list.getTopics().get(0));
    }
}
