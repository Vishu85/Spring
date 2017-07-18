package com.world.sb.RestApiApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Vishu on 6/19/2017.
 */

@Entity
public class Course {

    @Id
    private String id;
    private String name;
    private  String description;

    @ManyToOne
    private Topic topic;

    public Course(){
    }

    public Course(String id, String name, String desc, String topicId){
        super();
        this.id=id;
        this.name=name;
        this.description=desc;
        this.topic=new Topic(topicId,"","");
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
