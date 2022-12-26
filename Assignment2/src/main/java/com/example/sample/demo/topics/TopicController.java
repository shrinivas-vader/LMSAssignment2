package com.example.sample.demo.topics;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired		
	private TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		
		return topicService.getAllTopics();
		
	}
	@RequestMapping("/topics/{id}")
	public Topic GetTopic(@PathVariable int id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public String updateById( @RequestBody Topic topic, @PathVariable int id) {
		
		 topicService.updateById(id,topic);
		 return "ok";
	}
	@RequestMapping(method=RequestMethod.DELETE,value="topics/{id}")
	public String deleteById(@RequestBody Topic topic,@PathVariable int id) {
		topicService.deleteById(id);
		return "deleted";
	}
}
