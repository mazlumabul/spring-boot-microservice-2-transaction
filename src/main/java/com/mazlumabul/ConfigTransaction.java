package com.mazlumabul;

import com.mazlumabul.service.abstracts.TransactionService;
import com.mazlumabul.service.concretes.TransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigTransaction {
    @Bean
    public TransactionService transactionService(){
        return new TransactionManager();
    }
}
