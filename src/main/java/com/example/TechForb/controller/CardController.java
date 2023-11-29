package com.example.TechForb.controller;

import com.example.TechForb.entity.Card;
import com.example.TechForb.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Card card) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.cardService.save(card));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Card card) throws Exception {
        Card card1 = this.cardService.update(id,card);
        return ResponseEntity.status(HttpStatus.OK).body(this.cardService.save(card1));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable int id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(this.cardService.delete(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }
}
