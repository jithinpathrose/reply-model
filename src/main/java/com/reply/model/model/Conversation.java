package com.reply.model.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Data
@Entity
@AllArgsConstructor
public class Conversation {

    public Conversation(){}

    @Id
    private String time;

    private String conversationText;
}
