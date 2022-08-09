package com.example.springsecurity2.dadjoke;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service // The @Service annotation associated with the class defines this class as a service component within the Spring Framework.
public class JokeService {
    // Note: this is not a "unit" test because it actually lets the real service (not mocked) make a request to the
    // real API and tests the actual response (albeit not the actual precise value, for the reasons we discussed)
    public String getDadJoke() {
        String apiURL = "https://icanhazdadjoke.com/";
        // We use the RestTemplate class to make a request to the URL for the Joke API
        RestTemplate restTemplate = new RestTemplate();
        // We use the getForObject() method and tell it to take the return of the call to the URL and convert its JSON return to a Java object
        // We define the Java object as a simple POJO that has 3 properties that match the JSON that the API returns
        // The getForObject method takes care of converting JSON to Java and returns an object of type DadJoke
        // We can then take the joke property of the DadJoke object and return it to the caller
        String result = restTemplate.getForObject(apiURL, DadJoke.class).joke;
        return result;
    }

    class DadJoke {
        public String id;
        public String joke;
        public String status;
    }
}

