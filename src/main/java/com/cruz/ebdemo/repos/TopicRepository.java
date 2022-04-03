package com.cruz.ebdemo.repos;

import com.cruz.ebdemo.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Interface defining a crud repo for topics
 */
public interface TopicRepository extends JpaRepository<Topic, Integer> {
    List<Topic> findByUrlClass(String urlClass);
}
