package ch.apprentice.chatroom.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.apprentice.chatroom.entities.MessageEntity;


@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Integer>{
 
	
	List<MessageEntity> findByUser(String user);
	
	List<MessageEntity> findByMessage(String content);
		
		
	
}
