package com.reply.model.engine.iemotion;

import com.reply.model.engine.iemotion.language.English;
import com.reply.model.engine.iemotion.language.Lanuage;
import com.reply.model.repo.ConversationRepo;
import org.h2.util.StringUtils;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

@Component
public class Brain {

    public String act(String defaultThink, ConversationRepo conversationRepo){
        return conversationRepo.findAll().stream().findAny().isPresent()?call(conversationRepo):defaultThink;
    }

    private String call(ConversationRepo conversationRepo) {
        Emotion emotion = () -> { return createSentence();};
        return  emotion.thought();
    }

    private String createSentence() {
        Lanuage lanuage = new English();
        StringBuilder sb = new StringBuilder();
        Arrays.stream(lanuage.alphabets()).filter(ch -> !StringUtils.isNumber(ch)).map(ch -> ch.toString()).forEach(ch -> sb.append(ch));
        sb.append(Arrays.stream(lanuage.alphabets()).reduce("", (first, second)-> second+first));

        List<String> words = Arrays.stream(sb.toString().split("f"))
                .flatMap(sentence -> Arrays.stream(sentence.split("\\s+")))
                .collect(Collectors.toList());


        return sb.toString();
    }

    public static void main(String[] args){
        String[] array= {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"};

        /*List<String> ls = Arrays.stream(array).flatMap(ele -> Arrays.stream(ele.split(","))).
                collect(Collectors.toList()).stream().map(ele -> ele.trim()).
                collect(Collectors.toList());*/

        Collection<String> ls1 = Arrays.stream(array[0].split(",")).map(ele -> ele.trim()).collect(toCollection(TreeSet::new));
        Collection<String> ls2 = Arrays.stream(array[1].split(",")).map(ele -> ele.trim()).collect(toCollection(TreeSet::new));

        ls1.retainAll(ls2);

        for (String s: ls1) {
             System.out.println(s);
        }

        String word = "I love dogs";

        Collection<String> ls3 = Arrays.stream(word.split(" ")).collect(Collectors.toList());
        int longest = 0;
        String lonestWord = null;
        for (String s: ls3) {

            if( s.length() > longest){
                lonestWord = s;
                longest = s.length();

            }


        }System.out.println(lonestWord);
    }


    private void test(){

    }
}
