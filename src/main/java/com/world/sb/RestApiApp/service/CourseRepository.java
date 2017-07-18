package com.world.sb.RestApiApp.service;

import com.world.sb.RestApiApp.model.Course;
import com.world.sb.RestApiApp.model.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Vishu on 6/26/2017.
 */
public interface CourseRepository extends CrudRepository<Course,String> {

    public List<Course> findByName(String name);
    public List<Course> findByTopicId(String topicId);

}
