package com.cruz.ebdemo.repos;

import com.cruz.ebdemo.model.Topic;
import com.cruz.ebdemo.model.TopicList;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface defining a crud repo for topic lists
 */
public interface TopicListRepository extends CrudRepository<TopicList, Long> {
}
