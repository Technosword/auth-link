package us.tobyschz.authlink.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> createShortenURL(@RequestBody URLEntity urlEntity) { //todo: implement JWT and service
        String finalString = urlService.createShortURL(urlEntity.getFullURL(), "someone");
        return ResponseEntity.ok(finalString);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseBody
    public String deleteShortenURL(@RequestBody URLEntity urlEntity) { //todo: implement JWT and service
        //logic
        return "sucess or failure";
    }
}
