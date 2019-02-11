package connectedcities;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ConnectedCheckerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnNoMessage() throws Exception {

        this.mockMvc.perform(get("/connected?origin=Boston&destination=Albany")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("no"));

        this.mockMvc.perform(get("/connected?origin=Philadelphia&destination=Albany")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("no"));
    }

    @Test
    public void shouldReturnYesMessage() throws Exception {

        this.mockMvc.perform(get("/connected?origin=Boston&destination=Newark")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("yes"));

        this.mockMvc.perform(get("/connected?origin=Boston&destination=Philadelphia")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("yes"));
    }

}
