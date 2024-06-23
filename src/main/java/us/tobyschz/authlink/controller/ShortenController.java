package us.tobyschz.authlink.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import us.tobyschz.authlink.model.URLEntity;
import us.tobyschz.authlink.service.URLService;

@RestController
@RequestMapping("/shorten")
public class ShortenController {

    private final URLService urlService;
    @Autowired
    public ShortenController(URLService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/create")
    //@PreAuthorize("hasRole('USER')")
    @ResponseBody
    public String createShortenURL(@RequestBody URLEntity urlEntity) { //todo: implement JWT and service

        return "shortened";
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseBody
    public String deleteShortenURL(@RequestBody URLEntity urlEntity) { //todo: implement JWT and service
        //logic
        return "sucess or failure";
    }
}
