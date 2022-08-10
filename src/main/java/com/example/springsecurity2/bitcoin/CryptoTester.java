package com.example.springsecurity2.bitcoin;

import java.math.BigDecimal;

public class CryptoTester {
    public static void main(String[] args) {
        CryptoService cryptoService = new CryptoService();
        String id = cryptoService.getCryptoName();
        BigDecimal price = cryptoService.getCryptoPrice("bitcoin");
        System.out.println("Cryptocurrency Name: "  + id + " | "  + "Price: $" + price);
    }
}
