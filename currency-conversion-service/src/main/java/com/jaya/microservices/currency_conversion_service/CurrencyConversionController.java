package com.jaya.microservices.currency_conversion_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CurrencyConversionController
{
    private static final Logger log = LoggerFactory.getLogger(CurrencyConversionController.class);

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to,
                                                  @PathVariable BigDecimal quantity)
    {
        // For now use a default conversion multiple of 1.0. In future this should call the currency-exchange service.
        BigDecimal conversionMultiple = BigDecimal.ONE;
        BigDecimal totalCalculatedAmount = quantity.multiply(conversionMultiple);

        // CurrencyConversion constructor signature is: (String environment, BigDecimal totalCalculatedAmount,
        // BigDecimal quantity, BigDecimal conversionMultiple, String to, String from, Long id)
        CurrencyConversion result = new CurrencyConversion("", totalCalculatedAmount, quantity, conversionMultiple, to, from, 10001L);
        log.debug("Converted {} {}->{} using {} -> total {}", quantity, from, to, conversionMultiple, totalCalculatedAmount);
        return result;
    }
}
