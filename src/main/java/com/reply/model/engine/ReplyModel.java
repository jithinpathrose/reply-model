package com.reply.model.engine;

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

    public String think(ConversationRepo conversationRepo) {
        var result = thought(defaultThink, conversationRepo);
        conversationRepo.save(result);
        return result.toString();
    }

    private Conversation thought(String defaultThink, ConversationRepo conversationRepo) {

        return new Conversation(LocalDateTime.now(clock).toString(), prepareConv(defaultThink, conversationRepo));
    }

    private String prepareConv(String defaultThink, ConversationRepo conversationRepo) {
        return conversationRepo.findAll().stream().findFirst().isPresent()?conversationRepo.findAll().stream().map(Conversation::getConversationText).collect(Collectors.toList()).stream()
                .reduce("", (accum, current) -> callBrain(defaultThink, accum, current)):defaultThink;
    }

    private static String callBrain(String defaultThink, String accum, String current) {
        return accum + " " + current.substring(0, defaultThink.length());
    }
}
