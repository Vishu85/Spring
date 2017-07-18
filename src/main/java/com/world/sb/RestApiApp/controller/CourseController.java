package com.world.sb.RestApiApp.controller;

import com.world.sb.RestApiApp.model.Course;
import com.world.sb.RestApiApp.model.Topic;
import com.world.sb.RestApiApp.service.CourseService;
import com.world.sb.RestApiApp.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vishu on 6/19/2017.
 */

@RestController
@RequestMapping("/topics")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // get All courses for the Topic
    @RequestMapping(value = "/topics/{id}/courses", method = RequestMethod.GET)
    public List<Course> getAllCourses(@PathVariable String id){
       return courseService.getAllCourses(id);
    }

   /* @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }*/
    //Both this and above are valid.
   // Just in case the variable name and url have different nameing, the below way can be used
    //Path Variable is used to access value in the /{id} field
    @RequestMapping(value = "/topics/{topicId}/courses{id}", method = RequestMethod.GET)
    public Course getCourse(@PathVariable("id") String lk){
        return courseService.getCourse(lk);
    }

    @RequestMapping(value = "/topics/{topicId}/courses",method = RequestMethod.POST)
    public void addCourse(@RequestBody Course course, @PathVariable String topicId ){
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);

    }

    @RequestMapping(value = "/topics/{topicId}/courses",method = RequestMethod.PUT)
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId,"",""));
        //courseService.updateCourse(id, course);
        courseService.updateCourse(course);

    }

    @RequestMapping(value = "/topics/{topicId}/courses{id}",method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);

    }
}
