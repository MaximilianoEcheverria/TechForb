package com.example.TechForb.service;

import com.example.TechForb.entity.Card;
import com.example.TechForb.repository.CardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Transactional
    public Card save(Card card) throws Exception {
        try {
            return this.cardRepository.save(card);
        }catch (Exception e) {
            throw new Exception();
        }
    }

    @Transactional
    public Card update(int id, Card card) throws Exception {
        try {
            Optional<Card> cardOptional = this.cardRepository.findById(id);
            cardOptional.get().setFullName(card.getFullName());
            cardOptional.get().setDueDate(card.getDueDate());
            cardOptional.get().setCardNumber(card.getCardNumber());
            cardOptional.get().setSecurityCode(card.getSecurityCode());
            cardOptional.get().setUser(card.getUser());
            Card card1  = cardOptional.get();
            return card1;
        }catch (Exception e) {
            throw new Exception();
        }
    }

    @Transactional
    public boolean delete(int id) throws Exception {
        try {
            if(this.cardRepository.existsById(id)){
                this.cardRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }

        }catch (Exception e) {
            throw new Exception();
        }
    }
}
