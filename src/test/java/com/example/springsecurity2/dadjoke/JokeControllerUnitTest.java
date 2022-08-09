package com.example.springsecurity2.dadjoke;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class JokeControllerUnitTest {
    @Test
    void shouldReturnGreeting() {
        // We define a jokeService object of type JokeService
        // We use Mockito to mock the behavior of the getDadJoke() method in that service
        // Mockito.mock() allows us to specify the class for which we need to create an instance, in this case it's JokeService.class
        JokeService jokeService = Mockito.mock(JokeService.class);
        String dadJoke = "Did you hear about the new restaurant on the moon? The food is great, " +
                "but there’s just no atmosphere.";
        JokeController helloController = new JokeController(jokeService);
        // when().thenReturn(): this construct allows us to tell Mockito what to return when a specific method of our mock object is called
        // this is what hardcoded that specific response for every time that method is called
        when(jokeService.getDadJoke()).thenReturn(dadJoke);
        String name = "Jamie";
        // We set values for the actual and expected variables and assert that they match to complete our unit test
        String expected = "Hello " + name + "<br/>" +
                "Dad joke of the moment: " +
                dadJoke;
        String actual = helloController.hello(name);
        assertEquals(expected, actual);
    }
}