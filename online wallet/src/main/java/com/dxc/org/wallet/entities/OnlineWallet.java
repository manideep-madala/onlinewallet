package com.dxc.org.onwallet.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "Onlinewallet_Spring")

public class OnlineWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int customerId;

    @NotEmpty(message = "password must not be empty")
    @Size(min = 4, message = "passoword should have atleast 4 characters")
    //@Column(name = "customerPassword", nullable = false)
    private String customerPassword;

    @NotEmpty(message="Name is mandatory field. pleaser provide name")
    @Size(min = 3, message = "Name should have atleast 3 characters")
    //@Column(name = "customerName", nullable = false)
    @Pattern(regexp = "^[A-Za-z]*$")
    private String customerName;

    @NotNull
    @Min(value=1,message="Account Balance cannot be less than 1")
    @Max(value=100000,message="Account Balance cannot be greater than 100000")
    private int accountBalance;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

}

