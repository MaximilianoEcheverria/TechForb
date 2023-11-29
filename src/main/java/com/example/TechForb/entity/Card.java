package com.example.TechForb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "cards")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCard;

    @NotBlank
    @Size(max = 40)
    private String fullName;

    @NotBlank
    private Date dueDate;

    @NotBlank
    private String cardNumber;

    @NotBlank
    private String securityCode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
