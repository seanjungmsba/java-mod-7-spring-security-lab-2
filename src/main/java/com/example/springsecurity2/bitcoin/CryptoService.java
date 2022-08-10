package com.example.springsecurity2.bitcoin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class CryptoService {

    Logger logger = LoggerFactory.getLogger(CryptoService.class);
    public BigDecimal getCryptoPrice(String name) {
        try {
            logger.trace("TRACE: starting getCryptoPrice() method");
            logger.info("INFO: configuring crypto endpoint");
            String apiURL = "https://api.coincap.io/v2/assets/" + name;
            // We use the RestTemplate class to make a request to the URL for the Joke API
            logger.info("INFO: instantiating restTemplate");
            RestTemplate restTemplate = new RestTemplate();
            // We use the getForObject() method and tell it to take the return of the call to the URL and convert its JSON return to a Java object
            // We define the Java object as a simple POJO that has 3 properties that match the JSON that the API returns
            // The getForObject method takes care of converting JSON to Java and returns an object of type DadJoke
            // We can then take the joke property of the DadJoke object and return it to the caller
            logger.info("INFO: creating Data object");
            Data data = restTemplate.getForObject(apiURL, Data.class);
            logger.info("INFO: creating cryptoData object");
            cryptoData cryptoData = data.getData();
            logger.info("INFO: getting cryptoPrice");
            BigDecimal cryptoPrice = cryptoData.getPriceUsd();
            logger.info("INFO: returning cryptoPrice");
            logger.trace("TRACE: ending getCryptoPrice() method");
            return cryptoPrice;
        } catch (Exception e) {
            logger.error("something went wrong");
        }
        return null;
    }

    public String getCryptoName(String name) {
        try {
            logger.trace("TRACE: starting getCrpytoName() method");
            logger.info("INFO: configuring crypto endpoint");
            String apiURL = "https://api.coincap.io/v2/assets/" + name;;
            // We use the RestTemplate class to make a request to the URL for the Joke API
            logger.info("INFO: instantiating restTemplate");
            RestTemplate restTemplate = new RestTemplate();
            // We use the getForObject() method and tell it to take the return of the call to the URL and convert its JSON return to a Java object
            // We define the Java object as a simple POJO that has 3 properties that match the JSON that the API returns
            // The getForObject method takes care of converting JSON to Java and returns an object of type DadJoke
            // We can then take the joke property of the DadJoke object and return it to the caller
            logger.info("INFO: returning Data object");
            Data data = restTemplate.getForObject(apiURL, Data.class);
            logger.info("INFO: returning cryptoData object");
            cryptoData cryptoData = data.getData();
            logger.info("INFO: returning cryptoName object");
            String cryptoName = cryptoData.getId();
            logger.info("INFO: returning cryptoName");
            logger.trace("TRACE: ending getCrpytoName() method");
            return cryptoName;
        } catch (Exception e) {
            logger.error("something went wrong");
        }
        return null;
    }

}

class cryptoData {
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
    private cryptoData data;
    public cryptoData getData() {
        return data;
    }
    public void setData(cryptoData data) {
        this.data = data;
    }
}

