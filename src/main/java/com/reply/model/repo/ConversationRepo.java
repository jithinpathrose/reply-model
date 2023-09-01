package com.reply.model.repo;

import com.reply.model.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationRepo extends JpaRepository<Conversation, String> {
}
