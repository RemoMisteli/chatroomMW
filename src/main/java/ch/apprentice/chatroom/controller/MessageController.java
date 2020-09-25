package ch.apprentice.chatroom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "chatroom/messages")
@RequestMapping("chatroom/messages")
public class MessageController {
	
	
	@GetMapping(path = "")
	public String getMessage() {
		return "test";
	}

}
