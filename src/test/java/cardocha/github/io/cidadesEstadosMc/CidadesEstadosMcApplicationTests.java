package cardocha.github.io.cidadesEstadosMc;

import cardocha.github.io.cidadesEstadosMc.controller.ControllerPrincipal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebMvcTest(ControllerPrincipal.class)
class CidadesEstadosMcApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    void json() throws Exception {
        mvc.perform(get("/json")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void csv() throws Exception {
        mvc.perform(get("/csv")
                .contentType(MediaType.APPLICATION_OCTET_STREAM))
                .andExpect(status().isOk());
    }

    @Test
    void buscaCidade() throws Exception {
        mvc.perform(get("/cidades/Ariquemes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("1100023"));
    }

}
