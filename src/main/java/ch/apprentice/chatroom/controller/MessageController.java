package ch.apprentice.chatroom.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.apprentice.chatroom.dao.MessageDao;

@RestController(value = "chatroom/messages")
@RequestMapping("chatroom/messages")
public class MessageController {
	
	@Autowired
	MessageDao messageDao;
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "")
	public String getMessage() {
		
		
		Date date= new Date();
		
		return date.toString();
	}

	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/send/{name}/{message}")
	public void setMessage(@PathVariable String name, @PathVariable String message) {

		System.out.println();
		System.out.println();

		System.out.println(name + " " + message);


	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/{id}")
	public String setMessageById(@PathVariable int id) {

		return messageDao.getById(id).getMessage();


	}
}
