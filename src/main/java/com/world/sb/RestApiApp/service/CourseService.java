package com.world.sb.RestApiApp.service;

/**
 * Created by Vishu on 6/20/2017.
 */

import com.world.sb.RestApiApp.model.Course;
import com.world.sb.RestApiApp.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    //Because Array list needs a list as parameter in constructor.
   /* private List<Course> Courses = new ArrayList<Course>(Arrays.asList(
            new Course("spring","Spring Framework","Spring Description"),
            new Course("java","core java","java Description"),
            new Course("Spark","Spark Engine","Spark Description")
    ));*/

    public List<Course> getAllCourses(String topicId) {
        //return course;
       List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId)
                .forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id){
       // return course.stream().filter(Course -> Course.getId().equalsIgnoreCase(id)).findFirst().get();
        return courseRepository.findOne(id);
    }

    public void addCourse(Course Course) {
       // course.add(Course);
        courseRepository.save(Course);
    }

    public void updateCourse(Course Course) {
        /*for (int i = 0; i <= cours.size(); i++) {
            Course t = cours.get(i);
            if(t.getId().equalsIgnoreCase(id)){
                cours.set(i, Course);
                return;
            }
        }*/
        courseRepository.save(Course);
    }

    public void deleteCourse(String id) {
        //cours.removeIf(t->t.getId().equalsIgnoreCase(id));
        courseRepository.delete(id);
    }
}
