package com.dxc.org.onwallet.controllers;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.org.onwallet.entities.OnlineWallet;
import com.dxc.org.onwallet.exception.OnlineWalletNotFoundException;
import com.dxc.org.onwallet.service.OnlineWalletServiceImpl;

@RestController
@RequestMapping( "/onlinewallet" ) //used to map http request to the handler methods
@CrossOrigin("http://localhost:4200")

public class OnlineWalletRestController {

    @Autowired
    OnlineWalletServiceImpl service;
    @PutMapping(path = "/add/{customerId}/{accountBalance}")
    public ResponseEntity<Boolean> addAmount(@PathVariable int customerId, @PathVariable int accountBalance)
    {

        OnlineWallet onlinewallet = service.addAmount(customerId,accountBalance);
        ResponseEntity<Boolean> responseEntity = new ResponseEntity(true,HttpStatus.OK);
        System.out.println("response entity=" + responseEntity);
        return responseEntity;
    }


    @PostMapping(path = "/create")          //used to bind http request to the object in method
    public ResponseEntity<OnlineWallet> createOnlineWallet(@Valid @RequestBody OnlineWallet onlinewalletbean)
    {

        OnlineWallet onlinewallet = service.createOnlineWallet(onlinewalletbean);
        ResponseEntity<OnlineWallet> responseEntity = new ResponseEntity<OnlineWallet>(onlinewallet, new HttpHeaders(), HttpStatus.OK);

        return responseEntity;
    }

    /* the findOnlineWalletById method is meant to show details of one particular id */

    @GetMapping(path = "/showBalance/{customerId}")
    public ResponseEntity<OnlineWallet> findOnlineWalletById(@PathVariable("customerId") int customerId)
    {
        try {
            OnlineWallet onlinewallet = service.findOnlineWalletById(customerId);
            ResponseEntity<OnlineWallet> responseEntity =new ResponseEntity(onlinewallet,HttpStatus.OK);
            System.out.println("response entity="+responseEntity);
            return responseEntity;
        }catch(Exception e)
        {
            System.err.println("Invalid customer id");
            return new ResponseEntity("Invalid customer id",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/GetAllDetails")
    public ResponseEntity<List<OnlineWallet>> getAlldetails() {

        List<OnlineWallet> onlineewallet = service.getAlldetails();

        System.out.println(onlineewallet);
        return new ResponseEntity<List<OnlineWallet>>(onlineewallet, HttpStatus.OK);
    }
    @ExceptionHandler
    public String inValidInput(Exception e) {
        return e.getMessage();
    }}

