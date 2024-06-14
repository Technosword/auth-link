package us.tobyschz.authlink.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    @GetMapping("/hello")
    @ResponseBody
    public String getHello() {
        return "Hello world!";
    }
/*
    @PostMapping("/api/links")
    @PreAuthorize("user")
    public ResponseEntity<Object> shortenLink(@RequestBody link,)


 */

}
