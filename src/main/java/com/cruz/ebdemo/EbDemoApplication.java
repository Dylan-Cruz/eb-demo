package com.cruz.ebdemo;

import com.cruz.ebdemo.model.Topic;
import com.cruz.ebdemo.repos.TopicRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class EbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbDemoApplication.class, args);
	}

}
