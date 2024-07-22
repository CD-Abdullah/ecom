package org.springcd.ecom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@CrossOrigin
public class BaseController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
