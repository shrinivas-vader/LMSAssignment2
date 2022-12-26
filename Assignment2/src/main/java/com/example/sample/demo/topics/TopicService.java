package com.example.sample.demo.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	public List<Topic> topics=new ArrayList<>(Arrays.asList(
					new Topic(1,"springframework"),
					new Topic(2,"java"),
					new Topic(3,"oracle123")	
					));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	public Topic getTopic(int id) {
		return topics.stream().filter(t->t.getId()==id).findFirst().get();

	}
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	public void updateById(int id,Topic topic) {
		for(int i=1;i<topics.size();i++) {
			Topic t=topics.get(i);
			if(t.getId()==id) {
				topics.set(i,topic);
				return;
			}
		}
	}
	public void deleteById(int id) {
		for(int i=1;i<topics.size();i++) {
			Topic t=topics.get(i);
			if(t.getId()==id) {
				topics.remove(i);
				return;
			}
		}
	}
}
