package com.reply.model.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(targetEntity=Conversation.class, mappedBy="replyTexts", fetch= FetchType.EAGER)
    private List<Conversation> replyTexts = new ArrayList<Conversation>();

    public String asString(){
      return  "<p>"+time+" "+conversationText+"</p>";
    }
}
