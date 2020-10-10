package io.itjun.hello.web;

import io.itjun.hello.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping(name = "/getUser", method = RequestMethod.POST)
    public List<User> getUser() {
        List<User> items = new ArrayList<>();
        items.add(new User("A1", "Alice", 12));
        items.add(new User("B1", "Bob", 13));
        return items;
    }
}
