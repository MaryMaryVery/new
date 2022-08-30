package org.itstep.helloworldspring;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


    @SpringBootTest
    @AutoConfigureMockMvc
    public class TestApp {
        @Autowired
        private MockMvc mvc;

        @Test
        public void getOwner() throws Exception {
            mvc.perform(MockMvcRequestBuilders.get("/Owner")
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect((ResultMatcher) jsonPath("$", Matchers.hasSize(2)))
                    .andExpect((ResultMatcher) jsonPath("$[0].name", Matchers.equalTo("French Pave Diamond Engagement Ring in Platinum (1/4 ct. tw.)")));

        }

        @Test
        public void getOwnerById() throws Exception {
            mvc.perform(MockMvcRequestBuilders.get("Owner")
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect((ResultMatcher) jsonPath("$.name", Matchers.equalTo("Ivan Ivanov")));

        }

        @ParameterizedTest // Создаем параметризованный тест
        @ValueSource(ints = {-1, 0, 1, 2, Integer.MAX_VALUE})
        public void getOwenerById(int id) throws Exception {
            ResultActions actions = mvc.perform(MockMvcRequestBuilders.get("/Owner/{id}", id).
                    accept(MediaType.APPLICATION_JSON));
            actions
                    .andExpect(status().isOk());
            switch (id) {
                case 1:
                    actions
                            .andExpect((ResultMatcher) jsonPath("$.name", Matchers.equalTo("French Pave Diamond Engagement Ring in Platinum (1/4 ct. tw.)")));
                    break;
                case 2:
                    actions
                            .andExpect((ResultMatcher) jsonPath("$.name", Matchers.equalTo("Petite Solitaire Engagement Ring in Platinum")));
                    break;
                default:
                    actions
                            .andExpect((ResultMatcher) content().string("null"));
            }
        }
    }
