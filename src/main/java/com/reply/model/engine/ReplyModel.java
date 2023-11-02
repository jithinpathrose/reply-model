package com.reply.model.engine;

import com.reply.model.engine.iemotion.Brain;
import com.reply.model.model.Conversation;
import com.reply.model.repo.ConversationRepo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
public class ReplyModel {

    private static final String defaultThink = "{hm, hey}";

    @Autowired
    private Clock clock;

    @Autowired
    private Brain brain;

    public String think(ConversationRepo conversationRepo) {
        var result = thought(defaultThink, conversationRepo);

        StringBuilder stringBuilder = new StringBuilder();
        conversationRepo.findAll().stream().forEach(conv-> {stringBuilder.append(conv.asString());});
        stringBuilder.append(result.asString());
        conversationRepo.save(result);
        return stringBuilder.toString();
    }

    private Conversation thought(String defaultThink, ConversationRepo conversationRepo) {
        return new Conversation(LocalDateTime.now(clock).toString(), prepareConv(defaultThink, conversationRepo), null);
    }

    private String prepareConv(String defaultThink, ConversationRepo conversationRepo) {
        return brain.act(defaultThink, conversationRepo);
    }
}
