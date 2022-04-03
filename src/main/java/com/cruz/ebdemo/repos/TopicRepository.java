package com.cruz.ebdemo.repos;

import com.cruz.ebdemo.model.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Interface defining a crud repo for topics
 */
public interface TopicRepository extends CrudRepository<Topic, Long> {
    List<Topic> findByUrlClass(String urlClass);
}
