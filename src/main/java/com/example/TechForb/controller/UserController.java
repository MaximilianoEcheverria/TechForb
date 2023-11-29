package com.example.TechForb.controller;

import com.example.TechForb.entity.User;
import com.example.TechForb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody User user) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(userService.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody User user) throws Exception {
        User usu = this.userService.update(id,user);
        return ResponseEntity.status(HttpStatus.OK).body(userService.save(usu));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable int id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(userService.delete(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }
}
