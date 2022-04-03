package com.cruz.ebdemo.model;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Model representing a topic list. In my approach this is a managed
 * entity as it allowed me to use springs jpa repo populator and
 * would be useful in the context of passing around currated lists
 * of publications.
 */
@Data
@XmlRootElement(name = "publish-list")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class TopicList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long topicListId;

    @XmlElement(name = "url-publish")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (
            name = "TopicList_Topic",
            joinColumns = {
                    @JoinColumn(name = "topic_list_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "topic_id")
            }
    )
    private List<Topic> topics;

}
