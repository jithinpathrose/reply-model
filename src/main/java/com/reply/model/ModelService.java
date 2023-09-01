package com.reply.model;

import com.reply.model.engine.ReplyModel;
import com.reply.model.repo.ConversationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelService {

    @Autowired
    private ReplyModel replyModel;

    @Autowired
    private ConversationRepo conversationRepo;

    public String think() {
        return replyModel.think(conversationRepo);
    }
}
