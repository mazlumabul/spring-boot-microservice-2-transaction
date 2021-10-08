package com.mazlumabul.service.concretes;

import com.mazlumabul.model.Transaction;
import com.mazlumabul.repository.TransactionRepository;
import com.mazlumabul.service.abstracts.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionManager implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction saveTransaction(Transaction transaction) {

        transaction.setTransactionTime(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Long transactionId) {
        transactionRepository.deleteById(transactionId);
    }

    @Override
    public List<Transaction> findAllTransactionsOfUser(Long userId) {
        return transactionRepository.findAllByUserId(userId);
    }
}
