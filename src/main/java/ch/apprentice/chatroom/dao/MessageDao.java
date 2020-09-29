package ch.apprentice.chatroom.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public List<MessageEntity> getAll(){
		return messageRepository.findAll();
	}
}
