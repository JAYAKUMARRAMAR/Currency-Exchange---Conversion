package com.jaya.microservices.currency_exchange_service;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.validation.constraints.NotBlank;

@RestController
public class CurrencyExchangeController {
    
    private static final Logger log = LoggerFactory.getLogger(CurrencyExchangeController.class);
    private final Environment environment;
    private final CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchangeController(Environment environment, CurrencyExchangeRepository currencyExchangeRepository) {
        this.environment = environment;
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
            @PathVariable @NotBlank(message = "Source currency cannot be blank") String from,
            @PathVariable @NotBlank(message = "Target currency cannot be blank") String to) {
        
        log.info("Fetching exchange rate for {} to {}", from, to);
        
        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
        
        if (currencyExchange == null) {
            String message = "Unable to find exchange rate for " + from + " to " + to;
            log.warn(message);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        }
        
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        
        log.info("Exchange rate found: {} to {} = {}", from, to, currencyExchange.getConversionMultiple());
        return currencyExchange;
    }
}
