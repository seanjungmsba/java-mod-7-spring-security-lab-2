package com.example.springsecurity2.dadjoke;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JokeServiceIntegrationTest {

    // Since the jokes are random, we cannot test for a specific value back from the service, so we do 2 things instead:
        // 1. Test that the return value from the joke service is not null
        // 2. Make sure that we don't get the same joke on 2 consecutive calls, ensuring that the joke is indeed "random"
    @Test
    void shouldReturnRandomDadJoke() {
        JokeService jokeService = new JokeService();
        String firstRandomDadJoke = jokeService.getDadJoke();
        assertThat(firstRandomDadJoke).isNotNull();
        String secondRandomDadJoke = jokeService.getDadJoke();
        assertThat(secondRandomDadJoke).isNotNull();
        assertThat(firstRandomDadJoke).isNotEqualTo(secondRandomDadJoke);
    }
}