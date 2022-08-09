package com.example.springsecurity2.bitcoin;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class CryptoService {

    public BigDecimal getCryptoPrice(String cryptoName) {
        try {
            String apiURL = "https://api.coincap.io/v2/assets/" + cryptoName;
            // We use the RestTemplate class to make a request to the URL for the Joke API
            RestTemplate restTemplate = new RestTemplate();
            // We use the getForObject() method and tell it to take the return of the call to the URL and convert its JSON return to a Java object
            // We define the Java object as a simple POJO that has 3 properties that match the JSON that the API returns
            // The getForObject method takes care of converting JSON to Java and returns an object of type DadJoke
            // We can then take the joke property of the DadJoke object and return it to the caller
            Data data = restTemplate.getForObject(apiURL, Data.class);
            CryptoData cryptoData = data.getData();
            BigDecimal cryptoPrice = cryptoData.getPriceUsd();
            return cryptoPrice;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("something went wrong");
        }
        return null;
    }

    public String getCryptoName() {
        try {
            String apiURL = "https://api.coincap.io/v2/assets/bitcoin/";
            // We use the RestTemplate class to make a request to the URL for the Joke API
            RestTemplate restTemplate = new RestTemplate();
            // We use the getForObject() method and tell it to take the return of the call to the URL and convert its JSON return to a Java object
            // We define the Java object as a simple POJO that has 3 properties that match the JSON that the API returns
            // The getForObject method takes care of converting JSON to Java and returns an object of type DadJoke
            // We can then take the joke property of the DadJoke object and return it to the caller
            Data data = restTemplate.getForObject(apiURL, Data.class);
            CryptoData cryptoData = data.getData();
            String bitcoinId = cryptoData.getId();
            return bitcoinId;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("something went wrong");
        }
        return null;
    }

}

class CryptoData {
    public String id;
    public BigDecimal priceUsd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(BigDecimal priceUsd) {
        this.priceUsd = priceUsd;
    }
}

class Data {
    private CryptoData data;

    public CryptoData getData() {
        return data;
    }

    public void setData(CryptoData data) {
        this.data = data;
    }
}

