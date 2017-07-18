package com.world.sb.RestApiApp.model;

import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vishu on 6/19/2017.
 */

@Entity
public class Topic {

    @Id
    private String id;
    private String name;
    private  String description;

    private List<Course> courses = new ArrayList<>();

    public Topic(){
    }

    public Topic(String id, String name, String desc){
        super();
        this.id=id;
        this.name=name;
        this.description=desc;
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
}
