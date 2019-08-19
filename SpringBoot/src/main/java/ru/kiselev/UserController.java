package ru.kiselev;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
public class UserController {
    private static final Integer ZERO_SHIFT = 1;

    private ArrayList<User> users = new ArrayList<>();
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public void init_users(){
        users.add(new User(1, "Ivan Ivanon", "+79235648673"));
        users.add(new User(2, "Petya Petrovich", "+79543748537"));
        users.add(new User(3, "Gena Na", "+78007548548"));
    }
    @RequestMapping("/get_users")
    public String getUser() throws IOException {
        return mapper.writeValueAsString(users);
    }
    @RequestMapping("/get_user/{id}")
    public String getUserWithID(@PathVariable("id") Integer id) throws IOException {
        return mapper.writeValueAsString(users.get(id - ZERO_SHIFT));
    }
}
