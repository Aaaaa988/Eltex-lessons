package ru.kiselev;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
    private ArrayList<User> users = new ArrayList<>();
    @Autowired
    private UserController controller;
    @Test
    public void contextLoads() {
        org.assertj.core.api.Assertions.assertThat(controller).isNotNull();
    }
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void getUsers() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        users.add(new User(1, "Ivan Ivanov", "+79235648673"));
        users.add(new User(2, "Petya Petrovich", "+79543748537"));
        users.add(new User(3, "Gena Na", "+78007548548"));

        if (!users.isEmpty()) {
            this.mockMvc.perform(get("http://localhost:1050/get_users")).andDo(print()).andExpect(status().isOk())
                    .andExpect(content().string(containsString(mapper.writeValueAsString(users))));
        }else {
            this.mockMvc.perform(get("http://localhost:1050/get_users")).andDo(print()).andExpect(status().isOk())
                    .andExpect(content().string(containsString("Empty")));
        }

    }
    @Test
    public void getUser() throws Exception {
        this.mockMvc.perform(get("http://localhost:1050/get_user/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Ivan Ivanov")));
    }
}

