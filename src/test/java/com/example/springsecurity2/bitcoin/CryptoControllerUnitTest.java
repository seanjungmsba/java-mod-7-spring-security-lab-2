package com.example.springsecurity2.bitcoin;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CryptoControllerUnitTest {
    @Test // this test cares if I defined getBitcoinPrice() method correctly
    void getBitcoinPrice() {
        CryptoService cryptoService = Mockito.mock(CryptoService.class);
        BigDecimal expected = BigDecimal.valueOf(23456.24);
        CryptoController cryptoController = new CryptoController(cryptoService);
        when(cryptoService.getCryptoPrice("bitcoin")).thenReturn(expected);
        System.out.println("expected: " + expected); // 23456.24
        BigDecimal actual = cryptoController.getCryptoPrice("bitcoin");
        System.out.println("actual: " + actual);
        assertEquals(expected, actual);
    }

    @Test // this test cares if I defined getBitcoinPrice() method correctly
    void getBitcoinId() {
        CryptoService cryptoService = Mockito.mock(CryptoService.class);
        String expected = "bitcoin";
        CryptoController cryptoController = new CryptoController(cryptoService);
        when(cryptoService.getCryptoName()).thenReturn(expected);
        System.out.println("expected: " + expected); // bitcoin
        String actual = cryptoController.getCryptoName();
        System.out.println("actual: " + actual);
        assertEquals(expected, actual);
    }
}