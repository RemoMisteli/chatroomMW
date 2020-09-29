package ch.apprentice.chatroom.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.apprentice.chatroom.dao.MessageDao;
import ch.apprentice.chatroom.entities.MessageEntity;

@RestController(value = "chatroom/messages")
@RequestMapping("chatroom/messages")
public class MessageController {
	
	@Autowired
	MessageDao messageDao;
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "")
	public List<MessageEntity> getMessage() {
		return messageDao.getAll();
	}

	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/send/{name}/{message}")
	public void setMessage(@PathVariable String name, @PathVariable String message) {

		
		MessageEntity entity = new MessageEntity();
		entity.setMessage(message);
		entity.setUser(name);
		
		messageDao.save(entity);


	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/{id}")
	public MessageEntity getMessageById(@PathVariable int id) {

		return messageDao.getById(id);


	}
}
