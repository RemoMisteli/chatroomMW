package ch.apprentice.chatroom.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import ch.apprentice.chatroom.entities.MessageEntity;
import ch.apprentice.chatroom.repositories.MessageRepository;

@Service
public class MessageDao {
	@Autowired
	MessageRepository messageRepository;

	public MessageEntity getById(int id) {
		return messageRepository.getOne(id);
	}

	public List<MessageEntity> getAll() {
		return messageRepository.findAll();
	}

	public void save(MessageEntity entity) {

		messageRepository.save(entity);
	}

	public List<MessageEntity> findByUser(String user) {
		user = "%" + user + "%";
		return messageRepository.findUser(user);
	}

	public List<MessageEntity> findByMessage(String message) {
		message = "%" + message + "%";
		return messageRepository.findMessage(message);
	}
	
	public void deleteMessange(int id){
		if(messageRepository.existsById(id)) {
		messageRepository.deleteById(id);
		}
	}
}
