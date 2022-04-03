package com.cruz.ebdemo.config;

import com.cruz.ebdemo.model.Topic;
import com.cruz.ebdemo.model.TopicList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;


/**
 * Config to make an instance in the app context of a Jaxb2marshaller
 */
@Configuration
public class Jax2bMarshallingConfig {

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Topic.class);
        marshaller.setClassesToBeBound(TopicList.class);
        return marshaller;
    }
}
