package com.example.springsecurity2.bitcoin;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CryptoController.class)
@AutoConfigureMockMvc
public class CryptoControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CryptoService cryptoService;

    @WithMockUser(username = "fakeuser", authorities = "read")
    @Test
    void getPrice() throws Exception {
        BigDecimal value = BigDecimal.valueOf(23218.3479504872028595);
        String cryptoName = "bitcoin";

        Mockito.when(cryptoService.getCryptoPrice(cryptoName)).thenReturn(value);
        // perform() method lets us pass in a http verb, along with the appropriate parameters for that call.
        // In this case, we are asking for a GET request to be executed and pass in the URL to which it should be submitted.
        mockMvc.perform(get("/crypto/bitcoin"))
                // andDo(print()) call asks mockMvc to results of perform() call to the console - we can use this to diagnose potential issues
                .andDo(print())
                // andExpect(status().isOk()) call tells mockMvc that we want an HTTP status code of 200 to be returned as a result of perform() call
                .andExpect(status().isOk())
                // tells mockMvc that we want the content of the response of perform() call to contain the string "Hello Stephanie".
                .andExpect(content().string(containsString(String.valueOf(value))));
    }

    @WithMockUser(username = "fakeuser", authorities = "read")
    @Test
    void getId() throws Exception {
        String cryptoName = "bitcoin";

        Mockito.when(cryptoService.getCryptoName(cryptoName)).thenReturn(cryptoName);
        // perform() method lets us pass in a http verb, along with the appropriate parameters for that call.
        // In this case, we are asking for a GET request to be executed and pass in the URL to which it should be submitted.
        mockMvc.perform(get("/crypto/bitcoin"))
                // andDo(print()) call asks mockMvc to results of perform() call to the console - we can use this to diagnose potential issues
                .andDo(print())
                // andExpect(status().isOk()) call tells mockMvc that we want an HTTP status code of 200 to be returned as a result of perform() call
                .andExpect(status().isOk())
                // tells mockMvc that we want the content of the response of perform() call to contain the string "Hello Stephanie".
                .andExpect(content().string(containsString(cryptoName)));
    }
}
