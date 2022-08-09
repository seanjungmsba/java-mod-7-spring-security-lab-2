package com.example.springsecurity2.bitcoin;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CryptoServiceIntegrationTest {

    @Test // passed
    void shouldReturnPrice() {
        CryptoService bitCoinService = new CryptoService();
        BigDecimal currentPrice = bitCoinService.getCryptoPrice("bitcoin");
        assertThat(currentPrice).isNotNull();
    }

    @Test // passed
    void shouldReturnId() {
        CryptoService bitCoinService = new CryptoService();
        String currentId = bitCoinService.getCryptoName();
        assertThat(currentId).isNotNull();
    }


    @Test // passed
    void shouldReturnConstantBitcoinPrice() {
        CryptoService cryptoService = new CryptoService();
        BigDecimal firstBitcoinPrice = cryptoService.getCryptoPrice("bitcoin");
        assertThat(firstBitcoinPrice).isNotNull();
        BigDecimal secondBitcoinPrice = cryptoService.getCryptoPrice("bitcoin");
        assertThat(secondBitcoinPrice).isNotNull();
        assertThat(firstBitcoinPrice).isEqualTo(secondBitcoinPrice);
    }

    @Test // passed
    void shouldReturnConstantBitcoinId() {
        CryptoService cryptoService = new CryptoService();
        String firstBitcoinId = cryptoService.getCryptoName();
        assertThat(firstBitcoinId).isNotNull();
        String secondBitcoinId = cryptoService.getCryptoName();
        assertThat(secondBitcoinId).isNotNull();
        assertThat(firstBitcoinId).isEqualTo(secondBitcoinId);
    }
}
