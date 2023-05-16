package com.example.homework12bank.Controller;

import com.example.homework12bank.Model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/bank")
public class BankController {

    ArrayList<Customer> customers = new ArrayList<>();

    //Get all the customers
    @GetMapping("/display")
    public ArrayList<Customer> display(){
        return customers;
    }

    //Add new customers
    @PostMapping("/add")
    public String createTask(@RequestBody Customer cos){
        customers.add(cos);
        return "Customer added";
    }

    //Update customers
    @PutMapping("/update/{index}")
    public String updateTask(@PathVariable int index,@RequestBody Customer cos){
        if (index > (customers.size()-1))
            return "Not found";
        customers.set(index,cos);
        return "Customer info updated";
    }

    //Delete customers
    @DeleteMapping("/delete/{index}")
    public String deleteTask(@PathVariable int index){
        if (index > (customers.size()-1))
            return "Not found";
        customers.remove(index);
        return "Customer deleted";
    }

    //Deposit money to customer
    @PutMapping("/deposit/{index}")
    public String deposit(@PathVariable int index,@RequestBody int amount){
        customers.get(index).deposit(amount);
        return "Balance updated";
    }

    //Withdraw money from customers
    @PutMapping("/withdraw/{index}")
    public String withdraw(@PathVariable int index,@RequestBody int amount){
        int num =  customers.get(index).withdraw(amount);
        if (num >= 0)
            return "Balance updated";
        return "Invalid";
    }
}
