package com.example.springsecurity2.bitcoin;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CryptoServiceIntegrationTest {

    @Test // passed
    void shouldReturnPrice() {
        String cryptoName = "bitcoin";
        CryptoService bitCoinService = new CryptoService();
        BigDecimal currentPrice = bitCoinService.getCryptoPrice(cryptoName);
        assertThat(currentPrice).isNotNull();
    }

    @Test // passed
    void shouldReturnId() {
        String cryptoName = "bitcoin";
        CryptoService bitCoinService = new CryptoService();
        String currentId = bitCoinService.getCryptoName(cryptoName);
        assertThat(currentId).isNotNull();
    }

    @Test // passed
    void shouldReturnConstantBitcoinPrice() {
        String cryptoName = "bitcoin";
        CryptoService cryptoService = new CryptoService();
        BigDecimal firstBitcoinPrice = cryptoService.getCryptoPrice(cryptoName);
        assertThat(firstBitcoinPrice).isNotNull();
        BigDecimal secondBitcoinPrice = cryptoService.getCryptoPrice(cryptoName);
        assertThat(secondBitcoinPrice).isNotNull();
        assertThat(firstBitcoinPrice).isEqualTo(secondBitcoinPrice);
    }

    @Test // passed
    void shouldReturnConstantBitcoinId() {
        String cryptoName = "bitcoin";
        CryptoService cryptoService = new CryptoService();
        String firstBitcoinId = cryptoService.getCryptoName(cryptoName);
        assertThat(firstBitcoinId).isNotNull();
        String secondBitcoinId = cryptoService.getCryptoName(cryptoName);
        assertThat(secondBitcoinId).isNotNull();
        assertThat(firstBitcoinId).isEqualTo(secondBitcoinId);
    }
}
