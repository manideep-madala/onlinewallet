package com.dxc.org.onwallet.service;
import java.util.List;
import java.util.Optional;

import com.dxc.org.onwallet.exception.OnlineWalletNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.org.onwallet.entities.OnlineWallet;
import com.dxc.org.onwallet.repository.OnlineWalletJpaRepo;


@Service
public class OnlineWalletServiceImpl implements IOnlineWalletService{


    @Autowired
    OnlineWalletJpaRepo repository;

    @Override
    public OnlineWallet addAmount(int customerId, int accountBalance) {
        Optional<OnlineWallet> onlinewallet=repository.findById(customerId);
        OnlineWallet wallet = new OnlineWallet();

        wallet.setCustomerId(onlinewallet.get().getCustomerId());
        wallet.setCustomerName(onlinewallet.get().getCustomerName());
        wallet.setAccountBalance(accountBalance+onlinewallet.get().getAccountBalance());
        wallet.setCustomerPassword(onlinewallet.get().getCustomerPassword());
        return repository.saveAndFlush(wallet);
    }


    /* Creates the onlinewallet bean by taking the onlinewalletBean*/
    @Override
    public OnlineWallet createOnlineWallet(OnlineWallet onlinewalletbean) {
        // TODO Auto-generated method stub
        return repository.save(onlinewalletbean);
    }

    /* shows the wallet of particular id*/
    @Override
    public OnlineWallet findOnlineWalletById(int customerId ) {

        if(repository.findById(customerId).isPresent()) {

        }else {
            throw new OnlineWalletNotFoundException("onlinewallet not found for id");
        }
        return repository.findById(customerId).get();

    }


    @Override
    public List<OnlineWallet> getAlldetails() {
        // TODO Auto-generated method stub
        return repository.findAll();
    }




}
