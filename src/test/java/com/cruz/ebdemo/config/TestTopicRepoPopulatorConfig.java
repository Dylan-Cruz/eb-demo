package com.cruz.ebdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.UnmarshallerRepositoryPopulatorFactoryBean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@TestConfiguration
public class TestTopicRepoPopulatorConfig {

    @Autowired
    private Jaxb2Marshaller marshaller;

    @Bean
    public UnmarshallerRepositoryPopulatorFactoryBean topicRepoPopulator() {
        UnmarshallerRepositoryPopulatorFactoryBean factory = new UnmarshallerRepositoryPopulatorFactoryBean();
        factory.setUnmarshaller(marshaller);
        factory.setResources(new Resource[] { new ClassPathResource("test_valid_topics.xml") });
        return factory;
    }
}
