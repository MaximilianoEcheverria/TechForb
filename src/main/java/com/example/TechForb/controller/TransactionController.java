package com.example.TechForb.controller;

import com.example.TechForb.entity.Transaction;
import com.example.TechForb.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Transaction transaction) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.save(transaction));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Transaction transaction) throws Exception {
        Transaction transaction1 = this.transactionService.update(id,transaction);
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.save(transaction1));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable int id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(transactionService.delete(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }
}
