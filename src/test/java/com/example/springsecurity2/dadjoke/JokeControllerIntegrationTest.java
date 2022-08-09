package com.example.springsecurity2.dadjoke;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// We are asking the Spring Framework to initialize its Web Context only
// and we're asking that Web Context to only include this specific controller.

// This is helpful because it
// a) it does not initialize other aspect of Spring Framework (database connections, ...) and
// b) it does not initialize other controllers -
//    in a real-life application, you may have a large number of controllers associated with your application context.

// With the @WebMvcTest annotation, we get a bean that can get autowired by Spring to give us access to a
// MockMvc instance that we can then use to make actual http calls to our end points
@WebMvcTest(JokeController.class)
public class JokeControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    // adding a JokeService here
    @MockBean
    private JokeService jokeService;

    @Test
    void hello() throws Exception {
        // perform() method lets us pass in a http verb, along with the appropriate parameters for that call.
        // In this case, we are asking for a GET request to be executed and pass in the URL to which it should be submitted.
        mockMvc.perform(get("/hello"))
                // andDo(print()) call asks mockMvc to results of perform() call to the console - we can use this to diagnose potential issues
                .andDo(print())
                // andExpect(status().isOk()) call tells mockMvc that we want an HTTP status code of 200 to be returned as a result of perform() call
                .andExpect(status().isOk())
                // andExpect(content().string(containsString("Invalid Message"))) tells mockMvc that
                // we want the content of the response of perform() call to contain the string "Hello Stephanie".
                .andExpect(content().string(containsString("Hello Stephanie")));
    }

    @Test
    void shouldGreetByName() throws Exception {
        String greetingName = "Jamie";
        mockMvc.perform(get("/hello")

                .param("targetName", greetingName)) // We have changed the perform() call to chain it with a param() call
                // The param() call allows us to set up request parameter on the request
                // Here we are telling the request that it should have a request parameter named targetName and
                // that its value should be the value of the greetingName variable
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello " + greetingName)));
    }
}
