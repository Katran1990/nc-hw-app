package com.khripko.controller;

import com.khripko.model.Note;
import com.khripko.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HWController {

    @Autowired
    private NoteService service;

    @GetMapping("/hello")
    public String getHello(Model model){
        Note note = service.findById(0);
        model.addAttribute(note);
        return "hello";
    }
}
