package com.mars;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MissionToMarsApplication.class)
@WebAppConfiguration
public class MissionToMarsApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    // Movimento com rotações para direita:
    // curl -s --request POST http://localhost:8080/rest/mars/MMRMMRMM
    // Saída esperada: (2, 0, S)
    @Test
    public void testComandMMRMMRMM() throws Exception {
        mockMvc.perform(post("/rest/mars/MMRMMRMM")).andDo(print())
                .andExpect(MockMvcResultMatchers.content().string("(2, 0, S)"));
    }

    // Movimento para esquerda:
    // Entrada: curl -s --request POST http://localhost:8080/rest/mars/MML
    // Saída esperada: (0, 2, W)
    @Test
    public void testComandMML() throws Exception {
        mockMvc.perform(post("/rest/mars/MML")).andDo(print())
                .andExpect(MockMvcResultMatchers.content().string("(0, 2, W)"));
    }

    // Comando inválido:
    // curl -s --request POST http://localhost:8080/rest/mars/AAA
    // Saída esperada: 400 Bad Request
    @Test
    public void testComandAAA() throws Exception {
        mockMvc.perform(post("/rest/mars/AAA")).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    // Posição inválida:
    // curl -s --request POST
    // http://localhost:8080/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM
    // Saída esperada: 400 Bad Request
    @Test
    public void testComandMMMMMMMMMMMMMMMMMMMMMMMM() throws Exception {
        mockMvc.perform(post("/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM")).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}
