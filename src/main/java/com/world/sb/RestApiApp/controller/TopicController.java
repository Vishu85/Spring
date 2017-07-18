package com.world.sb.RestApiApp.controller;

import com.world.sb.RestApiApp.model.Topic;
import com.world.sb.RestApiApp.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vishu on 6/19/2017.
 */

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(value = "/listall", method = RequestMethod.GET)
    public List<Topic> getAllTopics(){
       return topicService.getAllTopics();
    }

   /* @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }*/
    //Both this and above are valid.
   // Just in case the variable name and url have different nameing, the below way can be used
    //Path Variable is used to access value in the /{id} field
    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public Topic getTopic(@PathVariable("id") String lk){
        return topicService.getTopic(lk);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);

    }

    @RequestMapping(value = "/topic/{id}",method = RequestMethod.PUT)
    public void updateTopic(Topic topic, @PathVariable String id){
        topicService.updateTopic(id, topic);

    }

    @RequestMapping(value = "/topic/{id}",method = RequestMethod.DELETE)
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);

    }
}
