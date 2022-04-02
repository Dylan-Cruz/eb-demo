package com.cruz.ebdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Model representing a url to publish or a publication's url.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "url-publish")
@Entity
public class Topic {
    @Id
    private Long topicId;
    private String urlTitle;
    private String urlClass;

}
