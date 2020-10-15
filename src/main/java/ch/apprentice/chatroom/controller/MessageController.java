package ch.apprentice.chatroom.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ch.apprentice.chatroom.dao.MessageDao;
import ch.apprentice.chatroom.entities.MessageEntity;

@RestController(value = "remo/chatroom/messages")
@RequestMapping("remo/chatroom/messages")
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

	@CrossOrigin(origins = "*")
	@GetMapping(path = "/search/user/{user}")
	public List<MessageEntity> findMessageByUser(@PathVariable String user) {

		return messageDao.findByUser(user);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(path = "/search/message/{message}")
	public List<MessageEntity> findMessageByMessage(@PathVariable String message) {

		return messageDao.findByMessage(message);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping(path = "/{id}/delete")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteMessage(@PathVariable int[] id) {
		for (int i = 0; i < id.length; i++) {
			messageDao.deleteMessange(id[i]);
		}
	}

}
