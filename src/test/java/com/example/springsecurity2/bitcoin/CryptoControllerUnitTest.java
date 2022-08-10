package com.example.springsecurity2.bitcoin;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CryptoControllerUnitTest {
    @Test // this test cares if I defined getBitcoinPrice() method correctly
    void getCryptoPrice() {
        CryptoService cryptoService = Mockito.mock(CryptoService.class);
        BigDecimal expected = BigDecimal.valueOf(23456.24);
        CryptoController cryptoController = new CryptoController(cryptoService);
        when(cryptoService.getCryptoPrice("bitcoin")).thenReturn(expected);
        System.out.println("expected: " + expected); // 23456.24
        BigDecimal actual = cryptoController.getCryptoPrice("bitcoin");
        System.out.println("actual: " + actual);
        assertEquals(expected, actual);
    }

    @Test // this test cares if I defined getCryptoName() method correctly
    void getCryptoName() {
        CryptoService cryptoService = Mockito.mock(CryptoService.class);
        String cryptoName = "bitcoin";
        CryptoController cryptoController = new CryptoController(cryptoService);
        when(cryptoService.getCryptoName(cryptoName)).thenReturn(cryptoName);
        System.out.println("expected: " + cryptoName); // bitcoin
        String actual = cryptoController.getCryptoName(cryptoName);
        System.out.println("actual: " + actual);
        assertEquals(cryptoName, actual);
    }
}