package com.cruz.ebdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.UnmarshallerRepositoryPopulatorFactoryBean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * Contains configuration for an xml repo populator bean to read from topics
 * and populate the topics repo on startup.
 */
@Configuration
@Profile("!test")
public class TopicRepoPopulatorConfig {

    @Autowired
    private Jaxb2Marshaller marshaller;

    @Bean
    public UnmarshallerRepositoryPopulatorFactoryBean topicRepoPopulator() {
        UnmarshallerRepositoryPopulatorFactoryBean factory = new UnmarshallerRepositoryPopulatorFactoryBean();
        factory.setUnmarshaller(marshaller);
        factory.setResources(new Resource[] { new ClassPathResource("eb_topics.xml") });
        return factory;
    }
}
