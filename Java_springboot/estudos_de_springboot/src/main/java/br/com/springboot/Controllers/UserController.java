package br.com.springboot.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.springboot.repository.UserRepository;
import br.com.springboot.Model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/users")

public class UserController {

    private List<User> users = new ArrayList<>();

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long Id) {
        Optional<User> userFind = users.stream().filter(user -> user.getId() == Id).findFirst();
        if(userFind.isPresent()){
            return userFind.get();
        }
        return null;
    }

    @PostMapping("/")
    public User user(@RequestBody User user) {
        return this.userRepository.save(user); ;
    }

    @GetMapping("/List")
    public List<User> list() {

        return users;
    }
}
