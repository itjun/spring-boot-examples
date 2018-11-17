package io.itjun.restful;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        log.info("name = {}", name);
        return new Greeting(counter.getAndIncrement(), String.format(template, name));
    }

    @RequestMapping("/github/{user}")
    public String user(@PathVariable("user") String user) {
        return "user = " + user;
    }

    @RequestMapping("/github/{orgs}/{repository}")
    public String orgs(@PathVariable("orgs") String orgs, @PathVariable("repository") String repository) {
        return String.format("orgs = %s, repository = %s", orgs, repository);
    }

    @RequestMapping("/hello")
    public String getMapping(@RequestParam("name") String name) {
        return name;
    }

}
