package com.silvereaglesystems.mvc;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.silvereaglesystems.mvc.models.Client;
import com.silvereaglesystems.mvc.models.Description;
import com.silvereaglesystems.mvc.models.Extension;

@RestController
public class GreetingsController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping(value="/extension", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Extension extension(@RequestBody(required = false) Extension extension) {
        return extension;
    }
}
