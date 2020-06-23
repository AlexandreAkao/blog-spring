package br.com.comments.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/agorinha")
public class AgorinhaController {

    @GetMapping()
    public String agorinha() {
        return "agorinha";
    }

}
