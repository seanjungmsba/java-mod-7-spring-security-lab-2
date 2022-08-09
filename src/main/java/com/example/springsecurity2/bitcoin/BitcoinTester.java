package com.example.springsecurity2.bitcoin;

import java.math.BigDecimal;

public class BitcoinTester {
    public static void main(String[] args) {
        CryptoService cryptoService = new CryptoService();
        String id = cryptoService.getCryptoName();
        BigDecimal price = cryptoService.getCryptoPrice("bitcoin");
        System.out.println("Cryptocurrency Name: "  + id + " | "  + "Price: $" + price);
    }
}
