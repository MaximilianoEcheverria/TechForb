package com.example.TechForb.service;

import com.example.TechForb.entity.Transaction;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.TechForb.repository.TransactionRepository;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public Transaction save(Transaction transaction) throws Exception {
        try {
            return this.transactionRepository.save(transaction);
        }catch (Exception e) {
            throw new Exception();
        }
    }

    @Transactional
    public Transaction update(int id, Transaction transaction) throws Exception {
        try {
            Optional<Transaction> transactionOptional = transactionRepository.findById(id);
            transactionOptional.get().setAmount(transaction.getAmount());
            transactionOptional.get().setDate(transaction.getDate());
            transactionOptional.get().setUser(transaction.getUser());
            Transaction transaction1  = transactionOptional.get();
            return transaction1;
        }catch (Exception e) {
            throw new Exception();
        }
    }

    @Transactional
    public boolean delete(int id) throws Exception {
        try {
            if(transactionRepository.existsById(id)){
                transactionRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }

        }catch (Exception e) {
            throw new Exception();
        }
    }
}
