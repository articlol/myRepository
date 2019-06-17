package controllers;



import Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import repository.UserRepository;

import java.util.Map;


@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/welcome")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "welcome";
    }
    @GetMapping("/main")
    public String main(Map<String, Object> model){
        Iterable<User> users = userRepository.findAll();
        model.put("users", users);
        return "main";
    }
    @PostMapping("/main")
    public String add(@RequestParam String name, @RequestParam int age, @RequestParam String email,
                      Map<String, Object> model){
        User user = new User(name, age, email);
        userRepository.save(user);
        Iterable<User> users = userRepository.findAll();
        model.put("users", users);
        return "main";
    }
}