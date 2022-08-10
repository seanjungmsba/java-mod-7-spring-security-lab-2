package com.example.springsecurity2.bitcoin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/crypto")
public class CryptoController {

    // We create a private instance variable jokeService to get access to the service's methods
    @Autowired
    private final CryptoService cryptoService;

    Logger logger = LoggerFactory.getLogger(CryptoController.class);

    // Since our BitcoinService class has the @Service annotation,
    // the Spring framework will take care of passing in an instance of the joke service into the BitcoinController() constructor
    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping(value = "/price/{cryptoPrice}")
    public BigDecimal getCryptoPrice(@PathVariable(value = "cryptoPrice") String cryptoName) {
        logger.trace("Starting getCryptoPrice() method");
        BigDecimal price = cryptoService.getCryptoPrice(cryptoName);
        logger.trace("Ending getCryptoPrice() method");
        return price;
    }

    @GetMapping(value = "/name/{cryptoName}")
    public String getCryptoName(@PathVariable(value = "cryptoName") String cryptoName) {
        logger.trace("Starting getCryptoName() method");
        String name = cryptoService.getCryptoName(cryptoName);
        logger.trace("Ending getCryptoName() method");
        return name;
    }
}
