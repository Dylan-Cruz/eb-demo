package com.cruz.ebdemo.repos;

import com.cruz.ebdemo.model.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Long> {
    List<Topic> findByUrlClass(String urlClass);
}
