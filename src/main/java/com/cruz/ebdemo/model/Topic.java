package com.cruz.ebdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Model representing a url to publish or a publication's url.
 * Has a many to many relationship with topic list which in my
 * approach is a managed entity.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "url-publish")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Topic {
    @Id
    @XmlElement(name = "topicid")
    private Integer topicId;
    @XmlElement(name = "urltitle")
    private String urlTitle;
    @XmlElement(name = "urlclass")
    private String urlClass;

    @XmlTransient
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(mappedBy = "topics")
    private List<TopicList> topicLists;

    public Topic(Integer topicId, String urlTitle, String urlClass) {
        this.topicId = topicId;
        this.urlTitle = urlTitle;
        this.urlClass = urlClass;
    }

    @JsonIgnore
    public void setTopicLists(List<TopicList> topicLists) {
        this.topicLists = topicLists;
    }

    @JsonIgnore
    public List<TopicList> getTopicLists() {
        return topicLists;
    }

}
