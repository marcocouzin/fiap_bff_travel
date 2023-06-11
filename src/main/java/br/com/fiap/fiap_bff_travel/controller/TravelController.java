package br.com.fiap.fiap_bff_travel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TravelController {

    @RequestMapping("/")
    public String greeting() {
        return "Hello World";
    }
}
