package com.example.springsecurity2.dadjoke;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class JokeController {

    // We create a private instance variable jokeService to get access to the service's methods
    private JokeService jokeService;

    // Since our JokeService class has the @Service annotation,
    // the Spring framework will take care of passing in an instance of the joke service into the HelloController() constructor
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    // We use the jokeService object to get the random joke and build a return String that includes it
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "targetName", defaultValue = "Stephanie") String name) {
        String greeting = "Hello " + name;
        greeting += "<br/>";
        greeting += "Dad joke of the moment: " + jokeService.getDadJoke();
        return greeting;
    }

}