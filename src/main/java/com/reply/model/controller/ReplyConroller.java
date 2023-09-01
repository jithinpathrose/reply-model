package com.reply.model.controller;

import com.reply.model.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/response")
public class ReplyConroller {

    @Autowired
    private ModelService modelService;

    @GetMapping("/out")
    public String getModelOut(){
        return modelService.think();
    }
}
