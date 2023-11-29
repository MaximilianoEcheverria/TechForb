package com.example.TechForb.service;

import com.example.TechForb.entity.User;
import com.example.TechForb.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User save(User user) throws Exception {
        try {
            return this.userRepository.save(user);
        }catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Transactional
    public User update(int id, User user) throws Exception {
        try {
            Optional<User> userOptional = this.userRepository.findById(id);
            userOptional.get().setName(user.getName());
            userOptional.get().setSurname(user.getSurname());
            userOptional.get().setEmail(user.getEmail());
            userOptional.get().setPassword(user.getEmail());
            User entity  = userOptional.get();
            return entity;
        }catch (Exception e) {
            throw new Exception();
        }
    }

    @Transactional
    public boolean delete(int id) throws Exception {
        try {
            if(this.userRepository.existsById(id)){
                this.userRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }

        }catch (Exception e) {
            throw new Exception();
        }
    }
}
