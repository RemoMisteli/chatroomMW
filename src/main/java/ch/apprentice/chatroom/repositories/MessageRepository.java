package ch.apprentice.chatroom.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ch.apprentice.chatroom.entities.MessageEntity;


@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Integer>{
 
	
	
	@Query("SELECT m FROM MessageEntity m WHERE user LIKE :user")
    public List<MessageEntity> findUser(@Param("user") String user);
	
	
	@Query("SELECT m FROM MessageEntity m WHERE content LIKE :message")
    public List<MessageEntity> findMessage(@Param("message") String message);
	
	

		
		
	
}
