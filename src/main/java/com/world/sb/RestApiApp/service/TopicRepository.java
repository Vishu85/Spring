package com.world.sb.RestApiApp.service;

import com.world.sb.RestApiApp.model.Topic;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vishu on 6/26/2017.
 */
public interface TopicRepository extends CrudRepository<Topic,String> {



}
