package com.example.homework12bank.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Customer {

    private String id , username;
    private int balance;

    public int deposit(int amount){
        return balance += amount;
    }
    public int withdraw(int amount){
        if (amount > balance)
            return -1;
        balance -= amount;
        return balance;
    }
}
