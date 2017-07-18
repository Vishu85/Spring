package com.world.sb.RestApiApp.service;

/**
 * Created by Vishu on 6/20/2017.
 */

import com.world.sb.RestApiApp.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    //Because Array list needs a list as parameter in constructor.
    private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
            new Topic("spring","Spring Framework","Spring Description"),
            new Topic("java","core java","java Description"),
            new Topic("Spark","Spark Engine","Spark Description")
    ));

    public List<Topic> getAllTopics() {
        //return cours;
       List<Topic> topic = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topic::add);
        return topic;
    }

    public Topic getTopic(String id){
       // return cours.stream().filter(topic -> topic.getId().equalsIgnoreCase(id)).findFirst().get();
        return topicRepository.findOne(id);
    }

    public void addTopic(Topic topic) {
       // cours.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic( String id ,Topic topic) {
        /*for (int i = 0; i <= cours.size(); i++) {
            Topic t = cours.get(i);
            if(t.getId().equalsIgnoreCase(id)){
                cours.set(i, topic);
                return;
            }
        }*/
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        //cours.removeIf(t->t.getId().equalsIgnoreCase(id));
        topicRepository.delete(id);
    }
}
