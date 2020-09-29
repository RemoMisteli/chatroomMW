package ch.apprentice.chatroom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.apprentice.chatroom.entities.MessageEntity;


@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Integer>{
	
	

}
