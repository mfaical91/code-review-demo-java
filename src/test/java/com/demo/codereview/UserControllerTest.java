package com.demo.codereview;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnUserWithSafeSearch() throws Exception {
        mockMvc.perform(get("/api/users/search-safe")
                        .param("email", "alice@example.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].fullName").value("Alice Martin"));
    }

    @Test
    void shouldReturnUserWithDemoSearch() throws Exception {
        mockMvc.perform(get("/api/users/search")
                        .param("email", "bob@example.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].fullName").value("Bob Dupont"));
    }
}
