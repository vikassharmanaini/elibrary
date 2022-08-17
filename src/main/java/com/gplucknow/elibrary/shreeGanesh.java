package com.gplucknow.elibrary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class shreeGanesh {
    @GetMapping(path = "/")
    public String Radhe(){
        return "Jai shree Ram";
    }
}
