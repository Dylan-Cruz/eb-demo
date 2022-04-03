package com.cruz.ebdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
    private Long topicId;
    @XmlElement(name = "urltitle")
    private String urlTitle;
    @XmlElement(name = "urlclass")
    private String urlClass;

    @XmlTransient
    @ManyToMany(mappedBy = "topics")
    @EqualsAndHashCode.Exclude
    private List<TopicList> topicLists;

    public Topic(Long topicId, String urlTitle, String urlClass) {
        this.topicId = topicId;
        this.urlTitle = urlTitle;
        this.urlClass = urlClass;
    }
}
