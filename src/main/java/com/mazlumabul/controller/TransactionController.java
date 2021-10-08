package com.mazlumabul.controller;

import com.mazlumabul.model.Transaction;
import com.mazlumabul.service.abstracts.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/transaction")
public class TransactionController {

    @Autowired
    private  TransactionService transactionService;



    @PostMapping
    public ResponseEntity<?> saveTransaction(@RequestBody Transaction transaction){
        return new ResponseEntity<>(transactionService.saveTransaction(transaction), HttpStatus.CREATED);
    }

    @DeleteMapping("{transactionId}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long transactionId){
       transactionService.deleteTransaction(transactionId);
       return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{userId}")
    public ResponseEntity<?> getAllTransactionsOfUser(@PathVariable Long userId){
        return ResponseEntity.ok(transactionService.findAllTransactionsOfUser(userId));
    }
}
