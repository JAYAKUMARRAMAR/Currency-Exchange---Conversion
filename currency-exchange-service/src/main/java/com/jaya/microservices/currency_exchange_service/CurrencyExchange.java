package com.jaya.microservices.currency_exchange_service;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CurrencyExchange {

    @Id
    private Long id;
    
    @Column(name="currency_from")
    private String from;
    
    @Column(name="currency_to")
    private String to;
    
    @Column(name="conversion_multiple")
    private BigDecimal conversionMultiple;
    
    private String environment;

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
